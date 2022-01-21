package com.example.animal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_find_id_result.*
import android.content.Intent
import com.example.busreservation.R


class Find_ID_Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id_result)


        resultId.text = intent.extras?.get("id")!!.toString()

        moveLoginButton.setOnClickListener{
            val nextIntent = Intent(this, Login::class.java)
            startActivity(nextIntent);
        }

        moveFindPwdButton.setOnClickListener{
            val nextIntent = Intent(this, Find_Password::class.java)
            startActivity(nextIntent);
        }
    }
}