package com.example.busreservation

import Network.RetrofitClient
import Network.RetrofitService
import VO.LoginVO
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navi.setOnClickListener {
            val nextIntent = Intent(this, BusReservation::class.java)
            startActivity(nextIntent)
        }

        val api = RetrofitClient.getInstance().create(RetrofitService::class.java)
        val callGetLogin = api.API_Login("yooman22","qpalzm")
            .enqueue(object : Callback<LoginVO>{
            override fun onResponse(call: Call<LoginVO>, response: Response<LoginVO>) {
                Log.d("결과", "성공 : ${response.raw()}")
            }

            override fun onFailure(call: Call<LoginVO>, t: Throwable) {
                Log.d("결과:", "실패 : $t")
            }
        })




    }
}
