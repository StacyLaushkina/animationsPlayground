package com.laushkina.animationsplayground

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_drawable_animations.*

class DrawableAnimations : AppCompatActivity() {
    private lateinit var clockAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_drawable_animations)
        supportActionBar?.setTitle(R.string.drawable_animations)

        clock_animation.apply {
            setBackgroundResource(R.drawable.clock_animation)
            clockAnimation = background as AnimationDrawable
        }
        clock_animation.setOnClickListener {
            if (clockAnimation.isRunning) clockAnimation.stop() else clockAnimation.start()
        }
    }
    // TODO save instance - animation stops after rotation!
}