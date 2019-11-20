package com.devahir.mastery.ui.fonts

import android.content.Context
import android.graphics.Typeface

public object FontManager {
    public fun getTypeface(context: Context, typefaces: Typefaces): Typeface {
        return when (typefaces) {
            Typefaces.ROBOTO_REGULAR -> {
                Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
            }
            Typefaces.AZO_SANS_REGULAR -> {
                Typeface.createFromAsset(context.getAssets(), "fonts/Azo-Sans-Regular.ttf");
            }
        }
    }
}