package com.mdselim.unshakenfaith

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    // List of reminders (static content as per the site)
    private val reminders = listOf(
        "Patience is key in every trial, and the reward for patience is beyond measure. Trust in Allah’s plan.",
        "Even when things seem impossible, remember that Allah has a plan for you. Keep faith, and keep striving.",
        "The struggle is part of the journey. Trust in Allah’s mercy.",
        "Every hardship is a test. Use it to grow closer to Allah.",
        "Maximus never gave up in battle, and we must never give up in our fight for faith and justice.",
        "In times of hardship, remember that Allah is closer to you than you think. Keep calling upon Him.",
        "With every difficulty comes ease. Trust in Allah’s timing.",
        "The strength of a believer lies in their trust in Allah’s wisdom and mercy.",
        "Your struggle today is the foundation of your victory tomorrow. Never give up.",
        "Even when you feel weak, know that Allah is with you, providing strength when you need it most.",
        "Do not let fear stop you. Place your trust in Allah, and He will guide you through every trial.",
        "Sabr (patience) is not just waiting. It is trusting Allah’s plan and enduring with a grateful heart.",
        "No matter how dark the path, remember that Allah’s light will guide you through it.",
        "Faith is believing in the unseen, and trust in Allah is the foundation of that belief.",
        "Every step you take in patience and faith is a step toward Allah’s reward."
    )

    private lateinit var reminderViewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the views
        val newReminderButton = findViewById<Button>(R.id.new_reminder_button)
        val loadingSpinner = findViewById<ProgressBar>(R.id.loading_spinner)
        val reminderText = findViewById<TextView>(R.id.reminder_text)

        // Set up the ViewPager2 for swipeable reminders
        reminderViewPager = findViewById(R.id.reminder_viewpager)
        reminderViewPager.adapter = ReminderAdapter(this, reminders)

        // Set up the "Get a New Reminder" button click listener
        newReminderButton.setOnClickListener {
            // Start button fade-out animation
            ObjectAnimator.ofFloat(newReminderButton, "alpha", 1f, 0f).apply {
                duration = 300
                start()
            }

            newReminderButton.text = "⏳ Loading..."
            newReminderButton.isEnabled = false
            loadingSpinner.visibility = View.VISIBLE

            // Simulate a short delay to mimic the loading
            newReminderButton.postDelayed({
                val randomPosition = (0 until reminders.size).random()
                reminderViewPager.currentItem = randomPosition

                // Fade-in reminder text with animation
                ObjectAnimator.ofFloat(reminderText, "alpha", 0f, 1f).apply {
                    duration = 500
                    start()
                }

                // Fade-in button and update its text
                ObjectAnimator.ofFloat(newReminderButton, "alpha", 0f, 1f).apply {
                    duration = 300
                    start()
                }
                newReminderButton.text = "Get a New Reminder"
                newReminderButton.isEnabled = true
                loadingSpinner.visibility = View.GONE
            }, 1000)
        }

        // Optionally: Display a welcome toast
        Toast.makeText(this, getString(R.string.welcome_message), Toast.LENGTH_LONG).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val currentReminder = reminders[reminderViewPager.currentItem]
        outState.putString("REMINDER_KEY", currentReminder)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedReminder = savedInstanceState.getString("REMINDER_KEY")
        val position = reminders.indexOf(savedReminder)
        if (position != -1) {
            reminderViewPager.setCurrentItem(position, false)
        }
    }
}
