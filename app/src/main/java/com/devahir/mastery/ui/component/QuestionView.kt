package com.devahir.mastery.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.devahir.mastery.R
import com.google.android.material.textfield.TextInputLayout

class QuestionView : ConstraintLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {

    }

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.question_view, this, true)
        //addView(view)
       // hint = ""
    }

    public fun setQuestionHint(hint: String) {
        //editText?.hint = hint
    }

    public fun setQuestion(question: String) {
        //editText?.setText(question)
    }

    public fun setQuestionMaxLine(lines: Int) {
        // editText?.maxLines = lines
    }
}