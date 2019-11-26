package com.devahir.mastery.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.devahir.mastery.R
import com.google.android.material.card.MaterialCardView

class QuestionCardView : MaterialCardView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.question_card_view, this, true)
    }

}