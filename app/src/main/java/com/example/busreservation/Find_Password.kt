package com.example.busreservation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.busreservation.R
import kotlinx.android.synthetic.main.activity_find_password.*
import kotlinx.android.synthetic.main.activity_find_password_result.*
import server.conn.ServerAPI

class Find_Password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_password)

        updatePwdButton.setOnClickListener{

            var hashMap  = HashMap<String,String>()

            hashMap.put("updatePwd1",updatePwd1.text.toString());
            hashMap.put("updateId",intent.extras?.get("id")!!.toString());

            var serverAPI: ServerAPI = ServerAPI(6,hashMap)
            serverAPI.start();
            serverAPI.join();

            Toast.makeText(this, "비밀번호 변경이 완료되었습니다.", Toast.LENGTH_LONG).show()
            Thread.sleep(3000)

            val nextIntent = Intent(this, Login::class.java)
            startActivity(nextIntent);

        }
    }
}