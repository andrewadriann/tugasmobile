package com.gui.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        backbtn.setOnClickListener{
            onBackPressed()
        }
        selasai.setOnClickListener {
            val intent = Intent (this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}