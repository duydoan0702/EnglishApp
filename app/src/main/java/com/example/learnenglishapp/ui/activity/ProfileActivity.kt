package com.example.learnenglishapp.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.learnenglishapp.R

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_profile)


    }

    private fun setupProfileItem(view: View, iconResId: Int, title: String) {
        val icon = view.findViewById<ImageView>(R.id.ivIcon)
        val text = view.findViewById<TextView>(R.id.tvOptionTitle)

        icon.setImageResource(iconResId)
        text.text = title
    }
}