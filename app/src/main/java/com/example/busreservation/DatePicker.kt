package com.example.busreservation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_date_picker.*
import java.util.*

class DatePicker : AppCompatActivity() {

    var mYear =0
    var mMonth=0
    var mDay=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

        var calendar = GregorianCalendar();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);

        vDatePicker.init(
            mYear,
            mMonth,
            mDay,
            DatePicker.OnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
                // Do something when the date changed in date picker object
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
            })



        vDateEnter.setOnClickListener{
            var intent = Intent();
            intent.putExtra("mYear",mYear);
            intent.putExtra("mMonth", mMonth);
            intent.putExtra("mDay", mDay);
            setResult(RESULT_OK, intent);
            finish();

        }

    }



}