package com.gui.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_daftar_pengacara.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class Daftar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btnMasuksignup.setOnClickListener {
            val intent = Intent(this,SelesaiDaftarActivity::class.java)
            startActivity(intent)
        }
        daftarsimple.setOnClickListener {
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }
    }

    fun on(view: View) {

    }
}