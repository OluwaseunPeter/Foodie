package com.joseph.foodie.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.transition.Transition
import com.joseph.foodie.android.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    lateinit var binding:ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewTransition()
    }

    override fun onBackPressed() {
        supportFinishAfterTransition()
    }

    private fun setupViewTransition(){
        val enter:Transition = Explode()
        enter.duration = 700
        enter.excludeTarget(android.R.id.statusBarBackground, true)
        enter.excludeTarget(android.R.id.navigationBarBackground, true)
        enter.excludeTarget(R.id.food_card , true)

        val fade:Transition = Fade()
        fade.duration = 700
        fade.addTarget(R.id.food_card)

        val transitionSet = TransitionSet()
        transitionSet.excludeTarget(android.R.id.statusBarBackground, true)
        transitionSet.excludeTarget(android.R.id.navigationBarBackground, true)

        transitionSet.addTransition(enter)
        transitionSet.addTransition(fade)

        window.enterTransition = transitionSet
    }
}