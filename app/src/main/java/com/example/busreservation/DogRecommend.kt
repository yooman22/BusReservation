package com.example.busreservation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_dog_recommend.*
import kotlinx.android.synthetic.main.activity_dog_registration_one.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DogRecommend : AppCompatActivity() {

    var dogProteinList : MutableList<DogProteinItem> = arrayListOf()

    var dogFavorList : MutableList<DogProteinItem> = arrayListOf()
    var dogHateList : MutableList<DogProteinItem> = arrayListOf()

    var favorCount = 0
    var hateCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_recommend)

        dogProteinList.add(DogProteinItem("소고기",false,-1))
        dogProteinList.add(DogProteinItem("닭고기",false,-1))
        dogProteinList.add(DogProteinItem("생선",false,-1))
        dogProteinList.add(DogProteinItem("칠면조",false,-1))
        dogProteinList.add(DogProteinItem("양고기",false,-1))
        dogProteinList.add(DogProteinItem("돼지고기",false,-1))
        dogProteinList.add(DogProteinItem("오리고기",false,-1))
        dogProteinList.add(DogProteinItem("사슴고기",false,-1))
        dogProteinList.add(DogProteinItem("토끼고기",false,-1))
        dogProteinList.add(DogProteinItem("식물성 단백질",false,-1))

        confirm_recommand.setOnClickListener {
            val nextIntent = Intent(this, DogFeedList::class.java)
            startActivity(nextIntent)
        }

        val startForResult_favor = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult -> if (result.resultCode == Activity.RESULT_OK) {

            val intent = result.data!! // Handle the Intent //do stuff here
            for(i : Int in 0 .. 9) {
                dogProteinList[i].type = intent.getIntExtra("type"+i+1, -1)
                dogProteinList[i].Flag = intent.getBooleanExtra("btn"+i+1, false)

                if(dogProteinList[i].type == 0)
                {
                    dogHateList.add(dogProteinList[i])
                    hateCount++
                }
                else if(dogProteinList[i].type == 1)
                {
                    dogFavorList.add(dogProteinList[i])
                    favorCount++
                }

            }

            var count = dogFavorList.count()

            if(count==0){
                favorView(false,0)
            }

            if(count !=0){
                favorView(true,count)
                setFavorView(count,dogFavorList)
            }

            dogHateList.clear()
            dogFavorList.clear()


            }
        }

        favor1.setOnClickListener{
            val nextIntent = Intent(this, DogProtein::class.java)
            nextIntent.putExtra("fh",1)
            for(i : Int in 0 .. 9){
                nextIntent.putExtra("btn"+i+1,dogProteinList[i].Flag)
                nextIntent.putExtra("type"+i+1,dogProteinList[i].type)
            }
            startForResult_favor.launch(nextIntent)


        }

        val startForResult_hate = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult -> if (result.resultCode == Activity.RESULT_OK) {

            val intent = result.data!! // Handle the Intent //do stuff here
            for(i : Int in 0 .. 9) {
                dogProteinList[i].type = intent.getIntExtra("type"+i+1, -1)
                dogProteinList[i].Flag = intent.getBooleanExtra("btn"+i+1, false)

                if(dogProteinList[i].type == 0)
                {
                    dogHateList.add(dogProteinList[i])
                    hateCount++
                }
                else if(dogProteinList[i].type == 1)
                {
                    dogFavorList.add(dogProteinList[i])
                    favorCount++
                }
            }

            var count = dogHateList.count()

            if(count == 0){
                hateView(false,0)
            }

            if(count !=0){
                hateView(true,count)
                setHateView(count,dogHateList)
            }

            dogHateList.clear()
            dogFavorList.clear()

            }
        }

        hate1.setOnClickListener{
            val nextIntent = Intent(this, DogProtein::class.java)
            nextIntent.putExtra("fh",0)
            for(i : Int in 0 .. 9){
                nextIntent.putExtra("btn"+i+1,dogProteinList[i].Flag)
                nextIntent.putExtra("type"+i+1,dogProteinList[i].type)
            }
            startForResult_hate.launch(nextIntent)
        }

        feed1.setOnClickListener {
            feed1.setBackgroundResource(R.drawable.edge_green_btn)
        }
        feed2.setOnClickListener {
            feed2.setBackgroundResource(R.drawable.edge_green_btn)
        }
        feed3.setOnClickListener {
            feed3.setBackgroundResource(R.drawable.edge_green_btn)
        }
        feed4.setOnClickListener {
            feed4.setBackgroundResource(R.drawable.edge_green_btn)
        }
        feed5.setOnClickListener {
            feed5.setBackgroundResource(R.drawable.edge_green_btn)
        }
        feed6.setOnClickListener {
            feed6.setBackgroundResource(R.drawable.edge_green_btn)
        }

        health1.setOnClickListener {
            health1.setBackgroundResource(R.drawable.edge_green_btn)
        }

        health2.setOnClickListener {
            health2.setBackgroundResource(R.drawable.edge_green_btn)
        }

        health3.setOnClickListener {
            health3.setBackgroundResource(R.drawable.edge_green_btn)
        }

        health4.setOnClickListener {
            health4.setBackgroundResource(R.drawable.edge_green_btn)
        }

        ingredient1.setOnClickListener {
            ingredient1.setBackgroundResource(R.drawable.edge_green_btn)
        }

        ingredient2.setOnClickListener {
            ingredient2.setBackgroundResource(R.drawable.edge_green_btn)
        }

        ingredient3.setOnClickListener {
            ingredient3.setBackgroundResource(R.drawable.edge_green_btn)
        }

        ingredient4.setOnClickListener {
            ingredient4.setBackgroundResource(R.drawable.edge_green_btn)
        }

        ingredient5.setOnClickListener {
            ingredient5.setBackgroundResource(R.drawable.edge_green_btn)
        }

        ingredient6.setOnClickListener {
            ingredient6.setBackgroundResource(R.drawable.edge_green_btn)
        }

        ingredient7.setOnClickListener {
            ingredient7.setBackgroundResource(R.drawable.edge_green_btn)
        }

        ingredient8.setOnClickListener {
            ingredient8.setBackgroundResource(R.drawable.edge_green_btn)
        }

        ingredient9.setOnClickListener {
            ingredient9.setBackgroundResource(R.drawable.edge_green_btn)
        }

        ingredient10.setOnClickListener {
            ingredient10.setBackgroundResource(R.drawable.edge_green_btn)

        }

        ingredient11.setOnClickListener {
            ingredient11.setBackgroundResource(R.drawable.edge_green_btn)

        }

        ingredient12.setOnClickListener {
            ingredient12.setBackgroundResource(R.drawable.edge_green_btn)

        }

        ingredient13.setOnClickListener {
            ingredient13.setBackgroundResource(R.drawable.edge_green_btn)

        }

        ingredient14.setOnClickListener {
            ingredient14.setBackgroundResource(R.drawable.edge_green_btn)

        }

        ingredient15.setOnClickListener {
            ingredient15.setBackgroundResource(R.drawable.edge_green_btn)

        }

        ingredient16.setOnClickListener {
            ingredient16.setBackgroundResource(R.drawable.edge_green_btn)

        }

        ingredient17.setOnClickListener {
            ingredient17.setBackgroundResource(R.drawable.edge_green_btn)

        }

        ingredient18.setOnClickListener {
            ingredient18.setBackgroundResource(R.drawable.edge_green_btn)

        }

        ingredient19.setOnClickListener {
            ingredient19.setBackgroundResource(R.drawable.edge_green_btn)

        }

        ingredient20.setOnClickListener {
            ingredient20.setBackgroundResource(R.drawable.edge_green_btn)

        }

    }


    fun hateView(flag : Boolean,Count : Int){
        if(flag)
        {
            when(Count)
            {
                1-> hate1.visibility = View.VISIBLE

                2-> {
                    hate1.visibility = View.VISIBLE
                    hate2.visibility = View.VISIBLE
                }
                3-> {
                    hate1.visibility = View.VISIBLE
                    hate2.visibility = View.VISIBLE
                    hate3.visibility = View.VISIBLE
                }
                4-> {
                    hate1.visibility = View.VISIBLE
                    hate2.visibility = View.VISIBLE
                    hate3.visibility = View.VISIBLE
                    hate4.visibility = View.VISIBLE
                }
            }

        }
        else {
            hate1.visibility = View.INVISIBLE
            hate2.visibility = View.INVISIBLE
            hate3.visibility = View.INVISIBLE
            hate4.visibility = View.INVISIBLE

        }
    }

    fun setHateView(count: Int,list: MutableList<DogProteinItem>){
        when(count)
        {
            1-> hate1.setText(list[0].title)

            2-> {
                hate1.setText(list[0].title)
                hate2.setText(list[1].title)
            }
            3-> {
                hate1.setText(list[0].title)
                hate2.setText(list[1].title)
                hate3.setText(list[2].title)
            }
            4-> {
                hate1.setText(list[0].title)
                hate2.setText(list[1].title)
                hate3.setText(list[2].title)
                hate4.setText(list[3].title)
            }
        }
    }

    fun favorView(flag: Boolean,Count : Int){
        if(flag)
        {
            when(Count)
            {
                1-> favor1.visibility = View.VISIBLE

                2-> {
                    favor1.visibility = View.VISIBLE
                    favor2.visibility = View.VISIBLE
                }
                3-> {
                    favor1.visibility = View.VISIBLE
                    favor2.visibility = View.VISIBLE
                    favor3.visibility = View.VISIBLE
                }
                4-> {
                    favor1.visibility = View.VISIBLE
                    favor2.visibility = View.VISIBLE
                    favor3.visibility = View.VISIBLE
                    favor4.visibility = View.VISIBLE
                }
            }
        }
        else {
            favor1.visibility = View.INVISIBLE
            favor2.visibility = View.INVISIBLE
            favor3.visibility = View.INVISIBLE
            favor4.visibility = View.INVISIBLE
        }
    }

    fun setFavorView(count : Int ,list: MutableList<DogProteinItem> )
    {
        when(count)
        {
            1-> favor1.setText(list[0].title)

            2-> {
                favor1.setText(list[0].title)
                favor2.setText(list[1].title)
            }
            3-> {
                favor1.setText(list[0].title)
                favor2.setText(list[1].title)
                favor3.setText(list[2].title)
            }
            4-> {
                favor1.setText(list[0].title)
                favor2.setText(list[1].title)
                favor3.setText(list[2].title)
                favor4.setText(list[3].title)
            }
        }
    }




}

data class DogProteinItem(
    var title : String ,
    var Flag : Boolean,
    var type : Int
)