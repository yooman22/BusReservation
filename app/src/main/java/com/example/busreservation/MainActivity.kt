package com.example.busreservation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.busreservation.R
import com.example.busreservation.SmsAPI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next.setOnClickListener{
            val nextIntent = Intent(this, Login::class.java)
            startActivity(nextIntent)
        }

        smsButton.setOnClickListener {
            val smsAPI: SmsAPI = SmsAPI("no");
            smsAPI.start();
            smsAPI.join();
        }

    }
}