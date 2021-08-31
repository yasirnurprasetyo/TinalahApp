package com.yasir.tinalahedu.ui.activity.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.utils.Helper
import kotlinx.android.synthetic.main.toolbar.*

class HighscoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_highscore)

        //set nama pada toolbar
        Helper().setToolbar(this,toolbar, "High Score")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}