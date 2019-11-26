package com.devahir.mastery.ui.component

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.devahir.mastery.R
import kotlinx.android.synthetic.main.question_view.view.*

class QuestionView : ConstraintLayout {
    var maxCharLength = 256

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.question_view, this, true)
        setTextChangeListener()
    }

    fun setQuestion(question: String) {
        question_title_text_view.text = question
    }

    fun setAnswerHint(hint: String) {
        answer_edit_text.hint = hint
    }

    fun setQuestionMaxLine(lines: Int) {
        answer_edit_text.setLines(lines)
    }

    fun getAnswerText(): String {
        return answer_edit_text.text.toString()
    }

    fun setFunnyTextt(funnytext: String) {
        funny_comment_text_view.apply {
            visibility = View.VISIBLE
            text = funnytext
        }
    }

    private fun setTextChangeListener() {
        answer_edit_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                answer_status_text_view.text = "Saved"
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                answer_status_text_view.text = "Saved"
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count > maxCharLength) {
                    answer_text_input_layout.error = "Answer should not exceeeds $maxCharLength"
                }
                answer_status_text_view.text = "typing"
            }
        })

    }
}