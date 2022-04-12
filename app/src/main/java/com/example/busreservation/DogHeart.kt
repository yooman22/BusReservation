package com.example.busreservation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dog_heart.*

class DogHeart : AppCompatActivity() {

    var now = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_heart)

        confirm_heart.setOnClickListener {
            SharedPreference.prefs.setBigInteger("heartDate",now)
            finish()
        }

    }
}