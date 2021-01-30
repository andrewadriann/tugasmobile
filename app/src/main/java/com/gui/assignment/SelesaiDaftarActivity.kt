package com.gui.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_selesai_daftar.*

class SelesaiDaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selesai_daftar)
        loginPengacara.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent) }
    }
}