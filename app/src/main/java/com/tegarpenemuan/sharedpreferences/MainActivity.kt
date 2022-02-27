package com.tegarpenemuan.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.tegarpenemuan.sharedpreferences.helper.Constant
import com.tegarpenemuan.sharedpreferences.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedpref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedpref = PreferencesHelper(this)

        buttonLogin.setOnClickListener {
            if(editUsername.text.isNotEmpty() && editPassword.text.isNotEmpty()) {
                saveSession(editUsername.text.toString(),editPassword.text.toString())
                showMessage("Berhasil Masuk")
                moveIntent()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if(sharedpref.getBoolean(Constant.PREF_IS_LOGIN) == true) {
            moveIntent()
        }
    }

    private fun moveIntent(){
        startActivity(Intent(this,UserActivity::class.java))
        finish()
    }

    private fun saveSession(username:String,password:String) {
        sharedpref.put(Constant.PREF_USERNAME, username)
        sharedpref.put(Constant.PREF_PASSWORD, password)
        sharedpref.put(Constant.PREF_IS_LOGIN,true)
    }

    private fun showMessage(message:String) {
        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }
}