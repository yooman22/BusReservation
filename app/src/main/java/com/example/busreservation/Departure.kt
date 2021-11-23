package com.example.busreservation

import Network.RetrofitClient
import Network.RetrofitService
import VO.ListVO
import VO.LoginVO
import VO.data
import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_departure.*
import android.R.attr.data
import android.app.Activity

import android.content.Intent
import android.os.Handler
import android.util.Log
import android.widget.ListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread
import android.widget.ArrayAdapter as ArrayAdapter


class Departure : AppCompatActivity() {

    var departure_txt : ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_departure)

        var list = ArrayList<String>()

        var result : ListVO = ListVO(list)

        val adapter_departure = ArrayAdapter(this, android.R.layout.simple_list_item_1, departure_txt)

        val api = RetrofitClient.getInstance().create(RetrofitService::class.java)
        val callGetLogin = api.API_List("1")
            .enqueue(object : Callback<ListVO> {
                override fun onResponse(call: Call<ListVO>, response: Response<ListVO>) {
                    Log.d("결과", "성공 : ${response.raw()}")
                    Log.d("결과", "성공 : ${response.body()?.result}")
                    response.body()?.let {
                        result = it

                        for(i in result.result) {
                            departure_txt.add(i)
                            Log.d("결과", "성공 : " + i)
                            adapter_departure.add(i)
                        }
                        departure_list.setAdapter(adapter_departure)

                    }

                }
                override fun onFailure(call: Call<ListVO>, t: Throwable) {

                    Log.d("결과:", "실패 : $t")
                }
            })

        //val departure_txt = arrayOf("울산대학교앞", "울산대학교후문", "현대청운고앞","현대중공업일산문","천상1교사거리","천상중학교")



        departure_list.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, v: View, position: Int, id: Long) {

                // get TextView's Text.
                val strText = parent.getItemAtPosition(position) as String

                val intent = Intent() //startActivity()를 할것이 아니므로 그냥 빈 인텐트로 만듦
                intent.putExtra("depature_data", strText)
                setResult(RESULT_OK, intent)

                finish()

                // TODO : use strText
            }
        }
    }

}
