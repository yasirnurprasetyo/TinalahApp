package com.yasir.tinalahedu.ui.activity.loginRegister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yasir.tinalahedu.R
import com.yasir.tinalahedu.utils.Helper
import kotlinx.android.synthetic.main.toolbar.*

class UpdateUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user)

        //set nama pada toolbar
        Helper().setToolbar(this,toolbar, "Update Profile")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}