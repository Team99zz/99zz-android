package com.team.ggzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        runSplashTimer()
    }
    private fun runSplashTimer() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                startMainActivity()
            }
        }, 1500)
    }
    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}