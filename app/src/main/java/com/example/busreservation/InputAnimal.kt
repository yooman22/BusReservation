package com.example.busreservation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import com.example.busreservation.R
import kotlinx.android.synthetic.main.activity_input_animal.*

class InputAnimal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_animal)

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        main.setOnClickListener{
            var view = this.currentFocus
            imm.hideSoftInputFromWindow(view?.windowToken,0)

        }

        back_view.setOnClickListener{
            var view = this.currentFocus
            imm.hideSoftInputFromWindow(view?.windowToken,0)
        }

        val user_age_list = arrayOf("10대", "20대", "30대","40대","50대","60대")
        val pet_age_list = arrayOf("1~10", "11~20", "21~30","31~40")
        val pet_breed_list = arrayOf("저먼 셰퍼드", "포메라니안", "시베리안 허스키","푸들","골든 리트리버","시추","로트바일러","시바견")
        val pet_gender_list = arrayOf("여자", "남자", "중성")


        val adapter_user_age = ArrayAdapter(this, android.R.layout.simple_list_item_1, user_age_list)

        user_age.setAdapter(adapter_user_age)

        user_age.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, v: View, position: Int, id: Long) {

                // get TextView's Text.
                val strText = parent.getItemAtPosition(position) as String
                    user_age_txt.text = strText
                    user_age_txt.isVisible = true
                    user_age.isVisible = false

                // TODO : use strText
            }
        }

        user_age_txt.setOnClickListener{
            user_age_txt.isVisible = false
            user_age.isVisible = true
        }

        val adapter_pet_age = ArrayAdapter(this, android.R.layout.simple_list_item_1, pet_age_list)

        pet_age.setAdapter(adapter_pet_age)

        pet_age.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, v: View, position: Int, id: Long) {

                // get TextView's Text.
                val strText = parent.getItemAtPosition(position) as String
                    pet_age_txt.text = strText
                    pet_age_txt.isVisible = true
                    pet_age.isVisible = false

                // TODO : use strText
            }
        }

        pet_age_txt.setOnClickListener{
            pet_age_txt.isVisible = false
            pet_age.isVisible = true
        }

        val adapter_pet_breed = ArrayAdapter(this, android.R.layout.simple_list_item_1, pet_breed_list)

        pet_breed.setAdapter(adapter_pet_breed)

        pet_breed.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, v: View, position: Int, id: Long) {

                // get TextView's Text.
                val strText = parent.getItemAtPosition(position) as String

                    pet_breed_txt.text = strText
                    pet_breed_txt.isVisible = true
                    pet_breed.isVisible = false


                // TODO : use strText
            }
        }

        pet_breed_txt.setOnClickListener{
            pet_breed_txt.isVisible = false
            pet_breed.isVisible = true
        }

        val adapter_pet_gender = ArrayAdapter(this, android.R.layout.simple_list_item_1, pet_gender_list)

        pet_gender.setAdapter(adapter_pet_gender)

        pet_gender.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, v: View, position: Int, id: Long) {

                // get TextView's Text.
                val strText = parent.getItemAtPosition(position) as String

                    pet_gender_txt.text = strText
                    pet_gender_txt.isVisible = true
                    pet_gender.isVisible = false

                // TODO : use strText
            }
        }

        pet_gender_txt.setOnClickListener{
            pet_gender_txt.isVisible = false
            pet_gender.isVisible = true
        }

        next.setOnClickListener{
            val nextIntent = Intent(this, Login::class.java)
            startActivity(nextIntent)
        }

    }


}