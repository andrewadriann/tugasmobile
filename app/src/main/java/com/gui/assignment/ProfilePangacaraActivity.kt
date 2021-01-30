package com.gui.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile_pangacara.*

class ProfilePangacaraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_pangacara)
        backbutn.setOnClickListener {
            onBackPressed()
        }
        calenderBtn.setOnClickListener {
            val intent = Intent (this, JanjiActivity::class.java)
            startActivity(intent)
        }
    }
}