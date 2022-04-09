package com.example.busreservation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dog_shower.*

class DogShower : AppCompatActivity() {

    var now = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_shower)

        confirm_shower.setOnClickListener{
            SharedPreference.prefs.getBigInteger("showerDate",now)
        }


    }
}