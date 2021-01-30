package com.gui.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        btnMasuksimple.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun on(view: View) {
        val intent = Intent(this,SignInPengacaraActivity::class.java)
        startActivity(intent)
    }

    fun go(view: View) {
        val intent = Intent(this,Daftar::class.java)
        startActivity(intent)
    }


}