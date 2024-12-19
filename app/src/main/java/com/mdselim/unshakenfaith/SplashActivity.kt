package com.mdselim.unshakenfaith

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Delay for 0.5 seconds before transitioning to the MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
    val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
    finish() // Close SplashActivity
    }, 500) // 500ms = 0.5 seconds
    }
}
