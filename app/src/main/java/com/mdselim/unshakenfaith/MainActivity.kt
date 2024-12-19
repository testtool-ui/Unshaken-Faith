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

    // Add the ViewPager2 adapter
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
        
        // Set the adapter for ViewPager2 with the list of reminders
        reminderViewPager.adapter = ReminderAdapter(this, reminders)

        // Set up the "Get a New Reminder" button click listener
        newReminderButton.setOnClickListener {
            // Start button fade-out animation
            ObjectAnimator.ofFloat(newReminderButton, "alpha", 1f, 0f).apply {
                duration = 300
                start()
            }

            newReminderButton.text = "⏳ Loading..." // Change the button text to show loading
            newReminderButton.isEnabled = false // Disable the button so it can't be clicked while loading
            loadingSpinner.visibility = View.VISIBLE // Show the loading spinner

            // Simulate a short delay of 1 second to mimic the loading
            newReminderButton.postDelayed({
                val randomPosition = (0 until reminders.size).random() // Get a random position in the list
                reminderViewPager.currentItem = randomPosition // Set the new reminder on ViewPager2

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
                newReminderButton.text = "Get a New Reminder" // Restore the original button text
                newReminderButton.isEnabled = true // Enable the button again
                loadingSpinner.visibility = View.GONE // Hide the loading spinner once the reminder is loaded
            }, 1000) // 1 second delay
        }

        // Reflect Button to Scroll to Reminder Section
        val reflectButton = findViewById<Button>(R.id.reflect_button)
        reflectButton.setOnClickListener {
            // Scroll to the current reminder in the ViewPager2
            reminderViewPager.post {
                reminderViewPager.setCurrentItem(reminderViewPager.currentItem, true)
            }
        }

        // Optionally: Display a welcome toast
        Toast.makeText(this, getString(R.string.welcome_message), Toast.LENGTH_LONG).show()

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Save the current reminder text (if needed)
        val currentReminder = reminders[reminderViewPager.currentItem]
        outState.putString("REMINDER_KEY", currentReminder)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore the saved reminder (if needed)
        val savedReminder = savedInstanceState.getString("REMINDER_KEY")
        val position = reminders.indexOf(savedReminder)
        if (position != -1) {
            reminderViewPager.setCurrentItem(position, false)
        }
    }
}