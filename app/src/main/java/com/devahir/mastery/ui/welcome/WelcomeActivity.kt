package com.devahir.mastery.ui.welcome

import android.os.Bundle
import android.os.Handler
import com.devahir.mastery.R
import com.devahir.mastery.ui.base.BaseActivity
import com.devahir.mastery.ui.factory.IntentFactory

class WelcomeActivity : BaseActivity() {
    override fun setUp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        // var welcomeTextView = findViewById<TextView>(R.id.welcome_text_view)
        //welcomeTextView.typeface = FontManager.getTypeface(this, Typefaces.ROBOTO_REGULAR)

        val handler = Handler();
        handler.postDelayed({
            val intent = IntentFactory.getCallingIntent(this, IntentFactory.IntentType.DASHBOARD)
            startActivity(intent)
            finish()
        }, 1000)
    }
}

