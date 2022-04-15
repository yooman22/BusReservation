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
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_page)


        val date = Date(now)
        var sdf : SimpleDateFormat = SimpleDateFormat("yyyy년 MM월 dd일");

        var getTime : String = sdf.format(date);

        current_date.setText(getTime)

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

        pro1.progress = getExpensiveIndex(1).toInt()
        pro2.progress = getExpensiveIndex(2).toInt()
        pro3.progress = getExpensiveIndex(3).toInt()
        pro4.progress = getExpensiveIndex(4).toInt()
        pro5.progress = getExpensiveIndex(5).toInt()

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
        usaGdpSeries.displayName = "USA"
        usaGdpSeries.data = GdpData(
            ArrayList(
                Arrays.asList(
                    GdpValue(2008, 14.719),
                    GdpValue(2009, 14.419),
                    GdpValue(2010, 14.964),
                    GdpValue(2011, 15.518),
                    GdpValue(2012, 16.155),
                    GdpValue(2013, 16.692),
                    GdpValue(2014, 17.393),
                    GdpValue(2015, 18.037)
                )
            )
        )
        chart.addSeries(usaGdpSeries)



        val chinaGdpSeries = LineSeries()
        chinaGdpSeries.displayName = "China"
        chinaGdpSeries.data = GdpData(
            ArrayList(
                Arrays.asList(
                    GdpValue(2008, 4.598),
                    GdpValue(2009, 5.11),
                    GdpValue(2010, 6.101),
                    GdpValue(2011, 7.573),
                    GdpValue(2012, 8.561),
                    GdpValue(2013, 9.607),
                    GdpValue(2014, 10.482),
                    GdpValue(2015, 11.065)
                )
            )
        )
        chart.addSeries(chinaGdpSeries)

        val japanGdpSeries = LineSeries()
        japanGdpSeries.displayName = "Japan"
        japanGdpSeries.data = GdpData(
            ArrayList(
                Arrays.asList(
                    GdpValue(2008, 5.038),
                    GdpValue(2009, 5.231),
                    GdpValue(2010, 5.7),
                    GdpValue(2011, 6.157),
                    GdpValue(2012, 6.203),
                    GdpValue(2013, 5.156),
                    GdpValue(2014, 4.849),
                    GdpValue(2015, 4.383)
                )
            )
        )
        chart.addSeries(japanGdpSeries)


        val xAxis = NumericAxisX()
        xAxis.gridAlignment = 1.0
        //xAxis.gridOffset = 0.0
        chart.axisX = xAxis

        val yAxis = NumericAxisY()
        yAxis.gridAlignment = 5.0
        chart.axisY = yAxis

        val axisLabel = AxisLabel()
        axisLabel.textFormat = "$ # tn"
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
        var cost =  SharedPreference.prefs.getInt("expensive1",0)
        + SharedPreference.prefs.getInt("expensive2",0)
        + SharedPreference.prefs.getInt("expensive3",0)
        + SharedPreference.prefs.getInt("expensive4",0)
        + SharedPreference.prefs.getInt("expensive5",0)

        if(cost == -1) return 0

        return cost
    }

    fun getExpensiveIndex(index : Int) : Double {

        when(index){

            1-> {

                if(SharedPreference.prefs.getInt("expensive1",0) == -1) return 0.0

                return String.format("%.0f", SharedPreference.prefs.getInt("expensive1",0).toDouble()/getTotalMoney()).toDouble() * 100
            }

            2-> {
                if(SharedPreference.prefs.getInt("expensive2",0) == -1) return 0.0

                return String.format("%.0f", SharedPreference.prefs.getInt("expensive2",0).toDouble()/getTotalMoney()).toDouble() * 100
            }

            3-> {
                if(SharedPreference.prefs.getInt("expensive3",0) == -1) return 0.0

                return String.format("%.0f", SharedPreference.prefs.getInt("expensive3",0).toDouble()/getTotalMoney()).toDouble() * 100
            }

            4-> {
                if(SharedPreference.prefs.getInt("expensive4",0) == -1) return 0.0

                return String.format("%.0f", SharedPreference.prefs.getInt("expensive4",0).toDouble()/getTotalMoney()).toDouble() * 100
            }

            5-> {
                if(SharedPreference.prefs.getInt("expensive5",0) == -1) return 0.0

                return String.format("%.0f", SharedPreference.prefs.getInt("expensive5",0).toDouble()/getTotalMoney()).toDouble() * 100
            }

            else -> {
                return  0.0
            }
        }

    }


}