package com.yasir.tinalahedu.ui.activity.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.scanDetail.ScanDetailData
import com.yasir.tinalahedu.presenter.AllPresenter
import com.yasir.tinalahedu.utils.Helper
import kotlinx.android.synthetic.main.activity_detail_scan.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailScanActivity : AppCompatActivity(), GeneralView {
    lateinit var scan : ScanDetailData
    lateinit var presenter: AllPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_scan)

        //set nama pada toolbar
        Helper().setToolbar(this,toolbar, "Detail Scan Objek")
//        scan = intent.getParcelableExtra("scan")
//        callApi()
    }

    private fun callApi(){
        presenter = AllPresenter(this,this)
//        presenter.getHasil(scan.idScan)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun showLoading() {
    }

    override fun error(error: Throwable?) {
    }

    override fun success(response: Any) {
//        populateData()
    }

    override fun hideLoading() {
    }

    fun populateData(){
//        Glide.with(this).load(scan.)
        tv_detail_nama.setText(scan.namaGambar)
        tv_detail_kategori.setText(scan.kategori)
    }
}