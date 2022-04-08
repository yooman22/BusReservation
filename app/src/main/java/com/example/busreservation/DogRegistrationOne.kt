package com.example.busreservation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Toast
import androidx.activity.result.ActivityResult
import kotlinx.android.synthetic.main.activity_dog_registration_one.*
import java.text.SimpleDateFormat
import java.util.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultCallback

import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult


class DogRegistrationOne : AppCompatActivity() {

    private var resultLauncher: ActivityResultLauncher<Intent>? = null

    var DateString : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_registration_one)

        fun getMonthsDifference(date1:Date, date2 : Date) : Int{

            /* 해당년도에 12를 곱해서 총 개월수를 구하고 해당 월을 더 한다. */
            var month1 = date1.getYear() * 12 + date1.getMonth();
            var month2 = date2.getYear() * 12 + date2.getMonth();

            return month2 - month1;
        }

        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    result: ActivityResult -> if (result.resultCode == Activity.RESULT_OK) {
                        val intent = result.data // Handle the Intent //do stuff here

                        var year = result.data!!.getIntExtra("mYear",-1)
                        var month = result.data!!.getIntExtra("mMonth",-1)
                        var day = result.data!!.getIntExtra("mDay",-1)

                        val cal: Calendar = Calendar.getInstance()
                        cal.set(year, month, day)



                        var now = System.currentTimeMillis();
                        var curtime = Date(now);


                        val dateFormat = SimpleDateFormat("y년-mm개월")
                        val curDate : String = dateFormat.format(now-cal.timeInMillis)

                        DateString = (getMonthsDifference(Date(cal.timeInMillis),Date(now))/12).toString() + "년" + (getMonthsDifference(Date(cal.timeInMillis),Date(now))%12).toString() + "개월"

                        date.setText(DateString)

                        // 1000 * 60 * 60 * 24 1일
                        // 1000 * 60 * 60 * 24 * 30 1달
                        // 1000 * 60 * 60 * 24 * 30 * 12 1년

                    }
                }

            datepicker.setOnClickListener{
                val nextIntent = Intent(this, DatePicker::class.java)
                startForResult.launch(nextIntent)
            }

            confirm.setOnClickListener{

                if(name.getText().toString() == "" || date.getText().toString() == ""){
                    Toast.makeText(getApplicationContext(),"미 입력 항목이 있습니다.",Toast.LENGTH_LONG).show()
                }else {
                    val nextIntent = Intent(this, DogRegistrationTwo::class.java)
                    nextIntent.putExtra("name",name.getText().toString())
                    nextIntent.putExtra("date",DateString)

                    startActivity(nextIntent)
                }

            }

        }

    }