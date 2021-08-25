package com.yasir.tinalahedu.ui.activity.loginRegister

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import com.bumptech.glide.Glide
import com.tfb.fbtoast.FBToast
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.user.UserData
import com.yasir.tinalahedu.presenter.AllPresenter
import com.yasir.tinalahedu.ui.activity.main.MainActivity
import kotlinx.android.synthetic.main.activity_register.*
import java.io.ByteArrayOutputStream

class RegisterActivity : AppCompatActivity(), GeneralView {
    lateinit var presenter: AllPresenter
    private var imageBase64: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        settingRegisterButton()
    }

    private fun validate(): Boolean{
        var result = true
        if(imageBase64 == "" ||
                et_name_register.text.toString() == "" ||
                et_password_register.text.toString() == "" ||
                et_email_register.text.toString() == ""
        ){
            result = false
        }
        return result
    }

    fun settingRegisterButton(){
        btn_register.setOnClickListener {
            val userData = UserData(
                "",
                et_name_register.text.toString(),
                et_email_register.text.toString(),
                et_password_register.text.toString(),
                et_phone_register.text.toString(),
                imageBase64,
                "",
                "",
                "",
                "",
                "",
                ""
            )
            if(validate()) {
                btn_register.isEnabled = false
                presenter = AllPresenter(this, this)
                presenter.register(userData)
            }else{
                FBToast.errorToast(this,"Ada inputan yang masih salah", FBToast.LENGTH_SHORT)
            }
        }
        iv_image_user_register.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 12)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 12 && resultCode == Activity.RESULT_OK) {
            var bitmap = data?.extras?.get("data") as Bitmap
            val byteArrayOS = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOS)
            imageBase64 = Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT)
            Glide.with(this).load(bitmap).into(iv_image_user_register)
        }
    }

    override fun showLoading() {
    }

    override fun error(error: Throwable?) {
        FBToast.errorToast(this, "Registrasi gagal : "+error, FBToast.LENGTH_SHORT)
        Log.e("error", "kesalahan register : "+error)
    }

    override fun success(response: Any) {
        FBToast.successToast(this, "Registrasi berhasil", FBToast.LENGTH_SHORT)
        et_name_register.setText("")
        et_email_register.setText("")
        et_password_register.setText("")
        et_phone_register.setText("")
        imageBase64 = ""
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun hideLoading() {
    }
}