package com.example.busreservation

import Network.RetrofitClient
import Network.RetrofitService
import VO.ListVO
import VO.LoginVO
import VO.station
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
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import server.conn.ServerAPI
import kotlin.concurrent.thread
import android.widget.ArrayAdapter as ArrayAdapter
import android.widget.ListAdapter as ListAdapter1


class DogAdd : AppCompatActivity() {

    var list = ArrayList<String>()
    var multiAdapter = Adapter(this)

    private lateinit var viewManager: RecyclerView.LayoutManager
    val datas1 = mutableListOf<DataItem>()

    var departure_id_txt : ArrayList<String> = arrayListOf()
    var departure_name_txt : ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_add)


        var serverAPI: ServerAPI = ServerAPI(8,hashMapOf<String,String>())
        serverAPI.start();
        serverAPI.join();

        serverAPI.getOutput()

        val json = serverAPI.output

        var stringBuilder : StringBuilder  = StringBuilder()
        var jsonArray = JSONArray(json);

        recyclerview_departure.adapter = multiAdapter

        viewManager = LinearLayoutManager(this)
        recyclerview_departure.layoutManager = viewManager


        datas1.add(DataItem("새로운 아이 등록하기","hello",0))

        for( i in 0 .. jsonArray.length()-1)
        {
            var jsonObject = jsonArray.getJSONObject(i)
            var name : String = jsonObject.getString("pet_name");
            var gender : String = jsonObject.getString("gender");
            var trueList : String = jsonObject.getString("trueList");
            var dateMonth : String = jsonObject.getString("dateMonth")
            var weight : String = jsonObject.getString("weight")
            var animal : String = jsonObject.getString("animal")
            var allergy : String = jsonObject.getString("allergy")
            var neutrality : String = jsonObject.getString("neutrality")
            var age : String = jsonObject.getString("age")
            var walk : String = jsonObject.getString("walk")

            datas1.add(DataItem(name,trueList,1))
        }

        multiAdapter.datas = datas1
        multiAdapter.notifyDataSetChanged()


        multiAdapter.setItemClickListener(object: Adapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
//                val intent = Intent() //startActivity()를 할것이 아니므로 그냥 빈 인텐트로 만듦
//
//                intent.putExtra("depature_data", datas1[position].title)
//                intent.putExtra("depature_data2", datas1[position].body)
//                setResult(AppCompatActivity.RESULT_OK, intent)
//                finish()

                if(position == 0){
                    val nextIntent = Intent(baseContext, DogInfo::class.java)
                    startActivity(nextIntent)
                }

            }
        })
    }

}
