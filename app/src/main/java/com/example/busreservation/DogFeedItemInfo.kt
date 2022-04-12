package com.example.busreservation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dog_feed_item_info.*

class DogFeedItemInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_feed_item_info)

        var image_ =  intent.getIntExtra("image",-1)
        var company_ =  intent.getStringExtra("company")
        var item_ =  intent.getStringExtra("item")
        var cost_ =  intent.getStringExtra("cost")

        item__.setText(item_)
        cost.setText(cost_)
        company.setText(company_)
        image.setImageResource(image_)

    }
}