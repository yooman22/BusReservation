package com.example.animal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.busreservation.R
import kotlinx.android.synthetic.main.activity_dog_introduce.*

class Dog_Introduce : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_introduce)

        view1.setOnClickListener{

            val nextIntent = Intent(this, Dog_Introduce_detail::class.java)
            nextIntent.putExtra("index",0)
            nextIntent.putExtra("Dog",view1_txt.text)
            nextIntent.putExtra("intro","시츄는 티벳에서 유래했으나 중국 왕실에서 키워지면서 발전한 견종이다. 털이 콧등에서 위쪽으로 자라는 특징이 있어 머리 부분에 국화꽃을 닮은 피모가 형성되어 있다. 성격은 다정하고 활발하다.")
            startActivity(nextIntent)
        }

        view2.setOnClickListener{
            val nextIntent = Intent(this, Dog_Introduce_detail::class.java)
            nextIntent.putExtra("index",1)
            nextIntent.putExtra("Dog",view2_txt.text)
            nextIntent.putExtra("intro","비숑 프리제는 바빗을 닮아 바비숑이라는 이름으로 불렸던 견종이다. 털이 돌돌 말린 형태를 띠며, 사교성이 매우 좋은 소형견이다.")
            startActivity(nextIntent)
        }

        view3.setOnClickListener{
            val nextIntent = Intent(this, Dog_Introduce_detail::class.java)
            nextIntent.putExtra("index",2)
            nextIntent.putExtra("Dog",view3_txt.text)
            nextIntent.putExtra("intro","지금은 작은 애완견이지만 포메라니안은 북극에서 썰매를 끌던 개들의 후손으로 초창기에는 지금보다 큰 편이었다. 공처럼 둥글고 풍성하게 부풀어 오른 털이 특징이다. 여우와 비슷한 깜찍한 얼굴에 작은 눈망울이 매력적이고 보호본능이 생기는 귀여운 품종이다.")
            startActivity(nextIntent)
        }

        view4.setOnClickListener{
            val nextIntent = Intent(this, Dog_Introduce_detail::class.java)
            nextIntent.putExtra("index",3)
            nextIntent.putExtra("intro","치와와는 멕시코 치와와주의 이름을 따서 붙여진 것으로 알려져 있다. 세계에서 체구가 가장 작은 견종이다. 행동이 매우 빠르고 기민하다.")
            nextIntent.putExtra("Dog",view4_txt.text)

            startActivity(nextIntent)
        }

        view5.setOnClickListener{
            val nextIntent = Intent(this, Dog_Introduce_detail::class.java)
            nextIntent.putExtra("index",4)
            nextIntent.putExtra("intro","요크셔 테리어는 1850년대에 처음 등장한 견종으로 옛 견종인 '블랙 앤 탄 테리어'에서 유래되었다." +
                    " 기다란 털이 코에서부터 꼬리 끝까지 몸 양쪽에서 균등하게 나뉘어 아래로 곧게 뻗은 것이 특징이다.")
            nextIntent.putExtra("Dog",view5_txt.text)
            startActivity(nextIntent)
        }

        view6.setOnClickListener{
            val nextIntent = Intent(this, Dog_Introduce_detail::class.java)
            nextIntent.putExtra("index",5)
            nextIntent.putExtra("intro","사람과 오랜 세월 함께 한 개들은 대부분 사람을 잘 따르는 성격을 갖고 있습니다. 그중에서 사람을 가장 사랑하는 개를 꼽으라면 아마 어려움을 느낄 텐데요. 그럼에도 불구하고 많은 사람들은 이 견종을 다섯 손가락 안에 꼽을 것 같습니다. 바로 곱고 흰 털을 자랑하는 반려견 '몰티즈'(Maltese)입니다. 몰티즈를 표현할 때 사람들은 ‘앙증맞다’는 표현을 많이 사용하는데요. 이는 몰티즈가 보여주는 귀여운 행동 때문이기도 하지만 그만큼 체구가 작기 때문이기도 합니다. 몰티즈의 체고는 19~25cm이며 몸무게는 2.7~4kg 정도의 소형견입니다.")
            nextIntent.putExtra("Dog",view6_txt.text)
            startActivity(nextIntent)
        }

        view7.setOnClickListener{
            val nextIntent = Intent(this, Dog_Introduce_detail::class.java)
            nextIntent.putExtra("index",6)
            nextIntent.putExtra("intro","파피용은 작고 우호적이고, 우아한 반려견으로서 뼈대가 가는 구조이며, 가볍고 섬세하고, 경쾌한 동작을 하며, 아름다운 나비 같은 귀로 인하여 다른 견종들과 구별되는 개이다. 초소형의 약해 보이는 몸집과는 달리 기온 변화와 질병에 대한 저항력은 강한 매우 건강한 견종으로 활기가 넘쳐 항상 명랑, 쾌활하지만 다소 소란스럽다는 평을 듣기도 한다. 운동과 외출하는 것을 좋아하며 용기와 책임감이 강하고 애정이 많아 다른 반려 동물과 같이 키워도 금방 친해져 장난을 친다.")
            nextIntent.putExtra("Dog",view7_txt.text)
            startActivity(nextIntent)
        }

        view8.setOnClickListener{
            val nextIntent = Intent(this, Dog_Introduce_detail::class.java)
            nextIntent.putExtra("index",7)
            nextIntent.putExtra("intro","키는 25~32cm, 몸무게는 3.5~4.5kg이다. 쐐기 모양의 체형으로 균형이 잘 잡혀 있다. 어두운 갈색의 날카롭고 또렷한 눈과 검은 코가 특징이다. 크고 얇은 귀는 위로 서있다, 털은 짧고 매끄러우며 광택이 나며, 색은 적갈색, 초콜릿색에 갈색 무늬, 검정색에 갈색무늬가 있다. 걸을 때 마장 경기를 하는 말처럼 앞발을 높이 쳐들고 경쾌하게 걷는 것이 특징이다. 발은 작고 둥글며 발가락은 고양이 같다. 일반적으로 꼬리는 엉덩이의 높은 부분에 위치하며 짧게 자르는 경우가 많다.")
            nextIntent.putExtra("Dog",view8_txt.text)
            startActivity(nextIntent)
        }

        view9.setOnClickListener{
            val nextIntent = Intent(this, Dog_Introduce_detail::class.java)
            nextIntent.putExtra("index",8)
            nextIntent.putExtra("intro","닥스훈트라는 이름은 독일어의 '오소리 사냥' 이라는 뜻이 담겨져 있으며 초기에는 '테켈(teckel)'이라고 불렸었다. 굴에 숨은 오소리나 여우를 끌어내고 토끼를 추적하는데 활약했던 특징이 외형적으로도 나타난다. 다리가 짧고 몸이 길며 후각이 발달되어 있으며 겁이 없는 편이다. 몸이 길어 체중 조절과 운동에 신경 써 주지 않으면 척추 디스크를 유발하기 쉽다.")
            nextIntent.putExtra("Dog",view9_txt.text)
            startActivity(nextIntent)
        }



    }
}