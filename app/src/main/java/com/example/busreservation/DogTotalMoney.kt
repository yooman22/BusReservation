package com.example.busreservation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dog_total_money.*

class DogTotalMoney : AppCompatActivity() {

    var select = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_total_money)


        btn_A.setOnClickListener {
            select = 0
            btn_A.background = getResources().getDrawable(R.drawable.edge_gray)
            btn_B.background = getResources().getDrawable(R.drawable.edge_white)
            btn_C.background = getResources().getDrawable(R.drawable.edge_white)
            btn_D.background = getResources().getDrawable(R.drawable.edge_white)
            btn_E.background = getResources().getDrawable(R.drawable.edge_white)

        }

        btn_B.setOnClickListener {
            select = 1
            btn_A.background = getResources().getDrawable(R.drawable.edge_white)
            btn_B.background = getResources().getDrawable(R.drawable.edge_gray)
            btn_C.background = getResources().getDrawable(R.drawable.edge_white)
            btn_D.background = getResources().getDrawable(R.drawable.edge_white)
            btn_E.background = getResources().getDrawable(R.drawable.edge_white)

        }

        btn_C.setOnClickListener {
            select = 2
            btn_A.background = getResources().getDrawable(R.drawable.edge_white)
            btn_B.background = getResources().getDrawable(R.drawable.edge_white)
            btn_C.background = getResources().getDrawable(R.drawable.edge_gray)
            btn_D.background = getResources().getDrawable(R.drawable.edge_white)
            btn_E.background = getResources().getDrawable(R.drawable.edge_white)

        }

        btn_D.setOnClickListener {
            select = 3
            btn_A.background = getResources().getDrawable(R.drawable.edge_white)
            btn_B.background = getResources().getDrawable(R.drawable.edge_white)
            btn_C.background = getResources().getDrawable(R.drawable.edge_white)
            btn_D.background = getResources().getDrawable(R.drawable.edge_gray)
            btn_E.background = getResources().getDrawable(R.drawable.edge_white)

        }

        btn_E.setOnClickListener {
            select = 4
            btn_A.background = getResources().getDrawable(R.drawable.edge_white)
            btn_B.background = getResources().getDrawable(R.drawable.edge_white)
            btn_C.background = getResources().getDrawable(R.drawable.edge_white)
            btn_D.background = getResources().getDrawable(R.drawable.edge_white)
            btn_E.background = getResources().getDrawable(R.drawable.edge_gray)

        }



        confirm_money.setOnClickListener{

            when(select)
            {
                0-> {
                    if(SharedPreference.prefs.getInt("expensive1",0) == -1)
                    {
                        SharedPreference.prefs.setInt("expensive1",edit_B.text.toString().toInt())
                    }else{
                        var cost = SharedPreference.prefs.getInt("expensive1",0)
                        cost += edit_B.text.toString().toInt()
                        SharedPreference.prefs.setInt("expensive1",cost)
                    }
                }
                1-> {
                    if(SharedPreference.prefs.getInt("expensive2",0) == -1)
                    {
                        SharedPreference.prefs.setInt("expensive2",edit_B.text.toString().toInt())
                    }else{
                        var cost = SharedPreference.prefs.getInt("expensive2",0)
                        cost += edit_B.text.toString().toInt()
                        SharedPreference.prefs.setInt("expensive2",cost)
                    }
                }
                2-> {
                    if(SharedPreference.prefs.getInt("expensive3",0) == -1)
                    {
                        SharedPreference.prefs.setInt("expensive3",edit_B.text.toString().toInt())
                    }else{
                        var cost = SharedPreference.prefs.getInt("expensive3",0)
                        cost += edit_B.text.toString().toInt()
                        SharedPreference.prefs.setInt("expensive3",cost)
                    }
                }
                3-> {
                    if(SharedPreference.prefs.getInt("expensive4",0) == -1)
                    {
                        SharedPreference.prefs.setInt("expensive4",edit_B.text.toString().toInt())
                    }else{
                        var cost = SharedPreference.prefs.getInt("expensive4",0)
                        cost += edit_B.text.toString().toInt()
                        SharedPreference.prefs.setInt("expensive4",cost)
                    }
                }
                4-> {
                    if(SharedPreference.prefs.getInt("expensive5",0) == -1)
                    {
                        SharedPreference.prefs.setInt("expensive5",edit_B.text.toString().toInt())
                    }else{
                        var cost = SharedPreference.prefs.getInt("expensive5",0)
                        cost += edit_B.text.toString().toInt()
                        SharedPreference.prefs.setInt("expensive5",cost)
                    }
                }
            }

            finish()
        }



    }


}