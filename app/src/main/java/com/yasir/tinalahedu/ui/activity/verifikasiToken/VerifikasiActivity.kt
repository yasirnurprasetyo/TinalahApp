package com.yasir.tinalahedu.ui.activity.verifikasiToken

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tfb.fbtoast.FBToast
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.game.GameData
import com.yasir.tinalahedu.model.game.VerifyResponse
import com.yasir.tinalahedu.presenter.AllPresenter
import com.yasir.tinalahedu.ui.activity.game.ScanObjekActivity
import com.yasir.tinalahedu.ui.activity.main.MainActivity
import com.yasir.tinalahedu.utils.Helper
import com.yasir.tinalahedu.utils.SharedPref
import kotlinx.android.synthetic.main.activity_verifikasi.*
import kotlinx.android.synthetic.main.toolbar.*

class VerifikasiActivity : AppCompatActivity(), GeneralView {
    lateinit var presenter: AllPresenter
    lateinit var s : SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verifikasi)

        //set nama pada toolbar
        Helper().setToolbar(this,toolbar, "Verifikasi Token")

        s = SharedPref(this)

        setButtonVerify()
    }

    fun setButtonVerify(){
        btn_verifikasi_token.setOnClickListener {
            val token = et_verifikasi_token.text.toString()
            if(token.isEmpty()){
                FBToast.errorToast(this, "Silahkan Masukkan Token", FBToast.LENGTH_SHORT)
            }else{
                presenter = AllPresenter(this, this)
                presenter.verifyToken(token)
            }
        }
    }


    override fun error(error: Throwable?) {
        FBToast.errorToast(this, "Verifikasi Token Gagal", FBToast.LENGTH_SHORT)
    }

    override fun success(response: Any) {
        val result = response as VerifyResponse
        val intent = Intent(this, ScanObjekActivity::class.java)
        s.setToken(result.result)
        startActivity(intent)
        FBToast.successToast(this, "Verifikasi Token Berhasil", FBToast.LENGTH_SHORT)
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}