package com.example.animal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.busreservation.R
import kotlinx.android.synthetic.main.activity_quiz_main.*

class QuizMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_main)

        yes.setOnClickListener{
            val nextIntent = Intent(this, Quiz_Detail::class.java)
            startActivity(nextIntent)
        }

        no.setOnClickListener{
            finish()
        }

    }
}