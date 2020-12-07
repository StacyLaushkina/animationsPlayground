package com.laushkina.animationsplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawable_animations.setOnClickListener {
            val intent = Intent(this, DrawableAnimationsActivity::class.java)
            startActivity(intent)
        }

        crossfade_animations.setOnClickListener {
            val intent = Intent(this, CrossFadeAnimationsActivity::class.java)
            startActivity(intent)
        }
    }
}