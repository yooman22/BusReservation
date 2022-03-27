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
import kotlinx.android.synthetic.main.recyclerview_item.view.*
import kotlin.math.cos

class Adapter(private val context : Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var datas = mutableListOf<DataItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if(viewType == 0) {
            val View = LayoutInflater.from(parent.context)
                .inflate(R.layout.one_item, parent, false)

            return MyViewHolder(View)
        }
        else {
            val View = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)

            return MyViewHolder1(View)
        }


    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){ // content 내용
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

        when(datas[position].type) {
            0-> {
                (holder as MyViewHolder).bind(datas[position])
                holder.setIsRecyclable(false)
            }

            1 -> {
                (holder as MyViewHolder1).bind(datas[position])
                holder.setIsRecyclable(false)
            }

        }
//
//        (holder as MyViewHolder1).bind(datas[position])
//        holder.setIsRecyclable(false)

//        holder.itemView.setOnClickListener{
//            itemClickListener.onClick(it, position)
//        }

        holder.itemView.info.setOnClickListener{

        }


    }



    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = datas.size




}
