package com.example.animal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.busreservation.R
import com.example.busreservation.SmsAPI
import kotlinx.android.synthetic.main.activity_find_id.*
import kotlinx.android.synthetic.main.activity_find_password_result.*
import org.json.JSONObject
import server.conn.ServerAPI

class Find_Password_Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_password_result)


        findPwdIdAuthButton.setOnClickListener{

            var smsAPI: SmsAPI = SmsAPI(findPwdPhone.text.toString());
            smsAPI.start();
            smsAPI.join();

            var authNum = smsAPI.authNum;

            var hashMap  = HashMap<String,String>();
            hashMap.put("findPwdId",findPwdId.text.toString());
            hashMap.put("findId",findPwdName.text.toString());
            hashMap.put("authNum",authNum);

            var serverAPI: ServerAPI = ServerAPI(3,hashMap)
            serverAPI.start();
            serverAPI.join();
        }

        findPwdButton.setOnClickListener{
            var hashMap  = HashMap<String,String>()

            hashMap.put("findPwdId",findPwdId.text.toString());
            hashMap.put("findPwdName",findPwdName.text.toString());
            hashMap.put("findPwdPhone",findPwdPhone.text.toString());
            hashMap.put("findPwdAuth",findPwdAuth.text.toString());

            var serverAPI: ServerAPI = ServerAPI(5,hashMap)
            serverAPI.start();
            serverAPI.join();

            val jsonObject = JSONObject(serverAPI.output);
            val idCnt = jsonObject.getString("idCnt")

            if(idCnt.toInt() > 0 ){
                val nextIntent = Intent(this, Find_Password::class.java)
                nextIntent.putExtra("id",findPwdId.text.toString());
                startActivity(nextIntent);
            }else{
                Toast.makeText(this, "해당 정보의 계정이 존재 하지 않습니다.", Toast.LENGTH_LONG).show()
            }
        }

    }
}