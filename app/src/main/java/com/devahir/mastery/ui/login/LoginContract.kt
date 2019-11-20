package com.devahir.mastery.ui.login

import com.devahir.mastery.ui.base.MvpPresenter
import com.devahir.mastery.ui.base.MvpView

interface LoginContract {
    interface View : MvpView {
        fun showNextScreen()

        fun showInvalidCredentials(message: Int)

        fun showInvalidUsername(message: Int)

        fun showInvalidPassword(message: Int)

    }

    interface Presenter<mvpView : View> : MvpPresenter<mvpView> {

        fun isValidUser(username: String, password: String, rememberMe: Boolean)

    }
}