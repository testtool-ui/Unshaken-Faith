package com.mdselim.unshakenfaith

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ReminderAdapter(fragmentActivity: FragmentActivity, private val reminders: List<String>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = reminders.size

    override fun createFragment(position: Int): Fragment {
        // Create and return the ReminderFragment instance with the reminder text
        return ReminderFragment.newInstance(reminders[position])
    }
}