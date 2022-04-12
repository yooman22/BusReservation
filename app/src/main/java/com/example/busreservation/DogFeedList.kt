package com.example.busreservation

import Network.RetrofitClient
import Network.RetrofitService
import VO.ListVO
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_departure.*
import kotlinx.android.synthetic.main.activity_dog_feed_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogFeedList : AppCompatActivity() {

    var list = ArrayList<String>()
    var multiAdapter = Adapter1(this)

    private lateinit var viewManager: RecyclerView.LayoutManager
    val datas1 = mutableListOf<FeedItem>()

    var company : ArrayList<String> = arrayListOf()
    var item : ArrayList<String> = arrayListOf()
    var price : ArrayList<String> = arrayListOf()
    var images : ArrayList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_feed_list)


        recyclerview_feed.adapter = multiAdapter

        viewManager = LinearLayoutManager(this)
        recyclerview_feed.layoutManager = viewManager


        company.add("에이앤에프")
        company.add("에이앤에프")
        company.add("알파스피릿")
        company.add("토스칸")
        company.add("더독")

        item.add("유기농 6Free 연어")
        item.add("램 홀리스틱 시니어")
        item.add("닭고기와 강황 캔")
        item.add("하베스트")
        item.add("닥터소프트 양고기&감자")

        price.add("12,000원")
        price.add("9,000원")
        price.add("4,000원")
        price.add("20,000원")
        price.add("19,900원")

        images.add(R.drawable.item1)
        images.add(R.drawable.item2)
        images.add(R.drawable.item3)
        images.add(R.drawable.item4)
        images.add(R.drawable.item5)


        for (i : Int in 0 .. 4)
        {
            datas1.add(FeedItem(company[i],item[i], price[i],images[i],0))
        }


        multiAdapter.datas = datas1
        multiAdapter.notifyDataSetChanged()


        multiAdapter.setItemClickListener(object: Adapter1.OnItemClickListener{
            override fun onClick(v: View, position: Int) {

                if(position == 0){
                    val nextIntent = Intent(baseContext, DogFeedItemInfo::class.java)
                    nextIntent.putExtra("image",images[position])
                    nextIntent.putExtra("company",company[position])
                    nextIntent.putExtra("item",item[position])
                    nextIntent.putExtra("cost",item[position])
                    startActivity(nextIntent)
                }

            }
        })


    }




}

