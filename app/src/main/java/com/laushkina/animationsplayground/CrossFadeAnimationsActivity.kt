package com.laushkina.animationsplayground

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_crossfade_animations.*

class CrossFadeAnimationsActivity : FragmentActivity() {
    private var showingBack = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crossfade_animations)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, CrossFadeFrontFragment())
                .commit()
        }
        container.setOnClickListener {
            flipCard()
        }
    }

    private fun flipCard() {
        val fragment: Fragment
        if (showingBack) {
            fragment = CrossFadeBackFragment() // TODO reuse fragments
            showingBack = false
        } else {
            fragment = CrossFadeFrontFragment()
            showingBack = true
        }

        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.animator.card_flip_right_in,
                R.animator.card_flip_right_out,
                R.animator.card_flip_left_in,
                R.animator.card_flip_left_out
            )
            .replace(R.id.container, fragment)
            .commit()
    }
}