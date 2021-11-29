package com.yasir.tinalahedu.ui.activity.identify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.adapter.IdentifyAdapter
import com.yasir.tinalahedu.model.history.IdentifyHistoryData
import com.yasir.tinalahedu.model.history.IdentifyHistoryResponse
import com.yasir.tinalahedu.presenter.AllPresenter
import com.yasir.tinalahedu.utils.Helper
import com.yasir.tinalahedu.utils.SharedPref
import kotlinx.android.synthetic.main.activity_history_identify.*
import kotlinx.android.synthetic.main.toolbar.*

class ListHistoryIdentifyActivity : AppCompatActivity(), GeneralView, IdentifyAdapter.Listener {
    lateinit var  presenter: AllPresenter
    var identifys : MutableList<IdentifyHistoryData> = mutableListOf()
    lateinit var adapter : IdentifyAdapter
    lateinit var s: SharedPref
    private var userId : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_identify)
        //set nama pada toolbar
        Helper().setToolbar(this,toolbar, "History Identifikasi")

        s = SharedPref(this)

        settingRv()
        loadApiIdentifyHistory()

    }

    fun loadApiIdentifyHistory(){
        val user = s.getUser()!!
        userId = user.idUser
        presenter = AllPresenter(this, this)
        presenter.getHistoryIdentifyByIdUser(userId)
    }

    fun settingRv(){
        rv_scan_history_identify.setHasFixedSize(true)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        rv_scan_history_identify.layoutManager = layoutManager
        adapter = IdentifyAdapter(identifys, this)
        rv_scan_history_identify.adapter = adapter
    }

    override fun showLoading() {
    }

    override fun error(error: Throwable?) {
    }

    override fun success(response: Any) {
        val identifyHistoryResponse = response as IdentifyHistoryResponse
        identifys.clear()
        identifys.addAll(identifyHistoryResponse.identifyHistoryData)
        adapter.notifyDataSetChanged()
    }

    override fun hideLoading() {
    }

    override fun onItemClick(identify: IdentifyHistoryData) {
        val intent = Intent(this, DetailListIdentifyActivity::class.java)
        intent.putExtra("identifikasi", identify)
        startActivity(intent)
    }

    override fun onItemLongClick(identify: IdentifyHistoryData) {
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}