package VO

import com.google.gson.JsonArray
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginVO(
    @SerializedName("Result")
    var result : String = ""
)

data class ListVO(
    @SerializedName("Result")
    var result : List<station>
)

data class station(
    @SerializedName("StationName")
    var stationID : String,
    @SerializedName("StationID")
    var stationName : String
)


