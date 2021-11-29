package com.yasir.tinalahedu.ui.activity.history

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.adapter.ScanAdapter
import com.yasir.tinalahedu.model.history.HistoryData
import com.yasir.tinalahedu.model.history.HistoryResponse
import com.yasir.tinalahedu.presenter.AllPresenter
import com.yasir.tinalahedu.utils.Helper
import com.yasir.tinalahedu.utils.SharedPref
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.toolbar.*

class HistoryActivity : AppCompatActivity(), GeneralView, ScanAdapter.Listener {
    lateinit var presenter: AllPresenter
    var scans: MutableList<HistoryData> = mutableListOf()
    lateinit var adapter: ScanAdapter
    lateinit var s: SharedPref
    private var userId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        //set nama pada toolbar
        Helper().setToolbar(this,toolbar, "History Scan")

        s = SharedPref(this)

        settingRv()
        loadApiScanHistory()
    }

    fun loadApiScanHistory(){
        val user = s.getUser()!!
        userId = user.idUser
        presenter = AllPresenter(this, this)
        presenter.getHistoryByUser(userId)
//        Log.d("userID", "user id : "+userId)
    }

    fun settingRv(){
        rv_scan_history.setHasFixedSize(true)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        rv_scan_history.layoutManager = layoutManager
        adapter = ScanAdapter(scans, this)
        rv_scan_history.adapter = adapter
    }

    override fun showLoading() {
    }

    override fun error(error: Throwable?) {
    }

    override fun success(response: Any) {
        val historyRespon = response as HistoryResponse
        scans.clear()
        scans.addAll(historyRespon.historyData)
        adapter.notifyDataSetChanged()
    }

    override fun hideLoading() {
    }

    override fun onItemClick(scan: HistoryData) {
        val intent = Intent(this, DetailHistoryActivity::class.java)
        intent.putExtra("scan",scan)
        startActivity(intent)
    }

    override fun onItemLongClick(scan: HistoryData) {
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}