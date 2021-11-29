package com.yasir.tinalahedu.ui.activity.game

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.Preferences
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.adapter.DetailScanAdapter
import com.yasir.tinalahedu.model.scanDetail.ScanDetailData
import com.yasir.tinalahedu.model.scanDetail.ScanDetailResponse
import com.yasir.tinalahedu.presenter.AllPresenter
import com.yasir.tinalahedu.ui.activity.history.HistoryActivity
import com.yasir.tinalahedu.ui.activity.main.MainActivity
import com.yasir.tinalahedu.utils.Helper
import com.yasir.tinalahedu.utils.SharedPref
import kotlinx.android.synthetic.main.activity_detail_scan.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailScanActivity : AppCompatActivity(), GeneralView, DetailScanAdapter.Listener {
    lateinit var presenter: AllPresenter
    var details: MutableList<ScanDetailData> = mutableListOf()
    lateinit var adapter : DetailScanAdapter
    lateinit var s: SharedPref
    private var userId: String = ""
    private var hasilScan: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_scan)

        //set nama pada toolbar
        Helper().setToolbar(this,toolbar, "Detail Scan Objek")
        setButton()

        s = SharedPref(this)

        settingRV()
        loadApiGetDetailScan()
    }

    fun setButton(){
        btn_scan_objek_again.setOnClickListener {
            startActivity(Intent(this@DetailScanActivity, ScanObjekActivity::class.java))
        }
        btn_scan_objek_history.setOnClickListener {
            alertClickHistory()
        }
        btn_scan_objek_home.setOnClickListener {
            alertClickHome()
        }
    }

    fun alertClickHistory() {
        AlertDialog.Builder(this)
            .setTitle("Keluar Permainan")
            .setMessage("Apakah Anda Yakin Ingin Keluar Menuju Halaman History?")
            .setPositiveButton("Ya", DialogInterface.OnClickListener { dialogInterface, i ->
                val intent = Intent(this@DetailScanActivity, HistoryActivity::class.java)
                startActivity(intent)
                Preferences.saveTokenGameNull("", this)
                finish()
            })
            .setNegativeButton("Tidak", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })
            .show()
    }

    fun alertClickHome(){
        AlertDialog.Builder(this)
            .setTitle("Keluar Permainan")
            .setMessage("Apakah Anda Yakin Ingin Keluar?")
            .setPositiveButton("Ya", DialogInterface.OnClickListener { dialogInterface, i ->
                val intent = Intent(this@DetailScanActivity, MainActivity::class.java)
                startActivity(intent)
                Preferences.saveTokenGameNull("", this)
                finish()
            })
            .setNegativeButton("Tidak", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })
            .show()
    }

    fun loadApiGetDetailScan(){
        val user = s.getUser()!!
        userId = user.idUser
        presenter = AllPresenter(this, this)
        presenter.getDetailScanGame(userId)
    }

    fun settingRV(){
        rv_detail.setHasFixedSize(true)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        rv_detail.layoutManager = layoutManager
        adapter = DetailScanAdapter(details, this)
        rv_detail.adapter = adapter
    }

    override fun showLoading() {
        pb_detail_scan.visibility = View.VISIBLE
    }

    override fun error(error: Throwable?) {
        Log.e("detailscan", "error : "+error)
    }

    override fun success(response: Any) {
        val detailResponse = response as ScanDetailResponse
        details.clear()
        details.addAll(listOf(detailResponse.result))
        adapter.notifyDataSetChanged()
//        Log.d("success", "detail : "+detailResponse)
//        Log.d("success", "response : "+response)
    }

    override fun hideLoading() {
        pb_detail_scan.visibility = View.GONE
    }

    override fun onItemClick(detail: ScanDetailData) {
    }

    override fun onItemLongClick(detail: ScanDetailData) {
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}