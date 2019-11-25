package com.devahir.mastery.ui.component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import com.devahir.mastery.R
import com.google.android.material.textfield.TextInputEditText

class MasteryEditText : TextInputEditText {

    //The image we are going to use for the Clear button
    private val imgCloseButton = resources.getDrawable(R.drawable.ic_done)

    constructor(context: Context?) : super(context) {
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
    }

    /*internal fun init() { // Set bounds of the Clear button so it will look ok
        imgCloseButton.setBounds(
            0,
            0,
            imgCloseButton.intrinsicWidth,
            imgCloseButton.intrinsicHeight
        )
        // There may be initial text in the field, so we may need to display the  button
        handleClearButton()
        //if the Close image is displayed and the user remove his finger from the button, clear it. Otherwise do nothing
        setOnTouchListener(OnTouchListener { v, event ->
            val et = this@MasteryEditText
            if (et.compoundDrawables[2] == null) return@OnTouchListener false
            if (event.action != MotionEvent.ACTION_UP) return@OnTouchListener false
            if (event.x > et.width - et.paddingRight - imgCloseButton.intrinsicWidth) {
                et.setText("")
                handleClearButton()
            }
            false
        })
        //if text changes, take care of the button
        addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                handleClearButton()
            }

            override fun afterTextChanged(arg0: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        })
        val outValue = TypedValue()
        resources.getValue(R.dimen.letter_spacing, outValue, true)
        val letterSpacingValue = outValue.float
        letterSpacing = letterSpacingValue
        setLineSpacing(resources.getDimensionPixelSize(R.dimen.line_spacing).toFloat(), 1.0f)
    }

    //intercept Typeface change and set it with our custom font
    override fun setTypeface(tf: Typeface?, style: Int) {
        super.setTypeface(tf, style)
        *//*if (style == Typeface.BOLD) {
            super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Vegur-B 0.602.otf"));
        } else {
            super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Vegur-R 0.602.otf"));
        }*//*
    }

    internal fun handleClearButton() {
        if (this.text.toString() == "") { // add the clear button
            setCompoundDrawables(
                this.compoundDrawables[0],
                this.compoundDrawables[1],
                null,
                this.compoundDrawables[3]
            )
        } else { //remove clear button
            setCompoundDrawables(
                this.compoundDrawables[0],
                this.compoundDrawables[1],
                imgCloseButton,
                this.compoundDrawables[3]
            )
        }
    }*/
    init {
        val outValue = TypedValue()
        resources.getValue(R.dimen.letter_spacing, outValue, true)
        val letterSpacingValue = outValue.float
        letterSpacing = letterSpacingValue
        setLineSpacing(resources.getDimensionPixelSize(R.dimen.line_spacing).toFloat(), 1.0f)
    }
}

/* init {
     val outValue = TypedValue()
     resources.getValue(R.dimen.letter_spacing, outValue, true)
     val letterSpacingValue = outValue.float
     letterSpacing = letterSpacingValue
     setLineSpacing(resources.getDimensionPixelSize(R.dimen.line_spacing).toFloat(), 1.0f)
 }

 override fun onDraw(canvas: Canvas?) {
     super.onDraw(canvas)
 }

 override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
     super.onMeasure(widthMeasureSpec, heightMeasureSpec)
 }*/
//}