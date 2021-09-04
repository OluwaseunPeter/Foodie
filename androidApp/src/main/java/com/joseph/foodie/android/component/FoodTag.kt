package com.joseph.foodie.android.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.joseph.foodie.android.R
import com.joseph.foodie.android.databinding.FoodTagBinding

class FoodTag @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    CardView(context, attrs, defStyleAttr) {
    private lateinit var binding: FoodTagBinding

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        binding = FoodTagBinding.inflate(LayoutInflater.from(context), this)
    }

    fun setText(text:String){
        binding.title.setText(text)
    }
}