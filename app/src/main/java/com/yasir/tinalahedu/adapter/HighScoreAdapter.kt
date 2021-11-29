package com.yasir.tinalahedu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.highScore.HighscoreData
import com.yasir.tinalahedu.model.history.HistoryData

class HighScoreAdapter(
    private val scores : MutableList<HighscoreData>,
    private val listener: Listener
) : RecyclerView.Adapter<HighScoreAdapter.ViewHolder>(){

    interface Listener {
        fun onItemClick(scores: HighscoreData)
        fun onItemLongClick(scores: HighscoreData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_highscore, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindModel(scores[position], listener)
    }

    override fun getItemCount(): Int {
        return scores.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val namaUser : TextView = itemView.findViewById(R.id.tv_name_highsocre)
        val namaTokenGame : TextView = itemView.findViewById(R.id.tv_nametoken_highscore)
        val totalHighSkor : TextView = itemView.findViewById(R.id.tv_totalskor_highscore)
        fun bindModel(scores: HighscoreData, listener: Listener){
            namaUser.text = scores.nameUser
            namaTokenGame.text = scores.namaTokengame
            totalHighSkor.text = scores.totalSkor
            itemView.setOnClickListener {
                listener.onItemClick(scores)
            }
            itemView.setOnLongClickListener {
                listener.onItemLongClick(scores)
                true
            }
        }
    }
}