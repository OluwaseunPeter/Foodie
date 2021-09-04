package com.joseph.foodie.android.component

import android.content.Context
import android.graphics.Rect
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.TouchDelegate
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import com.joseph.foodie.android.R
import com.joseph.foodie.android.databinding.FoodCardBinding
import com.joseph.foodie.android.extensions.dpToPixels

class FoodCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    CardView(context, attrs, defStyleAttr) {
    private lateinit var binding: FoodCardBinding

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        binding = FoodCardBinding.inflate(LayoutInflater.from(context), this)

        context.theme.obtainStyledAttributes(attrs, R.styleable.foodcard, 0, 0).apply {
            try {
                hideDetails(getBoolean(R.styleable.foodcard_hideDetails, false))
            } finally {
                recycle()
            }
        }

        val like = binding.like
        like.setOnClickListener {
            like.setBackgroundResource(R.drawable.heart)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                like.backgroundTintList = context.getColorStateList(R.color.colorAccent)
            }
        }
        val delegateArea = Rect()
        like.getHitRect(delegateArea)
        val increase = 44.dpToPixels(context).toInt()
        delegateArea.bottom += increase
        delegateArea.top += increase
        delegateArea.right += increase
        delegateArea.left += increase
        like.touchDelegate = TouchDelegate(delegateArea , like)
    }

    fun hideDetails(shouldHide:Boolean){
        if(shouldHide){
            binding.details.visibility = View.GONE
        }
    }

    fun getImageCard() : CardView {
        return binding.foodCard
    }
}