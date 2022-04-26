package com.example.busreservation

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory

import com.google.android.gms.maps.model.MarkerOptions

import com.google.android.gms.maps.model.LatLng

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest

import com.google.android.gms.maps.model.Marker

import com.google.android.gms.location.LocationServices

import com.google.android.gms.location.LocationSettingsRequest

import android.view.WindowManager

import com.google.android.gms.maps.model.BitmapDescriptorFactory
import androidx.core.content.ContextCompat
import android.os.Looper
import android.location.LocationManager
import android.content.DialogInterface

import android.content.Intent
import android.location.Address
import com.google.android.gms.location.LocationResult

import com.google.android.gms.location.LocationCallback
import android.widget.Toast

import android.location.Geocoder
import android.provider.Settings
import com.google.android.material.snackbar.Snackbar
import java.io.IOException
import java.lang.IllegalArgumentException
import java.util.*

class DogMap : AppCompatActivity(), OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback {

    private lateinit var mMap: GoogleMap
    private var currentMarker: Marker? = null

    private val TAG = "googlemap_example"
    private val GPS_ENABLE_REQUEST_CODE = 2001
    private val UPDATE_INTERVAL_MS:Long = 1000 // 1초
    private val FASTEST_UPDATE_INTERVAL_MS:Long = 500 // 0.5초

    private val PERMISSIONS_REQUEST_CODE = 100
    var needRequest = false

    var REQUIRED_PERMISSIONS = arrayOf<String>(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )

    var mCurrentLocatiion: Location? = null
    var currentPosition: LatLng? = null

    private var mFusedLocationClient: FusedLocationProviderClient? = null   //위치정보를 요정하는 객체(어플을 실행항 전자기기(this))
    private var locationRequest: LocationRequest? = null
    private var location: Location? = null

