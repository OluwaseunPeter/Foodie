package com.joseph.foodie.android

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.joseph.foodie.android.component.FoodCard
import com.joseph.foodie.android.component.FoodCardv2
import com.joseph.foodie.android.component.FoodTag
import com.joseph.foodie.android.component.RecyclerAdapter
import com.joseph.foodie.android.component.utils.HorizontalBounceEdgeEffectFactory
import com.joseph.foodie.android.databinding.ActivityMainBinding
import com.joseph.foodie.android.extensions.dpToPixels


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupFoodTag()
        setupFoodCards()
        setupFoodRecommendation()
    }

    private fun setupFoodTag() {
        val foodTagList = listOf(
            "Juice Flavour",
            "Vanila Flavour",
            "Coochie Flavour",
            "Orange Flavour",
            "Mango flavour"
        )

        val recyclerView = binding.foodTags
        val foodTagAdapter = RecyclerAdapter(FoodTag::class.java) { foodTag, position ->
            val params: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            setMargins(params, position, foodTagList.size)
            foodTag.layoutParams = params
            foodTag.radius = 12.dpToPixels(this)

            foodTag.setText(foodTagList[position])
        }

        configureRecycler(recyclerView, foodTagAdapter)
        foodTagAdapter.swapItems(foodTagList)
    }

    private fun setupFoodCards() {
        val foodTagList = listOf(
            "Juice Flavour",
            "Vanila Flavour",
            "Coochie Flavour",
            "Orange Flavour",
            "Mango flavour"
        )

        val recyclerView = binding.foodCards
        val adapter = RecyclerAdapter(FoodCard::class.java) { foodCard, position ->
            val params: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(
                    200.dpToPixels(this).toInt(),
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
            setMargins(params, position, foodTagList.size)
            foodCard.layoutParams = params
            foodCard.radius = 24.dpToPixels(this)
            foodCard.setOnClickListener {
                val intent = Intent(this, DetailsActivity::class.java)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@MainActivity,
                    foodCard.getImageCard(),
                    "food_card"
                )
                startActivity(intent, options.toBundle())
            }
        }
        configureRecycler(recyclerView, adapter)

        adapter.swapItems(foodTagList)
    }

    private fun setupFoodRecommendation() {
        val foodTagList = listOf(
            "Juice Flavour",
            "Vanila Flavour",
            "Coochie Flavour",
            "Orange Flavour",
            "Mango flavour"
        )

        val recyclerView = binding.foodRecommendation
        val adapter = RecyclerAdapter(FoodCardv2::class.java) { foodCard, position ->
            val params =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
            setMargins(params, position, foodTagList.size)
            foodCard.layoutParams = params
            foodCard.setOnClickListener {
                val intent = Intent(this, DetailsActivity::class.java)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@MainActivity,
                    foodCard.getImageCard(),
                    "food_card"
                )
                startActivity(intent, options.toBundle())
            }
        }

        configureRecycler(recyclerView, adapter)

        adapter.swapItems(foodTagList)
    }

    private fun configureRecycler(
        recyclerView: RecyclerView,
        recyclerAdapter: RecyclerView.Adapter<*>
    ) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = recyclerAdapter
            itemAnimator = DefaultItemAnimator()
            edgeEffectFactory = HorizontalBounceEdgeEffectFactory()
        }
    }

    private fun setMargins(params: LinearLayout.LayoutParams, position: Int, size: Int) {
        val four = 4.dpToPixels(this).toInt()
        val eight = 8.dpToPixels(this).toInt()
        val twentyFour = 24.dpToPixels(this).toInt()

        var left = eight
        var right = eight
        if (position == 0) {
            left = twentyFour
        } else if (position == (size - 1)) {
            right = twentyFour
        }

        params.setMargins(left, four, right, four)
    }
}
