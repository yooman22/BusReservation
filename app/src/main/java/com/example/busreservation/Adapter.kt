package com.example.busreservation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.cos

class Adapter(private val context : Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var datas = mutableListOf<DataItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)

        return MyViewHolder1(View)

    }

    class MyViewHolder1(val view: View) : RecyclerView.ViewHolder(view){ // content 내용
        val textView: TextView
        val textView2 : TextView
        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.title)
            textView2 = view.findViewById(R.id.body)
        }

        fun bind(item: DataItem){
            textView.text = item.title
            textView2.text = item.body
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
        (holder as MyViewHolder1).bind(datas[position])
        holder.setIsRecyclable(false)

        holder.itemView.setOnClickListener{
            itemClickListener.onClick(it, position)
        }
    }



    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = datas.size




}
