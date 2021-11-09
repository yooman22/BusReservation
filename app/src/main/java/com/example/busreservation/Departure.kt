package com.example.busreservation

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_departure.*
import android.R.attr.data
import android.app.Activity

import android.content.Intent




class Departure : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_departure)

        val departure_txt = arrayOf("울산대학교앞", "울산대학교후문", "현대청운고앞","현대중공업일산문","천상1교사거리","천상중학교")

        val adapter_departure = ArrayAdapter(this, android.R.layout.simple_list_item_1, departure_txt)

        departure_list.setAdapter(adapter_departure)

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