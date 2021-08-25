package com.yasir.tinalahedu.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.utils.SharedPref
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    lateinit var s: SharedPref

    lateinit var tvNama: TextView
    lateinit var tvEmail: TextView
    lateinit var tvPhone: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_profile, container, false)
        s = SharedPref(requireActivity())
        init(view)
        setDataUser()
        return view
    }

    private fun init(view: View){
        tvNama = view.findViewById(R.id.tv_nama)
        tvEmail = view.findViewById(R.id.tv_email)
        tvPhone = view.findViewById(R.id.tv_phone)
    }

    fun setDataUser(){
        val user = s.getUser()!!
        tvNama.text = user.nameUser
        tvEmail.text = user.idUser
        tvPhone.text = user.phoneUser
    }
}