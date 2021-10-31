package com.example.busreservation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.view.ContextThemeWrapper


class BusReservation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_reservation)

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
    }
}