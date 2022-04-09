package com.example.busreservation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dog_registration_three.*
import kotlinx.android.synthetic.main.activity_dog_registration_two.*

class DogRegistrationThree : AppCompatActivity() {

    var baby = false
    var hour = false
    var allergy = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_registration_three)

        var name = intent.getStringExtra("name")
        var date = intent.getStringExtra("date")
        var weight = intent.getStringExtra("weight")
        var gander = intent.getBooleanExtra("gander",false) // false 남성, true 여성
        var animal = intent.getBooleanExtra("animal",false) // true 강아지,false 고양이
        var neutrality = intent.getBooleanExtra("neutrality",false) // 중성화 yes , 중성화 no
        var dateMonth = intent.getIntExtra("dateMonth",-1) // 강아지 나이 측정 위해 저장
        
        name_.setText(name)
        date_.setText(name+","+date)

        confirm2.setOnClickListener{

            SharedPreference.prefs.setBool("Save",true);

            val nextIntent = Intent(this, DogPage::class.java)
            startActivity(nextIntent)
        }

        var list : List<String> = listOf("알레르기","장","치아/구강","비만","뼈/관절","피부/모질","노령","신장/요로","호흡기","심장","당뇨","눈/귀","행동")

        // 12 버튼 갯수 확인
        var list_click = mutableListOf<Boolean>()

        for(i: Int in 1..12 ){
            list_click.add(false)
        }

        var click_count = 0;


        allergy_yes.setOnClickListener{
            allergy = true
            allergy_yes.background = getResources().getDrawable(R.drawable.edge_green_btn)
            allergy_no.background = getResources().getDrawable(R.drawable.edge)
        }

        allergy_no.setOnClickListener{
            allergy = false
            allergy_yes.background = getResources().getDrawable(R.drawable.edge)
            allergy_no.background = getResources().getDrawable(R.drawable.edge_green_btn)
        }

        baby_yes.setOnClickListener{
            baby = true
            baby_yes.background = getResources().getDrawable(R.drawable.edge_green_btn)
            baby_no.background = getResources().getDrawable(R.drawable.edge)
        }

        baby_no.setOnClickListener{
            baby = false
            baby_yes.background = getResources().getDrawable(R.drawable.edge_green_btn)
            baby_no.background = getResources().getDrawable(R.drawable.edge)
        }

        hour_yes.setOnClickListener{
            hour = true
            hour_yes.background = getResources().getDrawable(R.drawable.edge_green_btn)
            hour_no.background = getResources().getDrawable(R.drawable.edge)
        }

        hour_no.setOnClickListener{
            hour = false
            hour_yes.background = getResources().getDrawable(R.drawable.edge_green_btn)
            hour_no.background = getResources().getDrawable(R.drawable.edge)
        }

        btn_1.setOnClickListener{

            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
            }

            if(list_click[0]) return@setOnClickListener

            list_click[0] = true
            click_count++

        }

        btn_2.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
            }

            if(list_click[1]) return@setOnClickListener

            list_click[1] = true
            click_count++
        }

        btn_3.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
            }

            if(list_click[2]) return@setOnClickListener

            list_click[2] = true
            click_count++
        }

        btn_4.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
            }

            if(list_click[3]) return@setOnClickListener

            list_click[3] = true
            click_count++
        }

        btn_5.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
            }

            if(list_click[4]) return@setOnClickListener

            list_click[4] = true
            click_count++
        }

        btn_6.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
            }

            if(list_click[5]) return@setOnClickListener

            list_click[5] = true
            click_count++
        }

        btn_7.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
            }

            if(list_click[6]) return@setOnClickListener

            list_click[6] = true
            click_count++
        }

        btn_8.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
            }

            if(list_click[7]) return@setOnClickListener

            list_click[7] = true
            click_count++
        }

        btn_9.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
            }

            if(list_click[8]) return@setOnClickListener

            list_click[8] = true
            click_count++
        }

        btn_10.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
            }

            if(list_click[9]) return@setOnClickListener

            list_click[9] = true
            click_count++
        }

        btn_11.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
            }

            if(list_click[10]) return@setOnClickListener

            list_click[10] = true
            click_count++
        }

        btn_12.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
            }

            if(list_click[11]) return@setOnClickListener

            list_click[11] = true
            click_count++
        }

    }
}