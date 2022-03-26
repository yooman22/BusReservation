package com.example.busreservation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.busreservation.R
import kotlinx.android.synthetic.main.activity_quiz_detail.*

class Quiz_Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_detail)

        val quiz = arrayOf("애완견이 먹으면 안되는 음식은 무엇일까요?", "애완견이 사람 발을 햝는 이유는 무엇일까요?", "길들여진 개는 어떤 종의 후손일까요?",
            "애완견은 어떻게 시간을 판단할까요?","세상에서 가장 작은 애완견은 무엇일까요?","애완견 앞발의 발가락은 몇 개일까요?","애완견이 인식할 수 없는 색상 스펙트럼은 무엇일까요?"
            ,"방구를 가장 조금 뀌는 애완견은?","애완견은 남자보다 여자를 더 좋아하나요?","강아지도 새치가 날까요?")
        val quiz_yes = arrayOf("우유", "행복함", "다람쥐","자신의 기억","치와와","4개","녹생-빨강","불독","O","O")
        val quiz_no = arrayOf("당근", "불안함", "늑대","일단위로","말티즈","5개","녹색-파랑","비숑 프리제","X","X")

        var complete_count = 0
        var index = 0

        ok.setOnClickListener{

            if(index == 0){
                index++
                complete_count++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }else if(index == 1)
            {
                index++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }else if(index == 2)
            {
                index++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }else if(index ==3)
            {
                index++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }else if(index == 4)
            {
                index++
                complete_count++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }else if(index == 5)
            {
                index++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }else if(index == 6)
            {
                index++
                complete_count++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }else if(index == 7)
            {
                index++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }else if(index == 8)
            {
                index++
                complete_count++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }else if(index == 9)
            {
                index++
                complete_count++
//                quiz_txt.text = quiz[index]
//                ok.text = quiz_yes[index]
//                no.text = quiz_no[index]

                val nextIntent = Intent(this, Quiz_Result::class.java)
                nextIntent.putExtra("count",complete_count)
                startActivity(nextIntent)

            }else if(index == 10){

            }

        }

        no.setOnClickListener{

            if(index == 0){

            }
            else if(index == 1)
            {
                index++
                complete_count++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]
            }
            else if(index == 2)
            {
                index++
                complete_count++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]
            }
            else if(index ==3)
            {
                index++
                complete_count++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]
            }
            else if(index == 4)
            {
                index++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }
            else if(index == 5)
            {
                index++
                complete_count++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }else if(index == 6)
            {
                index++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }else if(index == 7)
            {
                index++
                complete_count++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }
            else if(index == 8)
            {
                index++
                quiz_txt.text = quiz[index]
                ok.text = quiz_yes[index]
                no.text = quiz_no[index]

            }
            else if(index == 9)
            {
                index++
//                quiz_txt.text = quiz[index]
//                ok.text = quiz_yes[index]
//                no.text = quiz_no[index]

                val nextIntent = Intent(this, Quiz_Result::class.java)
                nextIntent.putExtra("count",complete_count)
                startActivity(nextIntent)

            }else if(index == 10){

            }

        }


    }
}