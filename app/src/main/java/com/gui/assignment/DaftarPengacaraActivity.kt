package com.gui.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_daftar_pengacara.*

class DaftarPengacaraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_pengacara)
        btnMasuk.setOnClickListener {
            val intent = Intent(this,HomePangacaraActivity::class.java)
            startActivity(intent)
        }
    }

    fun on(view: View) {}
}