package com.gui.assignment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.oscarvera.calendarhorizontal.setBackground
import kotlinx.android.synthetic.main.activity_janji.*

class JanjiActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_janji)
        backbuttn.setOnClickListener {
            onBackPressed()
        }
        btnTerms.setOnClickListener {
            val intent = Intent (this, SuccesActivity::class.java)
            startActivity(intent)
        }
        var i =0

        frt.setOnClickListener {

            if (frt.isPressed)
            {
                if (i/2==0 || i==0)
                {
                    frt.setBackground(resources.getDrawable(R.drawable.shape2))
                    i++
                }
                else
                {
                    frt.setBackground(resources.getDrawable(R.drawable.shape))
                    i++
                }
            }




        }
//        scd.setOnClickListener {
//            if(scd.resources.equals(R.drawable.shape))
//            {
//                scd.setBackgroundDrawable(getDrawable(R.drawable.shape2))
//            }
//            else
//            {
//                scd.setBackgroundDrawable(getDrawable(R.drawable.shape))
//            }
//        }
//        frth.setOnClickListener {
//            if(frth.resources.equals(R.drawable.shape))
//            {
//                frth.setBackgroundDrawable(getDrawable(R.drawable.shape2))
//            }
//            else
//            {
//                frth.setBackgroundDrawable(getDrawable(R.drawable.shape))
//            }
//        }
//        fifth.setOnClickListener {
//            if(fifth.resources.equals(R.drawable.shape))
//            {
//                fifth.setBackgroundDrawable(getDrawable(R.drawable.shape2))
//            }
//            else
//            {
//                fifth.setBackgroundDrawable(getDrawable(R.drawable.shape))
//            }
//        }
//        six.setOnClickListener {
//            if(six.resources.equals(R.drawable.shape))
//            {
//                six.setBackgroundDrawable(getDrawable(R.drawable.shape2))
//            }
//            else
//            {
//                six.setBackgroundDrawable(getDrawable(R.drawable.shape))
//            }
//        }
//        thrd.setOnClickListener {
//            if(thrd.resources.equals(R.drawable.shape))
//            {
//                thrd.setBackgroundDrawable(getDrawable(R.drawable.shape2))
//            }
//            else
//            {
//                thrd.setBackgroundDrawable(getDrawable(R.drawable.shape))
//            }
//        }
    }
}