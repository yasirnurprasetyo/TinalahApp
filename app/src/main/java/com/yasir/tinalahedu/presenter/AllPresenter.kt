package com.yasir.tinalahedu.presenter

import android.content.Context
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.model.scan.ScanData
import com.yasir.tinalahedu.model.user.UserData
import com.yasir.tinalahedu.service.RetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllPresenter(private val view: GeneralView, private val context: Context) {
    fun getToken(login: String) {
        view.showLoading()
        val api = RetrofitFactory.createLogin()
        val request = api.login(login)
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = request.await()
                view.success(response)
            } catch (e: Exception) {
                view.error(e)
            }
            view.hideLoading()
        }
    }

    fun register(user: UserData){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.register(
            user.nameUser,
            user.emailUser,
            user.passwordUser,
            user.phoneUser,
            user.imageUser
        )
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = request.await()
                view.success(response)
            } catch (e: Exception) {
                view.error(e)
            }
            view.hideLoading()
        }
    }

    fun verifyToken(token : String){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.verifiyToken(token)
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = request.await()
                view.success(response)
            } catch (e: Exception) {
                view.error(e)
            }
            view.hideLoading()
        }
    }

    fun scanObjek(scan : ScanData){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.scanObjek(
            scan.idScan,
            scan.gambarId,
            scan.tokengameId,
            scan.userId,
            scan.gambarScan,
            scan.gambarScanUrl,
            scan.totalSkor,
            scan.createAt,
            scan.updateAt
        )
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = request.await()
                view.success(response)
            } catch (e: Exception) {
                view.error(e)
            }
            view.hideLoading()
        }
    }

    fun getHistoryByUser(){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.getHistoryScanByUserLogin()
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = request.await()
                view.success(response)
            } catch (e: Exception) {
                view.error(e)
            }
            view.hideLoading()
        }
    }
}