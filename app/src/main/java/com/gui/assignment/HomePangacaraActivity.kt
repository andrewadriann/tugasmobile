package com.gui.assignment

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home_pangacara.*

class HomePangacaraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_pangacara)
        moveToFragment(PengacaraHomeFragment())
        maintitle.setText(txtLaw1.text.toString())


        menu.setOnClickListener {
            val intent = Intent(this,MenuPangacaraActivity::class.java)
            startActivity(intent)
        }
    }
    private fun moveToFragment(fragment: Fragment)
    {
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container,fragment)
        fragmentTrans.commit()


    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun third(view: View) {
        moveToFragment(ProfilePangacaraFragment())
        law1.setImageResource(R.drawable.law)
        txtLaw1.setTextColor(getColor(R.color.purple_200))
        cmmnt.setImageResource(R.drawable.commnt)
        cmmnttxt.setTextColor(getColor(R.color.purple_200))

        prpng.setImageResource(R.drawable.personyellow)
        pngtxt.setTextColor(getColor(R.color.textColor))
        maintitle.setText(pngtxt.text.toString())

    }
    @RequiresApi(Build.VERSION_CODES.M)
    fun secnd(view: View) {
        moveToFragment(PesanFragment())
        law1.setImageResource(R.drawable.law)
        txtLaw1.setTextColor(getColor(R.color.purple_200))
        cmmnt.setImageResource(R.drawable.commntyellow)
        cmmnttxt.setTextColor(getColor(R.color.textColor))
        maintitle.setText(cmmnttxt.text.toString())


        prpng.setImageResource(R.drawable.profile)
        pngtxt.setTextColor(getColor(R.color.purple_200))
    }
    @RequiresApi(Build.VERSION_CODES.M)
    fun first(view: View) {
        moveToFragment(PengacaraHomeFragment())

        law1.setImageResource(R.drawable.lawyellow)
        txtLaw1.setTextColor(getColor(R.color.textColor))
        maintitle.setText(txtLaw1.text.toString())

        cmmnt.setImageResource(R.drawable.commnt)
        cmmnttxt.setTextColor(getColor(R.color.purple_200))

        prpng.setImageResource(R.drawable.profile)
        pngtxt.setTextColor(getColor(R.color.purple_200))
    }
}