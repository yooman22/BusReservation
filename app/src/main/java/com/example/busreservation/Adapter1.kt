package com.example.busreservation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*
import org.w3c.dom.Text
import kotlin.math.cos

class Adapter1(private val context : Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var datas = mutableListOf<FeedItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            val View = LayoutInflater.from(parent.context)
                .inflate(R.layout.feed_item, parent, false)

            return MyViewHolder(View)
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){ // content 내용
        val textView: TextView
        val textView2 : TextView
        val textview3 : TextView
        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.company_)
            textView2 = view.findViewById(R.id.item_)
            textview3 = view.findViewById(R.id.money_)
        }

        fun bind(item: FeedItem){
            textView.text = item.company
            textView2.text = item.item
            textview3.text = item.price
        }
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }


    // (4) setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener : OnItemClickListener

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(datas[position].type) {
            0-> {
                (holder as MyViewHolder).bind(datas[position])
                holder.setIsRecyclable(false)

//                holder.itemView.setOnClickListener{
//
//                }
            }
        }
//
//        (holder as MyViewHolder1).bind(datas[position])
//        holder.setIsRecyclable(false)

        holder.itemView.setOnClickListener{
            itemClickListener.onClick(it, position)
        }
    }



    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = datas.size

}
