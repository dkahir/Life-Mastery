package com.devahir.mastery.data.network.login

import com.devahir.mastery.data.db.model.User
import io.reactivex.Observable

interface LoginRepository {

    fun isValidUser(username: String, password: String, rememberMe: Boolean): Observable<List<User>>

    fun logoutUser()

}