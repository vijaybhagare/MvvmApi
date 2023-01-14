package com.vb.mvvmapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_screen)
        supportActionBar?.hide()
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { _, _ ->
            WindowInsetsCompat.CONSUMED


        }



        val handler= Handler(Looper.getMainLooper())
        handler.postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
            overridePendingTransition(android.R.anim.fade_in,0)
        },3000)



    }
}