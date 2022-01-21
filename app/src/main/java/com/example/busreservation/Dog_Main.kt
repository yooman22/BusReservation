package com.example.animal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.busreservation.R
import kotlinx.android.synthetic.main.activity_dog_main.*

class Dog_Main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_main)

        quiz_view.setOnClickListener{
            val nextIntent = Intent(this, QuizMain::class.java)
            startActivity(nextIntent);

        }

        introduce_view.setOnClickListener{
            val nextIntent = Intent(this, Dog_Introduce::class.java)
            startActivity(nextIntent);

        }

        favor.setOnClickListener{


        }

    }
}