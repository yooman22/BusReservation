package com.example.busreservation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dog_registration_two.*
import kotlinx.android.synthetic.main.activity_dog_weight.*

class DogWeight : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_weight)

        btn_A.setOnClickListener {
            calc_View.visibility = View.VISIBLE
            user_View.visibility = View.GONE

            btn_A.background = getResources().getDrawable(R.drawable.edge_green_btn)
            btn_B.background = getResources().getDrawable(R.drawable.edge)

        }

        btn_B.setOnClickListener {
            calc_View.visibility = View.GONE
            user_View.visibility = View.VISIBLE

            btn_A.background = getResources().getDrawable(R.drawable.edge)
            btn_B.background = getResources().getDrawable(R.drawable.edge_green_btn)

        }

        confirm_weight.setOnClickListener {

            if(calc_View.visibility == View.VISIBLE) {

                var weight_dog = edit_A.text.toString().toLong() - edit_B.text.toString().toLong()

                if (weight_dog < 0 || edit_A.text.toString().isNullOrEmpty() ||  edit_B.text.toString().isNullOrEmpty()  ) {
                    Toast.makeText(this, "잘못된 입력 입니다.", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                SharedPreference.prefs.setString("dog_weight",weight_dog.toString())
                finish()
            }

            if(user_View.visibility == View.VISIBLE){

                if (edit_C.text.toString().isNullOrEmpty() ) {
                    Toast.makeText(this, "잘못된 입력 입니다.", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                SharedPreference.prefs.setString("dog_weight",edit_C.text.toString())
                finish()
            }



        }


    }
}