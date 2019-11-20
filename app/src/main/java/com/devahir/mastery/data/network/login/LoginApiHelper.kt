package com.devahir.mastery.data.network.login

import com.devahir.mastery.data.network.model.LoginRequest
import com.devahir.mastery.data.network.model.LoginResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiHelper {
    @POST("authentications/login")
    fun isValidUser(@Body loginRequest: LoginRequest) : Observable<LoginResponse>
    //LogoutUser()
}