package com.example.animal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.busreservation.R
import kotlinx.android.synthetic.main.activity_dog_introduce_detail.*
import kotlinx.android.synthetic.main.activity_quiz_result.*

class Dog_Introduce_detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_introduce_detail)

        
        var index = intent.getIntExtra("index",0)
        var dog = intent.getStringExtra("Dog")
        var dog_content = intent.getStringExtra("intro")

        dog_name.text = dog
        content_txt.text = dog_content

        when (index) {
            0 -> dog_main.setImageResource(R.drawable.p1)
            1 -> dog_main.setImageResource(R.drawable.p2)
            2 -> dog_main.setImageResource(R.drawable.p3)
            3 -> dog_main.setImageResource(R.drawable.p4)
            4 -> dog_main.setImageResource(R.drawable.p5)
            5 -> dog_main.setImageResource(R.drawable.p6)
            6 -> dog_main.setImageResource(R.drawable.p7)
            7 -> dog_main.setImageResource(R.drawable.p8)
            8 -> dog_main.setImageResource(R.drawable.p9)

            else -> print("default")
        }






    }
}