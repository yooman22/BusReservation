package com.example.busreservation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dog_recommend.*

class DogRecommend : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_recommend)

        confirm_recommand.setOnClickListener {
            val nextIntent = Intent(this, DogFeedList::class.java)
            startActivity(nextIntent)
        }

    }
}