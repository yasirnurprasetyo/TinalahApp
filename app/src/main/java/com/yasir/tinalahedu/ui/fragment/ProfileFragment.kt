package com.yasir.tinalahedu.ui.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tfb.fbtoast.FBToast
import com.yasir.tinalahedu.GeneralView
import com.yasir.tinalahedu.Preferences
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.model.user.UserDeleteRespone
import com.yasir.tinalahedu.presenter.AllPresenter
import com.yasir.tinalahedu.ui.activity.loginRegister.LoginActivity
import com.yasir.tinalahedu.ui.activity.loginRegister.UpdateUserActivity
import com.yasir.tinalahedu.utils.SharedPref
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), GeneralView {
    lateinit var s: SharedPref
    lateinit var presenter: AllPresenter
    private var userId: String = ""
    lateinit var tvNama: TextView
    lateinit var tvEmail: TextView
    lateinit var tvPhone: TextView
    lateinit var ivUser : ImageView
    lateinit var btnLogout: RelativeLayout
    lateinit var btnNonAktif: RelativeLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_profile, container, false)
        s = SharedPref(requireActivity())
        init(view)
        setDataUser()
        mainButton()
        return view
    }


    private fun init(view: View){
        tvNama = view.findViewById(R.id.tv_nama)
        tvEmail = view.findViewById(R.id.tv_email)
        tvPhone = view.findViewById(R.id.tv_phone)
        ivUser = view.findViewById(R.id.iv_user_profile)
        btnLogout = view.findViewById(R.id.btn_logout)
        btnNonAktif = view.findViewById(R.id.btn_off_account)
    }

    fun mainButton(){
        btnLogout.setOnClickListener {
            Preferences.saveToken(requireContext(), "")
            Preferences.savePassword("", requireContext())
            Preferences.saveUsername( "", requireContext())
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }
        btnNonAktif.setOnClickListener {
            alertNonAktifAkun()
        }
    }

    fun setDataUser(){
        val user = s.getUser()!!
        tvNama.text = user.nameUser
        tvEmail.text = user.emailUser
        tvPhone.text = user.phoneUser
        Glide.with(this)
            .load(user.imageUrl)
            .placeholder(R.drawable.ic_profile)
            .centerCrop()
            .into(ivUser)
    }

    fun alertNonAktifAkun(){
        AlertDialog.Builder(requireContext())
            .setTitle("Nonaktif Akun")
            .setMessage("Apakah Anda Yakin Menonaktifkan Akun?")
            .setPositiveButton("Ya", DialogInterface.OnClickListener { dialogInterface, i ->
                Preferences.saveToken(requireContext(), "")
                Preferences.savePassword("", requireContext())
                Preferences.saveUsername( "", requireContext())
                val user = s.getUser()!!
                userId = user.idUser
                presenter = AllPresenter(this, requireActivity().applicationContext)
                presenter.nonaktifAkun(userId)
            })
            .setNegativeButton("Tidak", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })
            .show()
    }

    override fun showLoading() {
    }

    override fun error(error: Throwable?) {
    }

    override fun success(response: Any) {
        val result = response as UserDeleteRespone
        startActivity(Intent(requireContext(), LoginActivity::class.java))
//        startActivity(intent)
        FBToast.successToast(requireContext(), "Akun Berhasil Di Non-Aktifkan", FBToast.LENGTH_SHORT)
    }

    override fun hideLoading() {
    }
}