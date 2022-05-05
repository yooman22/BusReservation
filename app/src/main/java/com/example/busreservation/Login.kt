package com.example.busreservation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.busreservation.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject
import server.conn.ServerAPI

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        back_view.setOnClickListener{
            var view = this.currentFocus
            imm.hideSoftInputFromWindow(view?.windowToken,0)
        }

        signUp.setOnClickListener{
            val nextIntent = Intent(this, SignUp::class.java)
            startActivity(nextIntent)
        }

        user_id_find.setOnClickListener{
            val nextIntent = Intent(this, Find_ID::class.java)
            startActivity(nextIntent)
        }

        user_password_find.setOnClickListener{
            val nextIntent = Intent(this, Find_Password_Result::class.java)
            startActivity(nextIntent)
        }

        loginButton.setOnClickListener {

            var hashMap  = HashMap<String,String>()

            hashMap.put("id",loginId.text.toString());
            hashMap.put("pwd",loginPwd.text.toString());

            var serverAPI: ServerAPI = ServerAPI(2,hashMap)
            serverAPI.start();
            serverAPI.join();

            val jsonObject = JSONObject(serverAPI.output);
            val id = jsonObject.getString("status")

            if(id == "suc"){
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_LONG).show()
                val nextIntent = Intent(this, DogPage::class.java)
                startActivity(nextIntent)
            }else{
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_LONG).show()
            }

//                val nextIntent = Intent(this, DogPage::class.java)
//                startActivity(nextIntent)

        }

    }
}