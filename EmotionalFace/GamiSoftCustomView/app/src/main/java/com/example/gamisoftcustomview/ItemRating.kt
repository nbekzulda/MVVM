package com.example.gamisoftcustomview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class ItemRating : ConstraintLayout {

    private lateinit var tvSectionName: TextView
    private lateinit var tvRatingValue: TextView
    private lateinit var ivForwardArrow: ImageView

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    fun getArrow(): ImageView {
        return ivForwardArrow
    }

    fun setSectionName(name: String): TextView {
        tvSectionName.text = name
        return tvSectionName
    }

    fun setRatingValue(rating: String): TextView {
        tvRatingValue.text = rating
        return tvRatingValue
    }

    private fun init(context: Context){
        LayoutInflater.from(context)
            .inflate(R.layout.item_rating, this)

        tvSectionName = findViewById(R.id.sectionName)
        tvRatingValue = findViewById(R.id.ratingValue)
        ivForwardArrow = findViewById(R.id.ivForward)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        init(context)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ItemRating)

        tvSectionName.apply {
            text = typedArray.getText(R.styleable.ItemRating_sectionName)
        }

        tvRatingValue.apply {
            text = typedArray.getText(R.styleable.ItemRating_ratingValue)
        }

        typedArray.recycle()
    }


}