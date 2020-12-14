package com.laushkina.animationsplayground

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.view.animation.Animation
import android.view.animation.PathInterpolator

class ChangingSizeCutomView(context: Context): View(context) {
    private var valueAnimator: ValueAnimator? = null
    private var isAnimationInProcess = false

    private val width = 200f
    private val height = 200f
    private var radius = 30f

    private val paint = Paint().apply {
        color = Color.CYAN
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(width, height, radius, paint)

        animateNavigationBarColor()
    }

    private fun animateNavigationBarColor() {
        if (isAnimationInProcess) return
        isAnimationInProcess = true

        val time = 5_000
        valueAnimator = ValueAnimator
            .ofFloat(30f, 70f, 110f, 150f, 110f, 70f, 30f)
            .setDuration(time.toLong()).apply {
                interpolator = PathInterpolator(0.42f, 0f, 1f, 1f)
                addUpdateListener {
                        animation -> radius = animation.animatedValue as Float; invalidate()
                }
                repeatCount = Animation.INFINITE
                start()
            }
    }
}