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
    var url : ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_feed_list)


        recyclerview_feed.adapter = multiAdapter

        viewManager = LinearLayoutManager(this)
        recyclerview_feed.layoutManager = viewManager


        company.add("에이앤에프")
        company.add("오리젠")
        company.add("오가닉스토리")
        company.add("에이앤에프")
        company.add("에이앤에프")

        item.add("유기농 6Free 연어")
        item.add("6피쉬 독")
        item.add("70% 유기농 가수분해 소고기")
        item.add("95% 유기농 닭고기")
        item.add("95% 유기농 양고기")

        price.add("12,000원")
        price.add("25,000원")
        price.add("59,000원")
        price.add("28,000원")
        price.add("40,700원")

        images.add(R.drawable.item1)
        images.add(R.drawable.item2)
        images.add(R.drawable.item3)
        images.add(R.drawable.item4)
        images.add(R.drawable.item5)

        url.add("https://msearch.shopping.naver.com/catalog/22470189919?NaPm=ct%3Dl2tyy988%7Cci%3D9c607787f1ae12b9a160aea221d2837fd0365a0a%7Ctr%3Dslsl%7Csn%3D95694%7Chk%3D7936d2aa19b20c02a557997b387d1441d8b6fdd9&purchaseConditionSequence=20082201&query=%EC%9C%A0%EA%B8%B0%EB%86%8D6free%20%EC%97%B0%EC%96%B4&sort=LOW_PRICE")
        url.add("https://search.shopping.naver.com/search/all?query=6%ED%94%BC%EC%89%AC%20%EB%8F%85&frm=NVSHATC&prevQuery=95%25%20%EC%9C%A0%EA%B8%B0%EB%86%8D%20%EC%96%91%EA%B3%A0%EA%B8%B0")
        url.add("https://search.shopping.naver.com/search/all?query=70%25%20%EC%9C%A0%EA%B8%B0%EB%86%8D%20%EA%B0%80%EC%88%98%EB%B6%84%ED%95%B4%20%EC%86%8C%EA%B3%A0%EA%B8%B0&frm=NVSHATC&prevQuery=anf%20%EC%B9%98%ED%82%A8%EC%82%AC%EB%A3%8C")
        url.add("https://search.shopping.naver.com/search/all?query=95%25%20%EC%9C%A0%EA%B8%B0%EB%86%8D%20%EB%8B%AD%EA%B3%A0%EA%B8%B0%20%EA%B0%95%EC%95%84%EC%A7%80%EC%82%AC%EB%A3%8C&frm=NVSHATC&prevQuery=95%25%20%EC%9C%A0%EA%B8%B0%EB%86%8D%20%EB%8B%AD%EA%B3%A0%EA%B8%B0%20%EC%82%AC%EB%A3%8C")
        url.add("https://search.shopping.naver.com/search/all?query=95%25%20%EC%9C%A0%EA%B8%B0%EB%86%8D%20%EC%96%91%EA%B3%A0%EA%B8%B0&frm=NVSHATC&prevQuery=95%25%20%EC%9C%A0%EA%B8%B0%EB%86%8D%20%EC%96%91%EA%B3%A0%EA%B8%B0%20%EA%B0%95%EC%95%84%EC%A7%80%EC%82%AC%EB%A3%8C")



        for (i : Int in 0 .. 4)
        {
            datas1.add(FeedItem(company[i],item[i], price[i],images[i],0,url[i]))
        }


        multiAdapter.datas = datas1
        multiAdapter.notifyDataSetChanged()


        multiAdapter.setItemClickListener(object: Adapter1.OnItemClickListener{
            override fun onClick(v: View, position: Int) {

                    val nextIntent = Intent(baseContext, DogFeedItemInfo::class.java)
                    nextIntent.putExtra("image",images[position])
                    nextIntent.putExtra("company",company[position])
                    nextIntent.putExtra("item",item[position])
                    nextIntent.putExtra("cost",item[position])
                    nextIntent.putExtra("url",url[position])
                    startActivity(nextIntent)


            }
        })


    }




}

