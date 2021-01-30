package com.gui.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sign_in_pengacara.*

class SignInPengacaraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_pengacara)
        btnMasukpng.setOnClickListener {
            val intent = Intent(this,HomePangacaraActivity::class.java)
            startActivity(intent)
        }
        btnBelow.setOnClickListener {
            onBackPressed()
        }
    }

    fun r(view: View) {
        val intent = Intent(this,DaftarPengacaraActivity::class.java)
        startActivity(intent)
    }
}