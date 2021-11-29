package com.yasir.tinalahedu.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.ui.activity.highScore.HighscoreActivity
import com.yasir.tinalahedu.ui.activity.highScore.VerifikasiHighScoreActivity
import com.yasir.tinalahedu.ui.activity.history.HistoryActivity
import com.yasir.tinalahedu.ui.activity.identify.IdentifyActivity
import com.yasir.tinalahedu.ui.activity.verifikasiToken.VerifikasiActivity

class HomeFragment : Fragment() {
    lateinit var btnNewGame : CardView
    lateinit var btnIdentifikasi : CardView
    lateinit var btnHighScore : CardView
    lateinit var btnHistory : CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_home, container, false)
        init(view)

        mainButton()

        return view
    }

    private fun init(view: View){
        btnNewGame = view.findViewById(R.id.btn_new_game_home)
        btnIdentifikasi = view.findViewById(R.id.btn_identifikasi_home)
        btnHighScore = view.findViewById(R.id.btn_high_score_home)
        btnHistory = view.findViewById(R.id.btn_history_home)
    }

    fun mainButton(){
        btnNewGame.setOnClickListener {
            startActivity(Intent(requireActivity(), VerifikasiActivity::class.java))
        }
        btnHistory.setOnClickListener {
            startActivity(Intent(requireActivity(), HistoryActivity::class.java))
        }
        btnHighScore.setOnClickListener {
            startActivity(Intent(requireActivity(), VerifikasiHighScoreActivity::class.java))
        }
        btnIdentifikasi.setOnClickListener {
            startActivity(Intent(requireActivity(), IdentifyActivity::class.java))
        }
    }
}