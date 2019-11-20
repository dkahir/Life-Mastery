package com.devahir.mastery.data.network.login

import com.devahir.mastery.data.db.MasteryAppDatabase
import com.devahir.mastery.data.db.model.User
import com.devahir.mastery.data.network.model.LoginRequest
import com.devahir.mastery.data.prefs.PreferencesHelper
import com.devahir.mastery.ui.base.BaseRepository
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val appDatabase: MasteryAppDatabase,
    private val preferencesHelper: PreferencesHelper,
    private val retrofit: Retrofit
) : BaseRepository(),
    LoginRepository {
    override fun isValidUser(
        username: String,
        password: String,
        rememberMe: Boolean
    ): Observable<List<User>> {
        return appDatabase.userDao().getAll()
        /*val loginApiHelper = retrofit.create(LoginApiHelper::class.java)
        return loginApiHelper.isValidUser(getLoginRequest(username, password, rememberMe))*/

    }

    override fun logoutUser() {

    }

    private fun getLoginRequest(
        username: String,
        password: String,
        rememberMe: Boolean
    ): LoginRequest {
        return LoginRequest().apply {
            this.username = username
            this.password = password
        }
    }
}