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
import android.app.LauncherActivity

import android.content.Intent
import android.os.Handler
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread
import android.widget.ArrayAdapter as ArrayAdapter
import android.widget.ListAdapter as ListAdapter1


class Departure : AppCompatActivity() {

    var list = ArrayList<String>()

    var result : ListVO = ListVO(list)
    var multiAdapter = Adapter(this)

    private lateinit var viewManager: RecyclerView.LayoutManager
    val datas1 = mutableListOf<DataItem>()

    var departure_txt : ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_departure)

        recyclerview_departure.adapter = multiAdapter

        viewManager = LinearLayoutManager(this)
        recyclerview_departure.layoutManager = viewManager

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
                            datas1.add(DataItem(i,i))
                        }

                        multiAdapter.datas = datas1
                        multiAdapter.notifyDataSetChanged()

                    }

                }
                override fun onFailure(call: Call<ListVO>, t: Throwable) {

                    Log.d("결과:", "실패 : $t")
                }
            })





            multiAdapter.setItemClickListener(object: Adapter.OnItemClickListener{
                override fun onClick(v: View, position: Int) {
                    val intent = Intent() //startActivity()를 할것이 아니므로 그냥 빈 인텐트로 만듦

                    intent.putExtra("depature_data", datas1[position].title)
                    intent.putExtra("depature_data2", datas1[position].body)
                    setResult(AppCompatActivity.RESULT_OK, intent)
                    finish()
                }
            })


        }

}
