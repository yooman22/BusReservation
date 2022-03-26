package com.example.busreservation.data
import com.devexpress.dxcharts.NumericSeriesData




class GdpData constructor(data: ArrayList<GdpValue>) : NumericSeriesData {
    internal var mData: ArrayList<GdpValue> = ArrayList()

    init {
        this.mData = data
    }

    override fun getArgument(i: Int): Double {
        return mData[i].year.toDouble()
    }

    override fun getValue(i: Int): Double {
        return mData[i].value
    }

    override fun getDataCount(): Int {
        return mData.size
    }
}

class GdpValue(var year: Int, var value: Double)