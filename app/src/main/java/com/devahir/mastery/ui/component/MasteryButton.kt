package com.devahir.mastery.ui.component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import com.devahir.mastery.R
import com.google.android.material.button.MaterialButton

class MasteryButton : MaterialButton {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

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