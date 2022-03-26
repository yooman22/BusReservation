package com.example.busreservation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.busreservation.R
import kotlinx.android.synthetic.main.activity_find_id_result.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import server.conn.ServerAPI

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        signUp_back_view.setOnClickListener{
            var view = this.currentFocus
            imm.hideSoftInputFromWindow(view?.windowToken,0)
        }

        signUpButton.setOnClickListener {
            var hashMap  = HashMap<String,String>()

            hashMap.put("name",name.text.toString());
            hashMap.put("rrn",rrn.text.toString());
            hashMap.put("id",id.text.toString());
            hashMap.put("pwd1",pwd1.text.toString());
            hashMap.put("pwd2",pwd2.text.toString());
            hashMap.put("phone",phone.text.toString());

            var serverAPI: ServerAPI = ServerAPI(1,hashMap)
            serverAPI.start();
            serverAPI.join();

            Toast.makeText(this, "회원가입 성공", Toast.LENGTH_LONG).show()

            Thread.sleep(3000);

            val nextIntent = Intent(this, Login::class.java)
            startActivity(nextIntent);
        }
    }
}