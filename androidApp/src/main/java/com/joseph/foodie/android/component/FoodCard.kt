package com.joseph.foodie.android.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.joseph.foodie.android.R

class FoodCard @JvmOverloads constructor (context:Context , attrs: AttributeSet?  = null , defStyleAttr: Int = 0 ):
    CardView(context ,attrs, defStyleAttr) {

        init {
            init(attrs)
        }
    
    private fun init(attrs:AttributeSet?){
        View.inflate(context , R.layout.food_card , this)
    }
}