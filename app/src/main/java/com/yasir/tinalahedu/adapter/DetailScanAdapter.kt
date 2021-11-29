package com.yasir.tinalahedu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.scanDetail.ScanDetailData

class DetailScanAdapter(
    private val dtScan : MutableList<ScanDetailData>,
    private val listener : Listener
) : RecyclerView.Adapter<DetailScanAdapter.ViewHolder>() {
    interface Listener {
        fun onItemClick(detail: ScanDetailData)
        fun onItemLongClick(detail: ScanDetailData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailScanAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_scan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailScanAdapter.ViewHolder, position: Int) {
        holder.bindModel(dtScan[position], listener)
    }

    override fun getItemCount(): Int {
        return dtScan.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val namaDetailScan : TextView = itemView.findViewById(R.id.tv_nama_detail_scan)
        val kategoriDetailScan : TextView = itemView.findViewById(R.id.tv_kategori_detail_scan)
        val deskripsiDetailScan : TextView = itemView.findViewById(R.id.tv_deskripsi_detail_scan)
        val ivDetailScan : ImageView = itemView.findViewById(R.id.iv_gambar_detail_scan)
        fun bindModel(detail : ScanDetailData, listener: Listener){
            namaDetailScan.text = detail.namaGambarScan
            kategoriDetailScan.text = detail.kategoriGambarScan
            deskripsiDetailScan.text = detail.deskripsiGambarScan
            Glide.with(itemView.context).load(detail.gambarUrl).into(ivDetailScan)
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