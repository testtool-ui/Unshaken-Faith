package com.mdselim.unshakenfaith

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ReminderFragment : Fragment(R.layout.fragment_reminder) {

    companion object {
        private const val ARG_REMINDER_TEXT = "reminder_text"

        // Factory method to create a new instance of the fragment
        fun newInstance(reminderText: String): ReminderFragment {
            val fragment = ReminderFragment()
            val args = Bundle().apply {
                putString(ARG_REMINDER_TEXT, reminderText)  // Passing the reminder text as an argument
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the reminder text from arguments and display it
        val reminderText = arguments?.getString(ARG_REMINDER_TEXT) ?: ""
        val textView = view.findViewById<TextView>(R.id.reminder_text)
        textView.text = reminderText
    }
}