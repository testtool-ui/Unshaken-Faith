package com.mdselim.unshakenfaith

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // Correct signature
        super.onCreate(savedInstanceState) // Correct invocation
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
