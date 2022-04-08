package com.example.busreservation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_dog_list.*

class DogList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_list)

        val arrayOfListView = ArrayList<String>()

        arrayOfListView.add("말티즈")
        arrayOfListView.add("푸들")
        arrayOfListView.add("시츄")
        arrayOfListView.add("믹스견")
        arrayOfListView.add("요크셔테리어")
        arrayOfListView.add("포메라니안")
        arrayOfListView.add("골든 리트리버")
        arrayOfListView.add("치와와")
        arrayOfListView.add("닥스훈트")
        arrayOfListView.add("짓돗개")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayOfListView)

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent() //startActivity()를 할것이 아니므로 그냥 빈 인텐트로 만듦

            intent.putExtra("dogselect", arrayOfListView[position])
            setResult(AppCompatActivity.RESULT_OK, intent)
            finish()


        }

    }
}