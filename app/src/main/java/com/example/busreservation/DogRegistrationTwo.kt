package com.example.busreservation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_dog_registration_one.*
import kotlinx.android.synthetic.main.activity_dog_registration_two.date
import kotlinx.android.synthetic.main.activity_dog_registration_two.name
import kotlinx.android.synthetic.main.activity_dog_registration_two.*
import java.text.SimpleDateFormat
import java.util.*

class DogRegistrationTwo : AppCompatActivity() {

    var gander = false
    var yesno = false
    var dogcat = false // dog : true , cat : false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_registration_two)

        name.setText(intent.getStringExtra("name").toString())
        date.setText(intent.getStringExtra("name").toString() + "," + intent.getStringExtra("date").toString())

        confirm1.setOnClickListener {

            if(weight.getText().toString() == "" || dog_type.getText().toString() == ""){
                Toast.makeText(getApplicationContext(),"미 입력 항목이 있습니다.", Toast.LENGTH_LONG).show()
            }else {
                val nextIntent = Intent(this, DogRegistrationThree::class.java)
                nextIntent.putExtra("name",name.getText().toString())
                nextIntent.putExtra("date",intent.getStringExtra("date").toString())
                nextIntent.putExtra("weight",weight.getText().toString())
                nextIntent.putExtra("gander",gander) // false 남성, true 여성
                nextIntent.putExtra("animal",dogcat) // true 강아지,false 고양이
                nextIntent.putExtra("neutrality",yesno) // 중성화 yes , 중성화 no
                nextIntent.putExtra("dateMonth",intent.getIntExtra("dateMonth",-1))
                nextIntent.putExtra("dog_type",dog_type.getText().toString())
                startActivity(nextIntent)
                //finish()
            }

        }

        man.setOnClickListener{
            gander = false
            man.background = getResources().getDrawable(R.drawable.edge_green_btn)
            woman.background = getResources().getDrawable(R.drawable.edge)
        }

        woman.setOnClickListener{
            gander = true
            man.background = getResources().getDrawable(R.drawable.edge)
            woman.background = getResources().getDrawable(R.drawable.edge_green_btn)
        }

        no.setOnClickListener{
            yesno = false
            no.background = getResources().getDrawable(R.drawable.edge_green_btn)
            yes.background = getResources().getDrawable(R.drawable.edge)
        }

        yes.setOnClickListener {
            yesno = true
            no.background = getResources().getDrawable(R.drawable.edge)
            yes.background = getResources().getDrawable(R.drawable.edge_green_btn)
        }

        dog.setOnClickListener{
            dogcat = true
            cat.isChecked = false
            dog.isChecked = true
        }

        cat.setOnClickListener{
            dogcat = false
            cat.isChecked = true
            dog.isChecked = false
        }

        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    result: ActivityResult -> if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data // Handle the Intent //do stuff here

                var dogSelect = result.data!!.getStringExtra("dogselect")
                dog_type.setText(dogSelect)
            }
        }

        dogListView.setOnClickListener{
            val nextIntent = Intent(this, DogList::class.java)
            startForResult.launch(nextIntent)

            confirm1.background = getResources().getDrawable(R.drawable.edge_green_btn)
        }


    }

}

