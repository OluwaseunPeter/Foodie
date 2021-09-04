package com.joseph.foodie.android.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.joseph.foodie.android.R
import com.joseph.foodie.android.databinding.FoodCardv2Binding

class FoodCardv2 @JvmOverloads constructor (context:Context, attrs: AttributeSet?  = null, defStyleAttr: Int = 0 ):
    ConstraintLayout(context ,attrs, defStyleAttr) {

        init {
            init(attrs)
        }
    private lateinit var binding:FoodCardv2Binding

    private fun init(attrs:AttributeSet?){
        binding = FoodCardv2Binding.inflate(LayoutInflater.from(context) , this)
    }

    fun getImageCard() : CardView {
        return binding.foodImage
    }
}