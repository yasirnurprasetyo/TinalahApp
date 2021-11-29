package com.yasir.tinalahedu.ui.activity.highScore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tfb.fbtoast.FBToast
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.Preferences
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.game.VerifyResponse
import com.yasir.tinalahedu.presenter.AllPresenter
import com.yasir.tinalahedu.utils.Helper
import com.yasir.tinalahedu.utils.SharedPref
import kotlinx.android.synthetic.main.activity_verifikasi_high_score.*
import kotlinx.android.synthetic.main.toolbar.*

class VerifikasiHighScoreActivity : AppCompatActivity(), GeneralView {
    lateinit var presenter : AllPresenter
    lateinit var s : SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verifikasi_high_score)

        //set nama toolbar
        Helper().setToolbar(this, toolbar, "Verifikasi Token Highscore")

        s = SharedPref(this)

        setButtonVerify();
    }

    fun setButtonVerify(){
        btn_verifikasi_token_high_score.setOnClickListener {
            val token = et_verifikasi_token_high_score.text.toString()
            if(token.isEmpty()){
                FBToast.errorToast(this, "Silahkan Masukkan Token", FBToast.LENGTH_SHORT)
            }else{
                //panggil presenter post verify
                btn_verifikasi_token_high_score.setOnClickListener {
                    val token = et_verifikasi_token_high_score.text.toString()
                    if(token.isEmpty()){
                        FBToast.errorToast(this, "Verifikasi Token Gagal", FBToast.LENGTH_SHORT)
                    }else{
                        presenter = AllPresenter(this, this)
                        presenter.verifyTokenHighScore(token)
                    }
                }
            }
        }
    }

    override fun showLoading() {
    }

    override fun error(error: Throwable?) {
    }

    override fun success(response: Any) {
        val result = response as VerifyResponse
        val intent = Intent(this, HighscoreActivity::class.java)
        val resultall = result.result
        val id = resultall.idGame
        Preferences.saveTokenGameNull(id, this)
        startActivity(intent)
        FBToast.successToast(this, "Verifikasi Token Berhasil", FBToast.LENGTH_SHORT)
        Log.d("try", "get token : "+id)
    }

    override fun hideLoading() {
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}