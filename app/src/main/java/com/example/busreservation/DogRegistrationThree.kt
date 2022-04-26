package com.example.busreservation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dog_registration_three.*
import kotlinx.android.synthetic.main.activity_dog_registration_two.*
import server.conn.ServerAPI

class DogRegistrationThree : AppCompatActivity() {

    var baby = false
    var hour = false
    var allergy = false

    var list : List<String> = listOf("알레르기","장","치아/구강","비만","뼈/관절","피부/모질","노령","신장/요로","호흡기","심장","당뇨","눈/귀","행동")

    // 12 버튼 갯수 확인
    var list_click = mutableListOf<Boolean>()

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

        for(i: Int in 1..12 ){
            list_click.add(false)
        }

        var click_count = 0;

        confirm2.setOnClickListener{

            SharedPreference.prefs.setBool("Save",true);
            SharedPreference.prefs.setInt("dateMonth",0);

            var hashMap  = HashMap<String,String>()

            hashMap.put("name",name.toString());
            hashMap.put("date",date.toString());

            hashMap.put("weight",weight.toString());
            hashMap.put("gander",gander.toString());
            hashMap.put("animal",animal.toString());
            hashMap.put("neutrality",neutrality.toString());
            hashMap.put("dateMonth",dateMonth.toString());

            hashMap.put("allergy",allergy.toString());
            hashMap.put("hour",hour.toString());
            hashMap.put("allergy",allergy.toString());

            var trueList : String = ""
            var trueCount = 0
            for(i: Int in 0..12 ){
                if(list_click[i]){
                    trueCount++
                    trueList += list[i].toString()
                    if(click_count > trueCount){
                        trueList += ","
                    }
                }
            }
            hashMap.put("trueList",trueList);

            var serverAPI: ServerAPI = ServerAPI(7,hashMap);
            serverAPI.start();
            serverAPI.join();

            val nextIntent = Intent(this, DogPage::class.java)
            startActivity(nextIntent)
        }

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
            baby_yes.background = getResources().getDrawable(R.drawable.edge)
            baby_no.background = getResources().getDrawable(R.drawable.edge_green_btn)
        }

        hour_yes.setOnClickListener{
            hour = true
            hour_yes.background = getResources().getDrawable(R.drawable.edge_green_btn)
            hour_no.background = getResources().getDrawable(R.drawable.edge)
        }

        hour_no.setOnClickListener{
            hour = false
            hour_yes.background = getResources().getDrawable(R.drawable.edge)
            hour_no.background = getResources().getDrawable(R.drawable.edge_green_btn)
        }

        btn_1.setOnClickListener{

            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(list_click[0]) return@setOnClickListener

            btn_1.background = getResources().getDrawable(R.drawable.edge_green_btn)
            list_click[0] = true
            click_count++

        }

        btn_2.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(list_click[1]) return@setOnClickListener

            btn_2.background = getResources().getDrawable(R.drawable.edge_green_btn)
            list_click[1] = true
            click_count++
        }

        btn_3.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(list_click[2]) return@setOnClickListener

            btn_3.background = getResources().getDrawable(R.drawable.edge_green_btn)
            list_click[2] = true
            click_count++
        }

        btn_4.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(list_click[3]) return@setOnClickListener

            btn_4.background = getResources().getDrawable(R.drawable.edge_green_btn)
            list_click[3] = true
            click_count++
        }

        btn_5.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(list_click[4]) return@setOnClickListener

            btn_5.background = getResources().getDrawable(R.drawable.edge_green_btn)
            list_click[4] = true
            click_count++
        }

        btn_6.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(list_click[5]) return@setOnClickListener

            btn_6.background = getResources().getDrawable(R.drawable.edge_green_btn)
            list_click[5] = true
            click_count++
        }

        btn_7.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(list_click[6]) return@setOnClickListener

            btn_7.background = getResources().getDrawable(R.drawable.edge_green_btn)
            list_click[6] = true
            click_count++
        }

        btn_8.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(list_click[7]) return@setOnClickListener

            btn_8.background = getResources().getDrawable(R.drawable.edge_green_btn)
            list_click[7] = true
            click_count++
        }

        btn_9.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(list_click[8]) return@setOnClickListener

            btn_9.background = getResources().getDrawable(R.drawable.edge_green_btn)
            list_click[8] = true
            click_count++
        }

        btn_10.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(list_click[9]) return@setOnClickListener

            btn_10.background = getResources().getDrawable(R.drawable.edge_green_btn)
            list_click[9] = true
            click_count++
        }

        btn_11.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(list_click[10]) return@setOnClickListener

            btn_11.background = getResources().getDrawable(R.drawable.edge_green_btn)
            list_click[10] = true
            click_count++
        }

        btn_12.setOnClickListener{
            if(click_count == 3){
                Toast.makeText(this,"3개 선적이 끝났습니다.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(list_click[11]) return@setOnClickListener

            btn_12.background = getResources().getDrawable(R.drawable.edge_green_btn)
            list_click[11] = true
            click_count++
        }

    }
}