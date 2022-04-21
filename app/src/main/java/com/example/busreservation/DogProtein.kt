package com.example.busreservation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dog_protein.*

class DogProtein : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_protein)

        var flag = false

        var dogScreenList_ : MutableList<Boolean> = arrayListOf()
        var dogTypeList_ : MutableList<Int> = arrayListOf()

        var favor_Count = 0
        var hate_Count = 0

        for(i : Int in 0 .. 9) {
            dogScreenList_.add(intent.getBooleanExtra("btn"+i+1, false))
            var type = intent.getIntExtra("type"+i+1,-1)
            if(type == 0){
                hate_Count++
                setViewRed(i+1)
            }
            else if(type == 1){
                favor_Count++
                setViewGreen(i+1)
            }
            dogTypeList_.add(type)
        }




        var favorHateFlag = intent.getIntExtra("fh",-1)

        if(favorHateFlag == 0){ // 싫어하는
            title_.setText("싫어하는 단백질원")
            flag = false
        }else { // 좋아하는
            title_.setText("좋아하는 단백질원")
            flag = true
        }
        
        btn_food1.setOnClickListener {
            if(dogScreenList_[0] || favor_Count == 4 || hate_Count == 4){
                Toast.makeText(this,"선택이 불가능 합니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            dogScreenList_[0] = true

            if(flag)
            {
                favor_Count++
                dogTypeList_[0] = 1
                btn_food1.setBackgroundResource(R.drawable.edge_green_btn)
            }else {
                hate_Count++
                dogTypeList_[0] = 0
                btn_food1.setBackgroundResource(R.drawable.edge_red_btn)
            }

        }

        btn_food2.setOnClickListener {
            if(dogScreenList_[1]|| favor_Count == 4 || hate_Count == 4){
                Toast.makeText(this,"선택이 불가능 합니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            dogScreenList_[1] = true

            if(flag)
            {
                favor_Count++
                dogTypeList_[1] = 1
                btn_food2.setBackgroundResource(R.drawable.edge_green_btn)
            }else {
                hate_Count++
                dogTypeList_[1] = 0
                btn_food2.setBackgroundResource(R.drawable.edge_red_btn)
            }
        }

        btn_food3.setOnClickListener {
            if(dogScreenList_[2]|| favor_Count == 4 || hate_Count == 4){
                Toast.makeText(this,"선택이 불가능 합니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            dogScreenList_[2] = true

            if(flag)
            {
                favor_Count++
                dogTypeList_[2] = 1
                btn_food3.setBackgroundResource(R.drawable.edge_green_btn)
            }else {
                hate_Count++
                dogTypeList_[2] = 0
                btn_food3.setBackgroundResource(R.drawable.edge_red_btn)
            }
        }

        btn_food4.setOnClickListener {
            if(dogScreenList_[3]|| favor_Count == 4 || hate_Count == 4){
                Toast.makeText(this,"선택이 불가능 합니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            dogScreenList_[3] = true

            if(flag)
            {
                favor_Count++
                dogTypeList_[3] = 1
                btn_food4.setBackgroundResource(R.drawable.edge_green_btn)
            }else {
                hate_Count++
                dogTypeList_[3] = 0
                btn_food4.setBackgroundResource(R.drawable.edge_red_btn)
            }
        }

        btn_food5.setOnClickListener {
            if(dogScreenList_[4]|| favor_Count == 4 || hate_Count == 4){
                Toast.makeText(this,"선택이 불가능 합니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            dogScreenList_[4] = true

            if(flag)
            {
                favor_Count++
                dogTypeList_[4] = 1
                btn_food5.setBackgroundResource(R.drawable.edge_green_btn)
            }else {
                hate_Count++
                dogTypeList_[4] = 0
                btn_food5.setBackgroundResource(R.drawable.edge_red_btn)
            }
        }

        btn_food6.setOnClickListener {
            if(dogScreenList_[5]|| favor_Count == 4 || hate_Count == 4){
                Toast.makeText(this,"선택이 불가능 합니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            dogScreenList_[5] = true

            if(flag)
            {
                favor_Count++
                dogTypeList_[5] = 1
                btn_food6.setBackgroundResource(R.drawable.edge_green_btn)
            }else {
                hate_Count++
                dogTypeList_[5] = 0
                btn_food6.setBackgroundResource(R.drawable.edge_red_btn)
            }
        }

        btn_food7.setOnClickListener {
            if(dogScreenList_[6]|| favor_Count == 4 || hate_Count == 4){
                Toast.makeText(this,"선택이 불가능 합니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            dogScreenList_[6] = true

            if(flag)
            {
                favor_Count++
                dogTypeList_[6] = 1
                btn_food7.setBackgroundResource(R.drawable.edge_green_btn)
            }else {
                hate_Count++
                dogTypeList_[6] = 0
                btn_food7.setBackgroundResource(R.drawable.edge_red_btn)
            }
        }

        btn_food8.setOnClickListener {
            if(dogScreenList_[7]|| favor_Count == 4 || hate_Count == 4){
                Toast.makeText(this,"선택이 불가능 합니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            dogScreenList_[7] = true

            if(flag)
            {
                favor_Count++
                dogTypeList_[7] = 1
                btn_food8.setBackgroundResource(R.drawable.edge_green_btn)
            }else {
                hate_Count++
                dogTypeList_[7] = 0
                btn_food8.setBackgroundResource(R.drawable.edge_red_btn)
            }
        }

        btn_food9.setOnClickListener {
            if(dogScreenList_[8]|| favor_Count == 4 || hate_Count == 4){
                Toast.makeText(this,"선택이 불가능 합니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            dogScreenList_[8] = true

            if(flag)
            {
                favor_Count++
                dogTypeList_[8] = 1
                btn_food9.setBackgroundResource(R.drawable.edge_green_btn)
            }else {
                hate_Count++
                dogTypeList_[8] = 0
                btn_food9.setBackgroundResource(R.drawable.edge_red_btn)
            }
        }

        btn_food10.setOnClickListener {
            if(dogScreenList_[9]|| favor_Count == 4 || hate_Count == 4){
                Toast.makeText(this,"선택이 불가능 합니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            dogScreenList_[9] = true

            if(flag)
            {
                favor_Count++
                dogTypeList_[9] = 1
                btn_food10.setBackgroundResource(R.drawable.edge_green_btn)
            }else {
                hate_Count++
                dogTypeList_[9] = 0
                btn_food10.setBackgroundResource(R.drawable.edge_red_btn)
            }
        }

        confirm.setOnClickListener {
            for(i : Int in 0 .. 9) {
                intent.putExtra("btn"+i+1,dogScreenList_[i])
                intent.putExtra("type"+i+1,dogTypeList_[i])
            }
            setResult(AppCompatActivity.RESULT_OK, intent)
            finish()
        }



    }

    fun setViewGreen(i : Int){
        when(i){
            1-> btn_food1.setBackgroundResource(R.drawable.edge_green_btn)
            2-> btn_food2.setBackgroundResource(R.drawable.edge_green_btn)
            3-> btn_food3.setBackgroundResource(R.drawable.edge_green_btn)
            4-> btn_food4.setBackgroundResource(R.drawable.edge_green_btn)
            5-> btn_food5.setBackgroundResource(R.drawable.edge_green_btn)
            6-> btn_food6.setBackgroundResource(R.drawable.edge_green_btn)
            7-> btn_food7.setBackgroundResource(R.drawable.edge_green_btn)
            8-> btn_food8.setBackgroundResource(R.drawable.edge_green_btn)
            9-> btn_food9.setBackgroundResource(R.drawable.edge_green_btn)
            10-> btn_food10.setBackgroundResource(R.drawable.edge_green_btn)
        }
    }

    fun setViewRed(i : Int){
        when(i){
            1-> btn_food1.setBackgroundResource(R.drawable.edge_red_btn)
            2-> btn_food2.setBackgroundResource(R.drawable.edge_red_btn)
            3-> btn_food3.setBackgroundResource(R.drawable.edge_red_btn)
            4-> btn_food4.setBackgroundResource(R.drawable.edge_red_btn)
            5-> btn_food5.setBackgroundResource(R.drawable.edge_red_btn)
            6-> btn_food6.setBackgroundResource(R.drawable.edge_red_btn)
            7-> btn_food7.setBackgroundResource(R.drawable.edge_red_btn)
            8-> btn_food8.setBackgroundResource(R.drawable.edge_red_btn)
            9-> btn_food9.setBackgroundResource(R.drawable.edge_red_btn)
            10-> btn_food10.setBackgroundResource(R.drawable.edge_red_btn)
        }
    }

}