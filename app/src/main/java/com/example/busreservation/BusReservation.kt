package com.example.busreservation
import Network.RetrofitClient
import Network.RetrofitService
import VO.ListBusVO
import VO.ListVO
import android.R.attr
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.view.ContextThemeWrapper
import kotlinx.android.synthetic.main.activity_bus_reservation.*
import android.R.attr.data
import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_departure.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BusReservation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_reservation)

        var text = ""


        val builder = AlertDialog.Builder(
            ContextThemeWrapper(
                this,
                R.style.ThemeOverlay_AppCompat
            )
        )
        builder.setTitle("저상버스를 예약하시겠습니까?")
        //builder.setMessage("메시지 내용")
        builder.setPositiveButton(
            "예"
        ) { dialog, id -> }

        builder.setNegativeButton(
            "아니오"
        ) { dialog, id -> }
        builder.show()

        departure.setOnClickListener{
            val nextIntent = Intent(this, Departure::class.java)
            startActivityForResult(nextIntent,1)
        }

        destination.setOnClickListener{
            val nextIntent = Intent(this, Destination::class.java)
            startActivityForResult(nextIntent,2)
        }

        reservation.setOnClickListener{
            builder.setTitle(text +" 예약하시겠습니까?")
            //builder.setMessage("메시지 내용")
            builder.setPositiveButton(
                "예"
            ) { dialog, id -> }

            builder.setNegativeButton(
                "아니오"
            ) { dialog, id -> }
            builder.show()
        }

        bus_list.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, v: View, position: Int, id: Long) {

                // get TextView's Text.
                val strText = parent.getItemAtPosition(position) as String
                text = strText
            }
        }

    }





    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode === 1 && resultCode === RESULT_OK) {
            var result = data?.getStringExtra("depature_data").toString()
            departure_result.text = result
        }

        if (requestCode === 2 && resultCode === RESULT_OK) {
            var result = data?.getStringExtra("destination_data").toString()
            destination_result.text = result
        }

        if(destination_result.text != "" && departure_result.text != ""){

            val bus_txt = arrayListOf<String>()

            val adapter_departure = ArrayAdapter(this, android.R.layout.simple_list_item_1, bus_txt)

            val api = RetrofitClient.getInstance().create(RetrofitService::class.java)

            Log.d("결과 : ", (departure_result.text as String).trim())

            val callGetLogin = api.API_BUS_List((departure_result.text as String).trim() )
                .enqueue(object : Callback<ListBusVO> {
                    override fun onResponse(call: Call<ListBusVO>, response: Response<ListBusVO>) {
                        Log.d("결과", "성공 : ${response.raw()}")
                        response.body()?.let {
                            for(i in it.Result) {
                                adapter_departure.add(i.RouteNumber)
                                Log.d("결과", "성공 : " + i)
                            }
                            //val adapter_departure = ArrayAdapter(this, android.R.layout.simple_list_item_1, bus_txt)
                            bus_list.setAdapter(adapter_departure)
                        }
                    }
                    override fun onFailure(call: Call<ListBusVO>, t: Throwable) {
                        Log.d("결과:", "실패 : $t")
                    }
                })


        }
    }



}