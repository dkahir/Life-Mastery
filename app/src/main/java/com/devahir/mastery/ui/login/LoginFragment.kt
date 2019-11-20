package com.devahir.mastery.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.devahir.mastery.R
import com.devahir.mastery.ui.base.BaseFragment
import com.devahir.mastery.ui.component.BottomSheetInfoDialog
import com.devahir.mastery.ui.factory.IntentFactory
import com.devahir.mastery.ui.fonts.FontManager
import com.devahir.mastery.ui.fonts.Typefaces
import com.devahir.mastery.utils.Screen
import javax.inject.Inject


class LoginFragment : BaseFragment(), View.OnClickListener {
    @Inject
    lateinit var loginViewModelFactory: LoginViewModelFactory
    private lateinit var usernameTextInputEditText: TextInputEditText
    private lateinit var usernameTextInputLayout: TextInputLayout
    private lateinit var passwordTextInputEditText: TextInputEditText
    private lateinit var passwordTextInputLayout: TextInputLayout
    private lateinit var loginButton: MaterialButton
    lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        // loginPresenter.onAttach(this)
        bundle.let { }

        loginViewModel =
            ViewModelProviders.of(this, loginViewModelFactory)[LoginViewModel::class.java]
        registerViewModelObserver()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentParenView = inflater.inflate(R.layout.fragment_login, container, false)
        setUp(fragmentParenView)
        return fragmentParenView
    }


    override fun onClick(view: View) {
        when (view.id) {
            R.id.login_button -> {
                loginButtonClick()
            }
        }
    }

    override fun setUp(fragmentParenView: View) {
        activity?.let {
            usernameTextInputEditText =
                fragmentParenView.findViewById(R.id.username_textInputEditText)
            usernameTextInputEditText.typeface =
                FontManager.getTypeface(activity!!, Typefaces.ROBOTO_REGULAR)

            usernameTextInputLayout = fragmentParenView.findViewById(R.id.username_textInputLayout)
            usernameTextInputLayout.typeface =
                FontManager.getTypeface(activity!!, Typefaces.ROBOTO_REGULAR)

            passwordTextInputEditText =
                fragmentParenView.findViewById(R.id.password_textInputEditText)
            passwordTextInputEditText.typeface =
                FontManager.getTypeface(activity!!, Typefaces.ROBOTO_REGULAR)

            passwordTextInputLayout = fragmentParenView.findViewById(R.id.password_textInputLayout)
            passwordTextInputLayout.typeface =
                FontManager.getTypeface(activity!!, Typefaces.ROBOTO_REGULAR)

            loginButton = fragmentParenView.findViewById(R.id.login_button)
            loginButton.typeface = FontManager.getTypeface(activity!!, Typefaces.ROBOTO_REGULAR)

            loginButton.setOnClickListener(this)

            usernameTextInputEditText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                    if (!p0.isNullOrEmpty()) {
                        usernameTextInputLayout.isErrorEnabled = false
                    }
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            })
            passwordTextInputEditText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                    if (!p0.isNullOrEmpty()) {
                        passwordTextInputLayout.isErrorEnabled = false
                    }
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            })
        }
    }


    private fun loginButtonClick() {
        loginViewModel.isValidUser(
            username = usernameTextInputEditText.text.toString(),
            password = passwordTextInputEditText.text.toString(),
            rememberMe = false
        )
    }

    override fun registerViewModelObserver() {
        loginViewModel.invalidUsername.observe(this, Observer<Int> { message ->
            /* usernameTextInputLayout.error = getString(message)*/
            usernameTextInputLayout.error = getString(message)
        })
        loginViewModel.invalidPassword.observe(this, Observer<Int> { message ->
            passwordTextInputLayout.error = getString(message)
        })
        loginViewModel.invalidCredentials.observe(this, Observer<Int> { message ->
            val dialog = BottomSheetInfoDialog()
            dialog.show(childFragmentManager, "")
        })
        loginViewModel.nextScreen.observe(this, Observer<Screen> { nextScreen ->
            when (nextScreen) {
                Screen.LIVE_TRACK -> {
                    startActivity(
                        IntentFactory.getCallingIntent(
                            activity!!,
                            IntentFactory.IntentType.LIVE_TRACK
                        )
                    )
                }
                else -> {

                }
            }
        })
    }
}
