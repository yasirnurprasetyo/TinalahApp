package com.yasir.tinalahedu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.history.HistoryData

class ScanAdapter (
    private val scans: MutableList<HistoryData>,
    private val listener: Listener
    ) : RecyclerView.Adapter<ScanAdapter.ViewHolder>() {

    interface Listener {
        fun onItemClick(scan: HistoryData)
        fun onItemLongClick(scan: HistoryData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindModel(scans[position], listener)
    }

    override fun getItemCount(): Int {
        return scans.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val namaScan :TextView = itemView.findViewById(R.id.tv_nama_history)
        val kategoriScan :TextView = itemView.findViewById(R.id.tv_kategori_history)
        val ivScan : ImageView = itemView.findViewById(R.id.iv_scan_objek_history)
        fun bindModel(scan : HistoryData, listener: Listener){
            namaScan.text = scan.namaGambar
            kategoriScan.text = scan.kategori
            Glide.with(itemView.context).load(scan.imageUrl).into(ivScan)
            itemView.setOnClickListener {
                listener.onItemClick(scan)
            }
            itemView.setOnLongClickListener {
                listener.onItemLongClick(scan)
                true
            }
        }
    }
}