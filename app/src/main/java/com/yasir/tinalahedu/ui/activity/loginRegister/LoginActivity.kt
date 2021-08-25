package com.yasir.tinalahedu.ui.activity.loginRegister

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.tfb.fbtoast.FBToast
import com.yasir.tinalahedu.LoginView
import com.yasir.tinalahedu.Preferences.saveToken
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.login.LoginResponse
import com.yasir.tinalahedu.presenter.LoginPresenter
import com.yasir.tinalahedu.ui.activity.main.MainActivity
import com.yasir.tinalahedu.utils.SharedPref
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {
    lateinit var presenter: LoginPresenter
    lateinit var s : SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter=LoginPresenter(this)
        s = SharedPref(this)

        setClickLoginButton()
        checkAndRequestPermissions()
        mainButton()
    }

    fun mainButton(){
        btn_register_login.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
    }

    private fun setClickLoginButton() {
        btn_login.setOnClickListener {
            val username = et_username_login.text.toString()
            val password = et_password_login.text.toString()
            presenter.login(username, password)
        }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun error(error: Throwable?) {
        FBToast.errorToast(this, "Login Gagal" , FBToast.LENGTH_SHORT)
        Log.e("error", "kesalahan : "+error)
    }

    override fun success(response: LoginResponse) {
        saveToken(this, response.loginResult.tokenUser)
        s.setUser(response.loginResult)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        FBToast.successToast(this, "Login Berhasil", FBToast.LENGTH_SHORT)
        finish()
    }

    private fun checkAndRequestPermissions(): Boolean {
//        val locationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        val cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        val readExternalPermission =
            ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        val writeExternalPermission =
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val listPermissionsNeeded = arrayListOf<String>()
//        if (locationPermission != PackageManager.PERMISSION_GRANTED) {
//            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION)
//        }
        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA)
        }
        if (readExternalPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        if (writeExternalPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toTypedArray(), 400)
            return false
        }
        return true
    }
}