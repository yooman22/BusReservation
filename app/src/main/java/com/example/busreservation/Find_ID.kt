package com.example.busreservation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.busreservation.R
import com.example.busreservation.SmsAPI
import kotlinx.android.synthetic.main.activity_find_id.*
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import server.conn.ServerAPI

class Find_ID : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id)

        phoneAuthBotton.setOnClickListener{
            var smsAPI: SmsAPI = SmsAPI(phoneNumber_txt.text.toString());
            smsAPI.start();
            smsAPI.join();

            var authNum = smsAPI.authNum;

            var hashMap  = HashMap<String,String>();
            hashMap.put("findId",findId.text.toString());
            hashMap.put("authNum",authNum);

            var serverAPI: ServerAPI = ServerAPI(3,hashMap)
            serverAPI.start();
            serverAPI.join();
        }


        findIdButton.setOnClickListener{

            var hashMap  = HashMap<String,String>()

            hashMap.put("findId",findId.text.toString());
            hashMap.put("phoneNumber_txt",phoneNumber_txt.text.toString());
            hashMap.put("AuthNum",AuthNum.text.toString());

            var serverAPI: ServerAPI = ServerAPI(4,hashMap)
            serverAPI.start();
            serverAPI.join();

            val jsonObject = JSONObject(serverAPI.output);
            val id = jsonObject.getString("id")

            System.out.println(id)

            if(id != "X"){
                val nextIntent = Intent(this, Find_ID_Result::class.java)
                nextIntent.putExtra("id",id);
                startActivity(nextIntent);
            }else{
                Toast.makeText(this, "해당 정보의 아이디가 존재 하지 않습니다.", Toast.LENGTH_LONG).show()
            }

        }
    }
}