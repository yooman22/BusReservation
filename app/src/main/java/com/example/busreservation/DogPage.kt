package com.example.busreservation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devexpress.dxcharts.*
import com.example.busreservation.data.GdpData
import com.example.busreservation.data.GdpValue
import kotlinx.android.synthetic.main.activity_dog_page.*
import java.util.*
import kotlin.collections.ArrayList

class DogPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_page)

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


    }



}