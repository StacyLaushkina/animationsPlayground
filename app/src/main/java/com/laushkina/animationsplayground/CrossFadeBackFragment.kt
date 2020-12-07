package com.laushkina.animationsplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_front_crossfade_animations.*

class CrossFadeBackFragment: Fragment() {
    private var shortAnimationDuration: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_back_crossfade_animations, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hidden_human.visibility = View.GONE
        shortAnimationDuration = resources.getInteger(android.R.integer.config_longAnimTime)

        open_me_text.setOnClickListener { crossFade(open_me_text, hidden_human) }
        hidden_human.setOnClickListener { crossFade(hidden_human, open_me_text) }

    }

    private fun crossFade(from: View, to: View) {
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