package com.example.busreservation

import Network.RetrofitClient
import Network.RetrofitService
import VO.ListVO
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_departure.*
import kotlinx.android.synthetic.main.activity_destination.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Destination : AppCompatActivity() {

    var list = ArrayList<String>()

    var multiAdapter = Adapter(this)

    private lateinit var viewManager: RecyclerView.LayoutManager
    val datas1 = mutableListOf<DataItem>()

    var destination_name_txt : ArrayList<String> = arrayListOf()
    var destination_id_txt : ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination)

        //val destination_txt = arrayOf("울산대학교앞", "울산대학교후문", "현대청운고앞","현대중공업일산문","천상1교사거리","천상중학교")

        //val adapter_destination = ArrayAdapter(this, android.R.layout.simple_list_item_1, destination_txt)

        //destination_list.setAdapter(adapter_destination)

        var list = ArrayList<String>()

        recyclerview_destination.adapter = multiAdapter

        viewManager = LinearLayoutManager(this)
        recyclerview_destination.layoutManager = viewManager



        val api = RetrofitClient.getInstance().create(RetrofitService::class.java)
        val callGetLogin = api.API_List("1")
            .enqueue(object : Callback<ListVO> {
                override fun onResponse(call: Call<ListVO>, response: Response<ListVO>) {
                    Log.d("결과", "성공 : ${response.raw()}")
                    Log.d("결과", "성공 : ${response.body()?.result}")
                    response.body()?.let {
                        datas1.add(DataItem("하이","hello",0))

                        for(i in it.result) {
                            destination_name_txt.add(i.stationName)
                            destination_id_txt.add(i.stationID)
                            Log.d("결과", "성공 : " + i)
                            datas1.add(DataItem(i.stationID,i.stationName,1))
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
                intent.putExtra("destination_data", datas1[position].title)
                intent.putExtra("destination_data2", datas1[position].body)
                setResult(RESULT_OK, intent)

                finish()
            }
        })


        edit_txt1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {

                val datas1_copy = mutableListOf<DataItem>()

                for(i in datas1) {
                    if(i.title.contains(edit_txt1.text))
                    {
                        datas1_copy.add(i);
                    }
                }

                multiAdapter.datas = datas1_copy
                multiAdapter.notifyDataSetChanged()

            }
        })


    }
}