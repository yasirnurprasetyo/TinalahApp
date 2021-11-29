package com.yasir.tinalahedu.ui.activity.identify

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
import com.yasir.tinalahedu.adapter.DetailIdentifyAdapter
import com.yasir.tinalahedu.model.identifyDetail.IdentifyDetailResponse
import com.yasir.tinalahedu.model.identifyDetail.IdentifyDetailData
import com.yasir.tinalahedu.presenter.AllPresenter
import com.yasir.tinalahedu.ui.activity.main.MainActivity
import com.yasir.tinalahedu.utils.Helper
import com.yasir.tinalahedu.utils.SharedPref
import kotlinx.android.synthetic.main.activity_detail_identify.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailIdentifyActivity : AppCompatActivity(), GeneralView, DetailIdentifyAdapter.Listener {
    lateinit var presenter: AllPresenter
    var details : MutableList<IdentifyDetailData> = mutableListOf()
    lateinit var adapter: DetailIdentifyAdapter
    lateinit var s: SharedPref
    private var userId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_identify)

        //set nama pada toolbar
        Helper().setToolbar(this,toolbar, "Detail Identify Objek")
        setButton()

        s = SharedPref(this)

        settingRV()
        loadApiGetDetailIdentify()
    }

    fun setButton(){
        btn_identify_objek_again.setOnClickListener {
            startActivity(Intent(this@DetailIdentifyActivity, IdentifyActivity::class.java))
        }
        btn_list_identify_home.setOnClickListener {
            alertClickHome()
        }
        btn_list_history_identify.setOnClickListener {
            startActivity(Intent(this@DetailIdentifyActivity, ListHistoryIdentifyActivity::class.java))
        }
    }

    fun alertClickHome(){
        AlertDialog.Builder(this)
            .setTitle("Keluar Identifikasi")
            .setMessage("Apakah Anda Yakin Ingin Keluar?")
            .setPositiveButton("Ya", DialogInterface.OnClickListener { dialogInterface, i ->
                val intent = Intent(this@DetailIdentifyActivity, MainActivity::class.java)
                startActivity(intent)
                Preferences.saveTokenGameNull("", this)
                finish()
            })
            .setNegativeButton("Tidak", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })
            .show()
    }

    fun loadApiGetDetailIdentify(){
        val user = s.getUser()!!
        userId = user.idUser
        presenter = AllPresenter(this,this)
        presenter.getDetailIdentify(userId)
    }

    fun settingRV(){
        rv_detail_identify.setHasFixedSize(true)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        rv_detail_identify.layoutManager = layoutManager
        adapter = DetailIdentifyAdapter(details, this)
        rv_detail_identify.adapter = adapter
    }

    override fun showLoading() {
        pb_detail_identify.visibility = View.VISIBLE
    }

    override fun error(error: Throwable?) {
        Log.e("detailidentify", "error : "+error)
    }

    override fun success(response: Any) {
        val detailResponse = response as IdentifyDetailResponse
        details.clear()
        details.addAll(listOf(detailResponse.identifyDetailData))
        adapter.notifyDataSetChanged()
    }

    override fun hideLoading() {
        pb_detail_identify.visibility = View.GONE
    }

    override fun onItemClick(detail: IdentifyDetailData) {
    }

    override fun onItemLongClick(detail: IdentifyDetailData) {
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}