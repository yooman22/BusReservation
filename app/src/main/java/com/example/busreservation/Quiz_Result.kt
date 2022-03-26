package com.example.busreservation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.busreservation.R
import kotlinx.android.synthetic.main.activity_quiz_result.*


class Quiz_Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

        var count = intent.getIntExtra("count",0)

        quiz_result.text = count.toString() + " / 10개 맞추셨습니다."

        complete.setOnClickListener{
            val intent = Intent(this, Dog_Main::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}