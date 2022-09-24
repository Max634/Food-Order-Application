package com.example.maksim_botukh_cpt_188_a80s_final_exam

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}