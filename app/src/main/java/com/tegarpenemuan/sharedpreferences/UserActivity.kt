package com.tegarpenemuan.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tegarpenemuan.sharedpreferences.helper.Constant
import com.tegarpenemuan.sharedpreferences.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    lateinit var sharedpref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        sharedpref = PreferencesHelper(this)

        textUsername.text = sharedpref.getString(Constant.PREF_USERNAME)

        buttonLogout.setOnClickListener {
            sharedpref.clear()
            moveIntent()
            showMessage("Keluar")
        }
    }

    private fun showMessage(message:String) {
        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
    }

    private fun moveIntent(){
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}