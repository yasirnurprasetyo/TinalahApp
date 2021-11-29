package com.yasir.tinalahedu.ui.activity.highScore

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.Preferences
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.adapter.HighScoreAdapter
import com.yasir.tinalahedu.model.highScore.HighscoreData
import com.yasir.tinalahedu.model.highScore.HighscoreResponse
import com.yasir.tinalahedu.presenter.AllPresenter
import com.yasir.tinalahedu.ui.activity.main.MainActivity
import com.yasir.tinalahedu.utils.Helper
import com.yasir.tinalahedu.utils.SharedPref
import kotlinx.android.synthetic.main.activity_highscore.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar_custom.*

class HighscoreActivity : AppCompatActivity(), GeneralView, HighScoreAdapter.Listener {
    lateinit var presenter : AllPresenter
    var scores: MutableList<HighscoreData> = mutableListOf()
    lateinit var adapter : HighScoreAdapter
    private var tokenId: String = ""
    lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_highscore)

        //set nama pada toolbar
        Helper().setToolbarHome(this, toolbar_custom, "High Score")

        s = SharedPref(this)
        settingRvHighScore()
        loadApiHighScore()
        setButton()
    }

    fun setButton(){
        btn_toDashboard.setOnClickListener {
            alertClick()
            s.setTokenNull("")
        }
    }

    fun alertClick(){
        AlertDialog.Builder(this)
            .setTitle("Kembali Ke Dashboard")
            .setMessage("Apakah Anda Yakin Kembali Ke Menu Dashboard?")
            .setPositiveButton("Ya", DialogInterface.OnClickListener { dialogInterface, i ->
                val intent = Intent(this@HighscoreActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            })
            .setNegativeButton("Tidak", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })
            .show()
    }

    fun loadApiHighScore(){
        val token = Preferences.getTokenGame(this)
        presenter = AllPresenter(this, this)
        presenter.getHighScoreById(token!!)
//        presenter.getHighScore()
        Log.d("try", "get token : "+token)
    }

    fun settingRvHighScore(){
        rv_highscore.setHasFixedSize(true)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        rv_highscore.layoutManager = layoutManager
        adapter = HighScoreAdapter(scores, this)
        rv_highscore.adapter = adapter
        Log.d("high score", "scores : "+adapter)
    }

    override fun showLoading() {
    }

    override fun error(error: Throwable?) {
    }

    override fun hideLoading() {
    }

    override fun success(response: Any) {
        val highscoreResponse = response as HighscoreResponse
        scores.clear()
        scores.addAll(highscoreResponse.highscoreResult)
        adapter.notifyDataSetChanged()
    }

    override fun onBackPressed() {
    }

    override fun onItemClick(scores: HighscoreData) {
    }

    override fun onItemLongClick(scores: HighscoreData) {
    }
}