package com.yasir.tinalahedu.ui.activity.identify

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
import com.yasir.tinalahedu.model.identify.IdentifyData
import com.yasir.tinalahedu.model.identify.IdentifyResponse
import com.yasir.tinalahedu.presenter.AllPresenter
import com.yasir.tinalahedu.utils.Helper
import com.yasir.tinalahedu.utils.SharedPref
import kotlinx.android.synthetic.main.activity_identify.*
import kotlinx.android.synthetic.main.toolbar.*
import java.io.ByteArrayOutputStream

class IdentifyActivity : AppCompatActivity(), GeneralView {
    private var imageBase64: String = ""
    private var userId: String = ""
    lateinit var presenter: AllPresenter
    lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identify)

        //set nama pada toolbar
        Helper().setToolbar(this,toolbar, "Identify Objek")

        s = SharedPref(this)
        setButtonIdentifyObjek()
    }

    fun setButtonIdentifyObjek(){
        btn_identify_objek.setOnClickListener {
            val identifyData = IdentifyData(
                "",
                imageBase64,
                "",
                "",
                userId
            )
            presenter = AllPresenter(this, this)
            presenter.identifyObjek(identifyData)
//            Log.d("identify", "data : "+identifyData)
        }
        btn_take_objek.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 12)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 12 && resultCode == Activity.RESULT_OK){
            val bitmap = data?.extras?.get("data") as Bitmap
            val user = s.getUser()!!
            val byteArrayOS = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOS)
            imageBase64 = Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT)
            userId = user.idUser
            Glide.with(this).load(bitmap).into(iv_identify)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun showLoading() {
    }

    override fun error(error: Throwable?) {
        FBToast.errorToast(this, "Identifikasi gagal atau objek tidak teridentifikasi", FBToast.LENGTH_SHORT)
    }

    override fun success(response: Any) {
        val res = response as IdentifyResponse
        val intent = Intent(this, DetailIdentifyActivity::class.java)
        startActivity(intent)
        FBToast.successToast(this, "Identifikasi berhasil", FBToast.LENGTH_SHORT)
    }

    override fun hideLoading() {
    }
}