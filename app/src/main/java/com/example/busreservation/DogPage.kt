package com.example.busreservation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.view.View
import com.devexpress.dxcharts.*
import com.example.busreservation.data.GdpData
import com.example.busreservation.data.GdpValue
import kotlinx.android.synthetic.main.activity_dog_main.*
import kotlinx.android.synthetic.main.activity_dog_page.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DogPage : AppCompatActivity() {

    val now = System.currentTimeMillis()

    override fun onResume() {
        super.onResume()

        total_money.setText(getTotalMoney().toString() + "원")

        per1.setText(getExpensiveIndex(1).toString())
        per2.setText(getExpensiveIndex(2).toString())
        per3.setText(getExpensiveIndex(3).toString())
        per4.setText(getExpensiveIndex(4).toString())
        per5.setText(getExpensiveIndex(5).toString())

        pro1.progress = getExpensiveIndex(1)
        pro2.progress = getExpensiveIndex(2)
        pro3.progress = getExpensiveIndex(3)
        pro4.progress = getExpensiveIndex(4)
        pro5.progress = getExpensiveIndex(5)

        System.out.println("현재 시간 : " + System.currentTimeMillis().toString())

        System.out.println( "샤워 시간 : " + SharedPreference.prefs.getBigInteger("showerDate",0).toString())

        var showerDate = System.currentTimeMillis() - SharedPreference.prefs.getBigInteger(
            "showerDate",
            0
        )

        if( showerDate < 24 * 60 * 60 * 1000){
            txt_shower_date.setText("오늘")
        }
        else if(showerDate > now){
            txt_shower_date.setText("-")
        }
        else {
            txt_shower_date.setText(
                (showerDate / (24 * 60 * 60 * 1000)).toString() + "일전"
            )
        }

        System.out.println( "심장 시간 : " + SharedPreference.prefs.getBigInteger("heartDate",0).toString())

        var heartDate = System.currentTimeMillis() - SharedPreference.prefs.getBigInteger("heartDate",0)

        if(heartDate < 24 * 60 * 60 * 1000){
            txt_heart_date.setText("오늘")
        }
        else if(heartDate> now){
            txt_heart_date.setText("-")
        }
        else {
            txt_heart_date.setText( (heartDate / (24 * 60 * 60 * 1000)).toString() + "일전" )
        }

        txt_weight.setText(SharedPreference.prefs.getString("dog_weight","-"))

        var dateMonth = SharedPreference.prefs.getInt("dateMonth",0)
        if(dateMonth == -1){
            dog_date.setText("")
            baby_age.setText("")
        }else {
            dog_date.setText(dateMonth.toString() + " 개월")
            baby_age.setText((dateMonth*5/3).toString() + " 살")
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_page)


        val date = Date(now)
        var sdf : SimpleDateFormat = SimpleDateFormat("yyyy년 MM월 dd일");
        var sdf1 : SimpleDateFormat = SimpleDateFormat("yyyy년 MM월");
        var getTime : String = sdf.format(date);
        var getTime1 : String = sdf1.format(date)
        

        current_date.setText(getTime)

        money_date.setText(getTime1 + "지출")

        total_money.setText(getTotalMoney().toString() + "원")

        var dateMonth = SharedPreference.prefs.getInt("dateMonth",0)


        if(dateMonth == -1){
            dog_date.setText("0")
            baby_age.setText("0")
        }else {
            dog_date.setText(dateMonth.toString())
            baby_age.setText((dateMonth*5/3).toString())
        }

        System.out.println( "index 1 값 : " + getExpensiveIndex(1).toString())

        per1.setText(getExpensiveIndex(1).toString())
        per2.setText(getExpensiveIndex(2).toString())
        per3.setText(getExpensiveIndex(3).toString())
        per4.setText(getExpensiveIndex(4).toString())
        per5.setText(getExpensiveIndex(5).toString())

        pro1.progress = getExpensiveIndex(1)
        pro2.progress = getExpensiveIndex(2)
        pro3.progress = getExpensiveIndex(3)
        pro4.progress = getExpensiveIndex(4)
        pro5.progress = getExpensiveIndex(5)

        if(SharedPreference.prefs.getBool("Save",false)){
            btn_list.visibility = View.VISIBLE
            registration.visibility = View.GONE
        }else {
            btn_list.visibility = View.GONE
            registration.visibility = View.VISIBLE
        }

        txt_weight.setText(SharedPreference.prefs.getString("dog_weight","-"))

        if( SharedPreference.prefs.getBigInteger("showerDate",0) < 24 * 60 * 60 * 1000){
            txt_shower_date.setText("오늘")
        }
        else if(SharedPreference.prefs.getBigInteger("showerDate",0) > now){
            txt_shower_date.setText("-")
        }
        else {
            txt_shower_date.setText(
                ((System.currentTimeMillis() - SharedPreference.prefs.getBigInteger(
                    "showerDate",
                    0
                )) / (24 * 60 * 60 * 1000)).toString() + "일전"
            )
        }

        if(SharedPreference.prefs.getBigInteger("heartDate",0) < 24 * 60 * 60 * 1000){
            txt_heart_date.setText("오늘")
        }
        else if(SharedPreference.prefs.getBigInteger("heartDate",0) > now){
            txt_shower_date.setText("-")
        }
        else {
            txt_heart_date.setText( ((System.currentTimeMillis() - SharedPreference.prefs.getBigInteger("heartDate",0)) / (24 * 60 * 60 * 1000)).toString() + "일전" )
        }



        btn_map.setOnClickListener {
            val nextIntent = Intent(this, DogMap::class.java)
            startActivity(nextIntent)
        }

        btn_shower.setOnClickListener {
            val nextIntent = Intent(this, DogShower::class.java)
            startActivity(nextIntent)
        }

        btn_weight.setOnClickListener {
            val nextIntent = Intent(this, DogWeight::class.java)
            startActivity(nextIntent)
        }

        btn_heart.setOnClickListener {
            val nextIntent = Intent(this, DogHeart::class.java)
            startActivity(nextIntent)
        }

        btn_expensive.setOnClickListener {
            val nextIntent = Intent(this, DogTotalMoney::class.java)
            startActivity(nextIntent)
        }

        btn_recommand.setOnClickListener {
            val nextIntent = Intent(this, DogRecommend::class.java)
            startActivity(nextIntent)
        }


        val usaGdpSeries = LineSeries()
        usaGdpSeries.displayName = "뭄무게"
        usaGdpSeries.data = GdpData(
            ArrayList(
                Arrays.asList(
                    GdpValue(1, 14.719),
                    GdpValue(2, 14.419),
                    GdpValue(3, 14.964),
                    GdpValue(4, 15.518),
                    GdpValue(5, 16.155),
                    GdpValue(6, 16.692),
                    GdpValue(7, 17.393),
                    GdpValue(8, 18.037),
                    GdpValue(9, 18.037),

                )
            )
        )
        chart.addSeries(usaGdpSeries)


        val xAxis = NumericAxisX()
        xAxis.gridAlignment = 1.0
        //xAxis.gridOffset = 0.0
        chart.axisX = xAxis

        val yAxis = NumericAxisY()
        yAxis.gridAlignment = 5.0
        chart.axisY = yAxis

        val axisLabel = AxisLabel()
        axisLabel.textFormat = " # kg"
        yAxis.label = axisLabel

        val legend = Legend()
        legend.horizontalPosition = LegendHorizontalPosition.CENTER
        legend.verticalPosition = LegendVerticalPosition.TOP_OUTSIDE
        legend.orientation = LegendOrientation.LEFT_TO_RIGHT
        chart.legend = legend

        chart.axisMaxZoomPercent = 300.toDouble()

        setting.setOnClickListener{
            val nextIntent = Intent(this, DogAdd::class.java)
            startActivity(nextIntent)

        }

        registration.setOnClickListener{
            val nextIntent = Intent(this, DogRegistrationOne::class.java)
            startActivity(nextIntent)

        }


    }

    fun getTotalMoney() : Int {
        var cost =  SharedPreference.prefs.getIntzero("expensive1",0) + SharedPreference.prefs.getIntzero("expensive2",0)+ SharedPreference.prefs.getIntzero("expensive3",0)+ SharedPreference.prefs.getIntzero("expensive4",0) + SharedPreference.prefs.getIntzero("expensive5",0)

        return cost
    }

    fun getExpensiveIndex(index : Int) : Int {

        when(index){

            1-> {

                if(SharedPreference.prefs.getInt("expensive1",0) == -1) return 0

                return ( String.format("%.2f", SharedPreference.prefs.getInt("expensive1",0).toDouble()/getTotalMoney().toDouble()).toDouble() * 100 ).toInt()
            }

            2-> {
                if(SharedPreference.prefs.getInt("expensive2",0) == -1) return 0

                return ( String.format("%.2f", SharedPreference.prefs.getInt("expensive2",0).toDouble()/getTotalMoney().toDouble()).toDouble() * 100 ).toInt()
            }

            3-> {
                if(SharedPreference.prefs.getInt("expensive3",0) == -1) return 0

                return ( String.format("%.2f", SharedPreference.prefs.getInt("expensive3",0).toDouble()/getTotalMoney().toDouble()).toDouble() * 100 ).toInt()
            }

            4-> {
                if(SharedPreference.prefs.getInt("expensive4",0) == -1) return 0

                return ( String.format("%.2f", SharedPreference.prefs.getInt("expensive4",0).toDouble()/getTotalMoney().toDouble()).toDouble() * 100 ).toInt()
            }

            5-> {
                if(SharedPreference.prefs.getInt("expensive5",0) == -1) return 0

                return ( String.format("%.2f", SharedPreference.prefs.getInt("expensive5",0).toDouble()/getTotalMoney().toDouble()).toDouble() * 100 ).toInt()
            }

            else -> {
                return  0
            }
        }

    }


}