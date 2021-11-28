package Network

import VO.ListVO
import VO.LoginVO
import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {
    @FormUrlEncoded
    @POST("/Login.php")
    fun API_Login(
        @Field("userID") ID : String,
        @Field("userPassword") Password : String
    ) : Call<LoginVO>

    @FormUrlEncoded
    @POST("/List.php")
    fun API_List(
        @Field("RouteType") RouteType : String,
    ) : Call<ListVO>

}