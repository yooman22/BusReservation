package Network

import VO.LoginVO
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RetrofitService {
    @FormUrlEncoded
    @POST("/Login.php")
    fun API_Login(
        @Field("userID") ID : String,
        @Field("userPassword") Password : String
    ) : Call<LoginVO>


}