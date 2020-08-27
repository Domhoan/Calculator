package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.*
import java.security.Key

class MainActivity : AppCompatActivity() , SendTextListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragShow, ShowFragment.instance!!).commit()
        supportFragmentManager.beginTransaction().add(R.id.fragKey, KeyFragment.instance!!).commit()
        KeyFragment.instance!!.setSendTextListener(this)
    }


    override fun sendText(newString : String) {
        ShowFragment.instance!!.getText(newString)
    }


}