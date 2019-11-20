package com.devahir.mastery.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devahir.mastery.data.network.login.LoginRepository
import com.devahir.mastery.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginViewModelFactory @Inject constructor(
    val loginRepository: LoginRepository,
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository,
                schedulerProvider,
                compositeDisposable
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}