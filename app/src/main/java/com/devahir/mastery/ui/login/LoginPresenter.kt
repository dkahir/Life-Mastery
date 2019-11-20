package com.devahir.mastery.ui.login

import com.devahir.mastery.data.network.login.LoginRepository
import com.devahir.mastery.ui.base.BasePresenter
import javax.inject.Inject

class LoginPresenter<loginView : LoginContract.View> @Inject constructor(val loginRepository: LoginRepository) :
    BasePresenter<loginView>(), LoginContract.Presenter<loginView> {

    override fun isValidUser(username: String, password: String, rememberMe: Boolean) {}
}