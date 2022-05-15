package com.example.busreservation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dog_feed_item_info.*
import android.content.Intent
import android.net.Uri


class DogFeedItemInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_feed_item_info)

        var image_ =  intent.getIntExtra("image",-1)
        var company_ =  intent.getStringExtra("company")
        var item_ =  intent.getStringExtra("item")
        var cost_ =  intent.getStringExtra("cost")
        var url_ = intent.getStringExtra("url")

        item__.setText(item_)
        cost.setText(cost_)
        company.setText(company_)
        image.setImageResource(image_)

        confirm_info.setOnClickListener {
            val srchString = "개발인생"
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url_))
            startActivity(browserIntent)
        }

    }
}