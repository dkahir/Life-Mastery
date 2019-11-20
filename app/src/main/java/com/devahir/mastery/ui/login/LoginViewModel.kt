package com.devahir.mastery.ui.login

import androidx.lifecycle.MutableLiveData
import com.devahir.mastery.R
import com.devahir.mastery.data.network.login.LoginRepository
import com.devahir.mastery.ui.base.BaseViewModel
import com.devahir.mastery.utils.Screen
import com.devahir.mastery.utils.isNotEmptyNotBlank
import com.devahir.mastery.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class LoginViewModel(
    var loginRepository: LoginRepository,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BaseViewModel(schedulerProvider, compositeDisposable) {
    var invalidUsername = MutableLiveData<Int>()
    var invalidPassword = MutableLiveData<Int>()
    var invalidCredentials = MutableLiveData<Int>()

    fun isValidUser(username: String, password: String, rememberMe: Boolean) {
        if (username.isNotEmptyNotBlank() && password.isNotEmptyNotBlank()) {
            showLoading.value = true
            compositeDisposable.add(
                loginRepository.isValidUser(username, password, rememberMe)
                    .subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())
                    .subscribe({ response ->
                        showLoading.value = false
                        nextScreen.value = Screen.LIVE_TRACK
                    }, { error ->

                        showLoading.value = false

                        // handle the login error here

                        handleApiError(error)
                        invalidCredentials.value = R.string.invalid_credentials
                    })
            )

            //

        } else {
            if (!username.isNotEmptyNotBlank()) {
                invalidUsername.value = R.string.invalid_username
            } else {
                invalidPassword.value = R.string.invalid_password
            }
        }
    }
}