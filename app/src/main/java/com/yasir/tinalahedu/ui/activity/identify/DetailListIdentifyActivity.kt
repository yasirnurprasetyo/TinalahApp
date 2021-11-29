package com.yasir.tinalahedu.ui.activity.identify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.history.IdentifyHistoryData
import com.yasir.tinalahedu.utils.Helper
import kotlinx.android.synthetic.main.activity_detail_list_identify.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailListIdentifyActivity : AppCompatActivity(), GeneralView {
    lateinit var identify : IdentifyHistoryData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_list_identify)
        identify = intent.getParcelableExtra("identifikasi")
        populateData()

        //set nama pada toolbar
        Helper().setToolbar(this,toolbar, "Detail Identifikasi")
    }

    fun populateData(){
        Glide.with(this).load(identify.gambarUrl).into(iv_gambar_detail_history_identify)
        tv_nama_detail_history_identify.setText(identify.namaGambar)
        tv_kategori_detail_history_identify.setText(identify.kategoriGambar)
        tv_deskripsi_detail_history_identify.setText(identify.deskripsiGambar)
    }

    override fun showLoading() {
    }

    override fun error(error: Throwable?) {
    }

    override fun success(response: Any) {
    }

    override fun hideLoading() {
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}