    private var mLayout : View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_map)

        mLayout = findViewById(R.id.layout_main)

        locationRequest = LocationRequest()
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
            .setInterval(UPDATE_INTERVAL_MS) //위치가 update 되는 주기
            .setFastestInterval(FASTEST_UPDATE_INTERVAL_MS)

        val builder = LocationSettingsRequest.Builder()

        builder.addLocationRequest(locationRequest!!)

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        println("onMapReady()....")
        Log.d(TAG,"onMapReady:")

        mMap = googleMap

        //런타임 퍼미션 요청 대화상자나 GPS 활성 요청 대화상자 보이기전에
        //지도의 초기위치를 서울로 이동
        setDefaultLocation()

        //런타임 퍼미션 처리
        // 1. 위치 퍼미션을 가지고 있는지 체크합니다.
        //런타임 퍼미션 처리
        // 1. 위치 퍼미션을 가지고 있는지 체크합니다.
        val hasFineLocationPermission = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)
        val hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)

        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
            hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED   ) {

            // 2. 이미 퍼미션을 가지고 있다면
            // ( 안드로이드 6.0 이하 버전은 런타임 퍼미션이 필요없기 때문에 이미 허용된 걸로 인식합니다.)
            startLocationUpdates() // 3. 위치 업데이트 시작


        }else {  //2. 퍼미션 요청을 허용한 적이 없다면 퍼미션 요청이 필요합니다. 2가지 경우(3-1, 4-1)가 있습니다.

            // 3-1. 사용자가 퍼미션 거부를 한 적이 있는 경우에는
            //→ 사용자가 권한 요청을 명시적으로 거부한 경우 true를 반환한다.
            //→ 사용자가 권한 요청을 처음 보거나, 다시 묻지 않음 선택한 경우, 권한을 허용한 경우 false를 반환한다.
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])){
                // 3-2. 요청을 진행하기 전에 사용자가에게 퍼미션이 필요한 이유를 설명해줄 필요가 있습니다.
                Snackbar.make(mLayout as View, "이 앱을 실행하려면 위치 접근 권한이 필요합니다.", Snackbar.LENGTH_INDEFINITE)
                    .setAction("확인",View.OnClickListener { view ->
                        // 3-3. 사용자게에 퍼미션 요청을 합니다. 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                        ActivityCompat.requestPermissions(
                            this,
                            REQUIRED_PERMISSIONS,
                            PERMISSIONS_REQUEST_CODE
                        )
                    }).show()
            }else{
                // 4-1. 사용자가 퍼미션 거부를 한 적이 없는 경우에는 퍼미션 요청을 바로 합니다.
                // 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions( this, REQUIRED_PERMISSIONS,PERMISSIONS_REQUEST_CODE);
            }
        }

        mMap!!.uiSettings.isMyLocationButtonEnabled = true //현재 위치 아이콘 활성화
        mMap!!.setOnMapClickListener(GoogleMap.OnMapClickListener { latLng ->
            Log.d(TAG,"onMapClick:")
        })
    }

    private var locationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            super.onLocationResult(locationResult)

            val locationList = locationResult.locations

            if (locationList.size > 0) {
                location = locationList[locationList.size - 1]

                currentPosition = LatLng(location!!.latitude, location!!.longitude)
                val markerTitle: String = getCurrentAddress(currentPosition!!)
                val markerSnippet =
                    "위도:" + location!!.latitude.toString() + " 경도:" + location!!.longitude.toString()
                Log.d(TAG, "onLocationResult : $markerSnippet")


                //현재 위치에 마커 생성하고 이동
                setCurrentLocation(location!!, markerTitle, markerSnippet)
                mCurrentLocatiion = location
            }
        }
    }

    private fun startLocationUpdates(){
        if(!checkLocationServicesStatus()){
            Log.d(TAG, "startLocationUpdates : call showDialogForLocationServiceSetting")
            showDialogForLocationServiceSetting()
            //startActivityForResult(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS),100)
        }else{
            val hasFineLocationPermission = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)
            val hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)

            if (hasFineLocationPermission != PackageManager.PERMISSION_GRANTED ||
                hasCoarseLocationPermission != PackageManager.PERMISSION_GRANTED   ) {

                Log.d(TAG, "startLocationUpdates : 퍼미션 안가지고 있음")
                return
            }
            Log.d(TAG, "startLocationUpdates : call mFusedLocationClient.requestLocationUpdates")

            mFusedLocationClient!!.requestLocationUpdates(locationRequest!!, locationCallback,
                Looper.myLooper()!!
            )

            if (checkPermission())
                mMap!!.setMyLocationEnabled(true)
        }

    }
    protected override fun onStop() {
        println("onStop()...")
        super.onStop()

        if(mFusedLocationClient != null){
            Log.d(TAG, "onStop : call stopLocationUpdates");
            mFusedLocationClient?.removeLocationUpdates(locationCallback);
        }
    }

    fun getCurrentAddress(latlng: LatLng): String {
        //지오코더... GPS를 주소로 변환
        var geocoder = Geocoder(this, Locale.getDefault())

        var addresses : List<Address>

        try{
            addresses = geocoder.getFromLocation(latlng.latitude,latlng.longitude,1)

        }catch(ioException: IOException){
            //네트워크 문제
            Toast.makeText(this, "지오코더 서비스 사용불가", Toast.LENGTH_LONG).show()
            return "지오코더 서비스 사용불가"
        }catch(illegalArgumentException:IllegalArgumentException){
            Toast.makeText(this, "잘못된 GPS 좌표", Toast.LENGTH_LONG).show()
            return "잘못된 GPS 좌표"
        }

        return if (addresses == null || addresses.isEmpty()) {
            Toast.makeText(this, "주소 미발견", Toast.LENGTH_LONG).show()
            "주소 미발견"
        } else {
            val address: Address = addresses[0]
            address.getAddressLine(0).toString()
        }

    }

    private fun checkLocationServicesStatus(): Boolean {
        val locationManager:LocationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        return (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
    }

    fun setCurrentLocation(location: Location, markerTitle: String?, markerSnippet: String?) {
        if (currentMarker != null) currentMarker!!.remove()

        //현재 스쿨버스 위치 -> DB에 저장
        val currentLatLng = LatLng(location.latitude, location.longitude)

        val latitude = location.latitude.toString()
        val longitude = location.longitude.toString()

        //val requestURL = "http://10.0.2.2:8080/insertCurrentLatLng.do?latitude=$latitude&longitude=$longitude"


        //val task:URLConnector = URLConnector(requestURL)

        //task.start()
        //task.join()

        val markerOptions = MarkerOptions()
        markerOptions.position(currentLatLng)
        markerOptions.title(markerTitle)
        markerOptions.snippet(markerSnippet)
        markerOptions.draggable(true)
        currentMarker = mMap!!.addMarker(markerOptions)
        val cameraUpdate = CameraUpdateFactory.newLatLng(currentLatLng)
        mMap!!.moveCamera(cameraUpdate)
    }

    private fun setDefaultLocation() {
        //디폴트 위치, Seoul
        val default_location = LatLng(37.56, 126.97)
        val markerTitle = "위치정보 가져올 수 없음"
        val markerSnippet = "위치 퍼미션과 GPS 활성 요부 확인하세요"
        currentMarker?.remove() //if(currentMarker != null)currentMarKer.remove() 같은 의미
        val markerOptions = MarkerOptions()
        markerOptions.position(default_location)
        markerOptions.title(markerTitle)
        markerOptions.snippet(markerSnippet)
        markerOptions.draggable(true)
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        currentMarker = mMap!!.addMarker(markerOptions)
        val cameraUpdate = CameraUpdateFactory.newLatLngZoom(default_location, 15f)
        mMap!!.moveCamera(cameraUpdate)
    }

    private fun checkPermission(): Boolean {
        //ContextCompat.checkSelfPermission : 해당 앱에 대한 권한 보유 여부 체크
        val hasFineLocationPermission = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)
        val hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)

        if(hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED){
            return true
        }
        return false
    }

    override fun onRequestPermissionsResult(
        permsRequestCode: Int,
        permissions: Array<out String>,
        grandResults: IntArray
    ) {
        println("onRequestPermissionResult()...")
        super.onRequestPermissionsResult(permsRequestCode, permissions, grandResults)
        if ( permsRequestCode == PERMISSIONS_REQUEST_CODE && grandResults.size == REQUIRED_PERMISSIONS.size){
            // 요청 코드가 PERMISSIONS_REQUEST_CODE 이고, 요청한 퍼미션 개수만큼 수신되었다면
            var check_result = true

            // 모든 퍼미션을 허용했는지 체크합니다.
            for (result in grandResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false
                    break
                }
            }

            if(check_result){
                // 퍼미션을 허용했다면 위치 업데이트를 시작합니다.
                startLocationUpdates();
            }else{
                // 거부한 퍼미션이 있다면 앱을 사용할 수 없는 이유를 설명해주고 앱을 종료합니다.2 가지 경우가 있습니다.

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])
                    || ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[1])){

                    // 사용자가 거부만 선택한 경우에는 앱을 다시 실행하여 허용을 선택하면 앱을 사용할 수 있습니다.
                    Snackbar.make(mLayout as View, "퍼미션이 거부되었습니다. 앱을 다시 실행하여 퍼미션을 허용해주세요. ",
                        Snackbar.LENGTH_INDEFINITE).setAction("확인",View.OnClickListener {
                            view -> finish()
                    }).show()
                }else{
                    // "다시 묻지 않음"을 사용자가 체크하고 거부를 선택한 경우에는 설정(앱 정보)에서 퍼미션을 허용해야 앱을 사용할 수 있습니다.
                    Snackbar.make(mLayout as View, "퍼미션이 거부되었습니다. 설정(앱 정보)에서 퍼미션을 허용해야 합니다. ",
                        Snackbar.LENGTH_INDEFINITE).setAction("확인",View.OnClickListener {
                            view -> finish()
                    }).show()
                }
            }
        }

    }

    private fun showDialogForLocationServiceSetting() {
        val builder = AlertDialog.Builder(this@DogMap)
        builder.setTitle("위치 서비스 비활성화")
        builder.setMessage(
            """
            앱을 사용하기 위해서는 위치 서비스가 필요합니다.
            위치 설정을 수정하실래요?
            """.trimIndent()
        )
        builder.setCancelable(true)

        builder.setPositiveButton("설정",DialogInterface.OnClickListener {
                dialog,which ->
            var callGPSSettingIntent = Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE)
        })

        builder.setNegativeButton("취소",DialogInterface.OnClickListener{
                dialog,which ->
            dialog.cancel()
        })

        builder.create().show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            GPS_ENABLE_REQUEST_CODE ->
                //사용자가 GPS 활성 시켰는지 검사
                if (checkLocationServicesStatus()) {
                    if (checkLocationServicesStatus()) {
                        Log.d(TAG, "onActivityResult : GPS 활성화 되있음")
                        needRequest = true
                        startLocationUpdates()
                        return
                    }
                }
        }
    }

}