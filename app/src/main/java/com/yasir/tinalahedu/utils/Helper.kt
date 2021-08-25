package com.yasir.tinalahedu.utils

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class Helper {
    fun setToolbar(activity: Activity, toolbar: Toolbar, title: String) {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        activity.supportActionBar!!.title = title
        activity.supportActionBar!!.setDisplayShowHomeEnabled(true)
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}