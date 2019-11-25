package com.devahir.mastery.ui.component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import com.devahir.mastery.R
import com.google.android.material.textview.MaterialTextView

class MasteryTextView : MaterialTextView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        val outValue = TypedValue()
        resources.getValue(R.dimen.letter_spacing, outValue, true)
        val letterSpacingValue = outValue.float
        letterSpacing = letterSpacingValue
        setLineSpacing(resources.getDimensionPixelSize(R.dimen.line_spacing).toFloat(), 1.0f)
    }

}