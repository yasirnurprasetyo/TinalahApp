package com.yasir.tinalahedu.ui.activity.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.history.HistoryData
import com.yasir.tinalahedu.utils.Helper
import kotlinx.android.synthetic.main.activity_detail_history.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailHistoryActivity : AppCompatActivity(), GeneralView {
    lateinit var scan : HistoryData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_history)
        scan = intent.getParcelableExtra("scan")
        populateData()

        //set nama pada toolbar
        Helper().setToolbar(this,toolbar, "Detail Scan Objek")
    }

    fun populateData(){
        Glide.with(this).load(scan.gambarScanUrl).into(iv_gambar_detail_history)
        tv_nama_detail_history.setText(scan.namaGambar)
        tv_kategori_detail_history.setText(scan.gambar)
        tv_deskripsi_detail_history.setText(scan.kategoriGambar)
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