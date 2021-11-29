package com.yasir.tinalahedu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.identifyDetail.IdentifyDetailData

class DetailIdentifyAdapter(
    private val dtIdentify : MutableList<IdentifyDetailData>,
    private val listener : Listener
) : RecyclerView.Adapter<DetailIdentifyAdapter.ViewHolder>() {
    interface Listener {
        fun onItemClick(detail: IdentifyDetailData)
        fun onItemLongClick(detail: IdentifyDetailData)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailIdentifyAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_identify, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailIdentifyAdapter.ViewHolder, position: Int) {
        holder.bindModel(dtIdentify[position], listener)
    }

    override fun getItemCount(): Int {
        return dtIdentify.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val namaDetailIdentify : TextView = itemView.findViewById(R.id.tv_nama_detail_identify)
        val kategoriDetailIdentify : TextView = itemView.findViewById(R.id.tv_kategori_detail_identify)
        val deskripsiDetailIdentify : TextView = itemView.findViewById(R.id.tv_deskripsi_detail_identify)
        val ivDetailIdentify : ImageView = itemView.findViewById(R.id.iv_gambar_detail_identify)
        fun bindModel(detail : IdentifyDetailData, listener : Listener){
            namaDetailIdentify.text = detail.namaGambar
            kategoriDetailIdentify.text = detail.kategoriGambar
            deskripsiDetailIdentify.text = detail.deskripsiGambar
            Glide.with(itemView.context).load(detail.gambarUrl).into(ivDetailIdentify)
            itemView.setOnClickListener {
                listener.onItemClick(detail)
            }
            itemView.setOnLongClickListener {
                listener.onItemLongClick(detail)
                true
            }
        }
    }
}