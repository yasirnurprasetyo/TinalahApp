package com.yasir.tinalahedu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.history.IdentifyHistoryData

class IdentifyAdapter (
    private val identifys: MutableList<IdentifyHistoryData>,
    private val listener: IdentifyAdapter.Listener
    ) : RecyclerView.Adapter<IdentifyAdapter.ViewHolder>() {
        interface  Listener{
            fun onItemClick(identify: IdentifyHistoryData)
            fun onItemLongClick(identify: IdentifyHistoryData)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdentifyAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history_identify, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: IdentifyAdapter.ViewHolder, position: Int) {
        holder.bindModel(identifys[position], listener)
    }

    override fun getItemCount(): Int {
        return identifys.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val namaIdentify : TextView = itemView.findViewById(R.id.tv_nama_history_identify)
        val kategoriIdentify : TextView = itemView.findViewById(R.id.tv_kategori_history_identify)
        val ivHistoryIdentify : ImageView = itemView.findViewById(R.id.iv_scan_objek_history_identify)
        fun bindModel(identify: IdentifyHistoryData, listener: Listener){
            namaIdentify.text = identify.namaGambar
            kategoriIdentify.text = identify.kategoriGambar
            Glide.with(itemView.context).load(identify.gambarUrl).into(ivHistoryIdentify)
            itemView.setOnClickListener {
                listener.onItemClick(identify)
            }
            itemView.setOnLongClickListener {
                listener.onItemLongClick(identify)
                true
            }
        }
    }
}