package com.yasir.tinalahedu.presenter

import android.content.Context
import android.util.Log
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.model.identify.IdentifyData
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

    fun verifyTokenHighScore(token : String){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.verifiyTokenHighScore(token)
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

    fun getDetailScanGame(userId: String){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.getDetailScanGame(userId)
        //Log.d("hhhh", "request : "+request)
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

    fun getDetailScan(){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.getDetailScanGame()
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

    fun getHistoryByUser(userId : String){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.getHistoryScanByUserLogin(userId)
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

    fun getHighScore(){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.getHighScore()
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

    fun getHighScoreById(tokenGameId : String){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.getHighScoreById(tokenGameId)
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

    fun getDetailIdentify(userId : String){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.getDetailIdentify(userId)
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = request.await()
                view.success(response)
            } catch (e: Exception){
                view.error(e)
            }
            view.hideLoading()
        }
    }

    fun identifyObjek(identify : IdentifyData){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.identifyObjek(
            identify.idIdentify,
            identify.gambarIdentify,
            identify.gambarIdentifyUrl,
            identify.gambarIdIdentify,
            identify.userIdIdentify
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

    fun getHistoryIdentifyByIdUser(userId : String){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.getHistoryIdentifyByIdUser(userId)
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = request.await()
                view.success(response)
            } catch (e: Exception){
                view.error(e)
            }
            view.hideLoading()
        }
    }

    fun nonaktifAkun(id: String){
        view.showLoading()
        val api = RetrofitFactory.create(context)
        val request = api.nonAktifAkun(id)
        CoroutineScope(Dispatchers.Main).launch {
            try{
                val response = request.await()
                view.success(response)
            }catch(e: Exception){
                view.error(e)
            }
            view.hideLoading()
        }
    }
}