package com.laushkina.animationsplayground

import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.PathInterpolator
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_value_animations.*


class ValueAnimatorActivity: AppCompatActivity()  {
    private var valueAnimator: ValueAnimator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_value_animations)
        supportActionBar?.setTitle(R.string.value_animations)
    }

    override fun onStart() {
        super.onStart()
        animateNavigationBarColor()
    }

    private fun animateNavigationBarColor() {
        valueAnimator?.cancel()

        val time = 5_000
        valueAnimator = ValueAnimator
            .ofArgb(Color.BLUE, Color.RED, Color.BLUE)
            .setDuration(time.toLong()).apply {
                interpolator = PathInterpolator(0.42f, 0f, 1f, 1f)
                addUpdateListener {
                        animation -> value_animation.setBackgroundColor(animation.animatedValue as Int)
                }
                repeatCount = Animation.INFINITE
                start()
            }
    }
}