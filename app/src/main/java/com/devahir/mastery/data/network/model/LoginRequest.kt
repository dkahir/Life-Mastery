package com.devahir.mastery.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginRequest() {
    @Expose
    @SerializedName("username")
    public var username: String? = null

    @Expose
    @SerializedName("password")
    public var password: String? = null


}