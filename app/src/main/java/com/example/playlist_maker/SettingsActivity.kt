package com.example.playlist_maker

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val backButton = findViewById<Button>(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }

        val switchCompat = findViewById<SwitchCompat>(R.id.dark_theme_switch )
        switchCompat.setOnCheckedChangeListener { _, isChecked -> switchCompat.thumbTintMode
            if (isChecked) {
                switchCompat.thumbTintList = getColorStateList(R.color.blue)
                switchCompat.trackTintList = getColorStateList(R.color.light_blue)
            } else {
                switchCompat.thumbTintList = getColorStateList(R.color.gray)
                switchCompat.trackTintList = getColorStateList(R.color.light_gray)
            }

            //there's gotta to be an easier way to do this, but i could only make it this way
        }
    }
}

