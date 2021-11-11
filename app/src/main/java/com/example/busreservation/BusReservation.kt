package com.example.busreservation
import android.R.attr
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.view.ContextThemeWrapper
import kotlinx.android.synthetic.main.activity_bus_reservation.*
import android.R.attr.data
import android.app.Activity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_departure.*


class BusReservation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_reservation)

        var text = ""


        val builder = AlertDialog.Builder(
            ContextThemeWrapper(
                this,
                R.style.ThemeOverlay_AppCompat
            )
        )
        builder.setTitle("저상버스를 예약하시겠습니까?")
        //builder.setMessage("메시지 내용")
        builder.setPositiveButton(
            "예"
        ) { dialog, id -> }

        builder.setNegativeButton(
            "아니오"
        ) { dialog, id -> }
        builder.show()

        departure.setOnClickListener{
            val nextIntent = Intent(this, Departure::class.java)
            startActivityForResult(nextIntent,1)
        }

        destination.setOnClickListener{
            val nextIntent = Intent(this, Destination::class.java)
            startActivityForResult(nextIntent,2)
        }

        reservation.setOnClickListener{
            builder.setTitle(text +" 예약하시겠습니까?")
            //builder.setMessage("메시지 내용")
            builder.setPositiveButton(
                "예"
            ) { dialog, id -> }

            builder.setNegativeButton(
                "아니오"
            ) { dialog, id -> }
            builder.show()
        }

        bus_list.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, v: View, position: Int, id: Long) {

                // get TextView's Text.
                val strText = parent.getItemAtPosition(position) as String
                text = strText
            }
        }

    }





    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode === 1 && resultCode === RESULT_OK) {
            var result = data?.getStringExtra("depature_data").toString()
            departure_result.text = result
        }

        if (requestCode === 2 && resultCode === RESULT_OK) {
            var result = data?.getStringExtra("destination_data").toString()
            destination_result.text = result
        }

        if(destination_result.text != "" && departure_result.text != ""){
            val bus_txt = arrayOf("733", "307")
            val adapter_departure = ArrayAdapter(this, android.R.layout.simple_list_item_1, bus_txt)
            bus_list.setAdapter(adapter_departure)
        }
    }



}