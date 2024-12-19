package com.mdselim.unshakenfaith

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Install splash screen
        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Proceed to MainActivity after initialization
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
