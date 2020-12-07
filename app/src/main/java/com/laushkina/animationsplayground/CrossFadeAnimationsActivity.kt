package com.laushkina.animationsplayground

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_crossfade_animations.*

class CrossFadeAnimationsActivity : AppCompatActivity() {
    private var shortAnimationDuration: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crossfade_animations)

        hidden_human.visibility = View.GONE
        shortAnimationDuration = resources.getInteger(android.R.integer.config_longAnimTime)

        open_me_text.setOnClickListener { crossfade(open_me_text, hidden_human) }
        hidden_human.setOnClickListener { crossfade(hidden_human, open_me_text) }
    }

    private fun crossfade(from: View, to: View) {
        to.apply {
            // Transparent at first
            alpha = 0f
            // But visible during animation
            visibility = View.VISIBLE

            animate()
                .alpha(1f)
                .duration = shortAnimationDuration.toLong()
        }

        from.apply {
            animate()
                .alpha(0f)
                .duration = shortAnimationDuration.toLong()

        }
    }
}