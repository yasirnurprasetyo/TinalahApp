package com.yasir.tinalahedu.ui.activity.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Base64
import android.util.Log
import android.view.WindowManager
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.Preferences
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.login.LoginResponse
import com.yasir.tinalahedu.presenter.AllPresenter
import com.yasir.tinalahedu.ui.activity.loginRegister.LoginActivity
import com.yasir.tinalahedu.ui.activity.main.MainActivity

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity(), GeneralView {
    private lateinit var presenter: AllPresenter
    private var noAutoLogin = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter = AllPresenter(this, this)
        presenter.getHighScore()
    }

    override fun showLoading() {
        Log.d("Splash", "Mulai")
    }

    override fun error(error: Throwable?) {
        if(noAutoLogin){
            noAutoLogin = false
            val username = Preferences.getUsername(this)
            val password = Preferences.getPassword(this)
            val strAuth = username + ":" + password
            val auth = "Basic " + Base64.encodeToString(strAuth.toByteArray(), Base64.NO_WRAP)
            presenter.getToken(auth)
            return
        }
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun success(response: Any) {
        if(!noAutoLogin){
            val responseLogin =response as LoginResponse
            val token = responseLogin.token
            Preferences.saveToken(this, token)
        }
        val res = response as LoginResponse
        val nama = res.loginResult.nameUser
        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.putExtra("message", nama)
        startActivity(intent)
        finish()
    }

    override fun hideLoading() {
        Log.d("Splash", "Selesai")
    }
}