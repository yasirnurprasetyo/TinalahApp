package com.yasir.tinalahedu.ui.activity.game

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
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
import com.yasir.tinalahedu.Preferences
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.scan.ScanData
import com.yasir.tinalahedu.presenter.AllPresenter
import com.yasir.tinalahedu.ui.activity.main.MainActivity
import com.yasir.tinalahedu.utils.Helper
import com.yasir.tinalahedu.utils.SharedPref
import kotlinx.android.synthetic.main.activity_scan_objek.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar_custom.*
import java.io.ByteArrayOutputStream

class ScanObjekActivity : AppCompatActivity(), GeneralView {
    private var imageBase64: String = ""
    private var userId: String = ""
    private var tokenId: String = ""
    lateinit var presenter: AllPresenter
    lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_objek)
        //set nama pada toolbar
        Helper().setToolbarHome(this,toolbar_custom, "Scan Objek")

        s = SharedPref(this)
        setButtonScanObject()
    }

    fun setButtonScanObject(){
        btn_detail_objek_game.setOnClickListener {
            val scanData = ScanData(
                "",
                "",
                tokenId,
                userId,
                imageBase64,
                "",
                "",
                "",
                ""
            )
            presenter = AllPresenter(this, this)
            presenter.scanObjek(scanData)
//            Log.d("coba", "data : "+scanData)
        }
        btn_scan_objek_game.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 12)
        }
        btn_toDashboard.setOnClickListener {
            alertClick()
        }
    }

    fun alertClick(){
        AlertDialog.Builder(this)
            .setTitle("Keluar Permainan")
            .setMessage("Apakah Anda Yakin Ingin Keluar?")
            .setPositiveButton("Ya", DialogInterface.OnClickListener { dialogInterface, i ->
                val intent = Intent(this@ScanObjekActivity, MainActivity::class.java)
                startActivity(intent)
                Preferences.saveTokenGameNull("", this)
                finish()
            })
            .setNegativeButton("Tidak", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })
            .show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 12 && resultCode == Activity.RESULT_OK) {
            var bitmap = data?.extras?.get("data") as Bitmap
            val user = s.getUser()!!
            val token = s.getToken()!!
            val byteArrayOS = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOS)
            imageBase64 = Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT)
            userId = user.idUser
            tokenId = token.idGame
            Glide.with(this).load(bitmap).into(iv_scan_objek_game)
//            Log.d("coba", "data userid : "+userId)
//            Log.d("coba", "data tokenid : "+tokenId)
        }
    }

    override fun showLoading() {
    }

    override fun error(error: Throwable?) {
        FBToast.errorToast(this, "gagal : "+error, FBToast.LENGTH_SHORT)
        Log.e("error", "kesalahan register : "+error)
    }

    override fun success(response: Any) {
//        val result = response as ScanDetailData
        val intent = Intent(this, DetailScanActivity::class.java)
//        intent.putExtra("scan", result.idScan)
        startActivity(intent)
        FBToast.successToast(this, "Scan berhasil", FBToast.LENGTH_SHORT)
    }

    override fun hideLoading() {
    }

    override fun onBackPressed() {

    }
}
