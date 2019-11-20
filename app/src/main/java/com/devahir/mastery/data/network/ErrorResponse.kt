package com.devahir.mastery.data.network

import com.google.gson.annotations.SerializedName


class ErrorResponse : Exception() {

    @SerializedName("status_code")
    var errorCode: Int = 0
    @field:SerializedName("status_code")
    var statusCode: String? = null
    @field:SerializedName("data")
    var data: Any? = null


    override fun equals(`object`: Any?): Boolean {
        if (this === `object`) return true
        if (`object` == null || javaClass != `object`.javaClass) return false

        val apiError = `object` as ErrorResponse?

        if (errorCode != apiError!!.errorCode) return false
        if (if (statusCode != null)
                statusCode != apiError.statusCode
            else
                apiError.statusCode != null
        )
            return false
        return if (data != null) data == apiError.data else apiError.data == null

    }

    override fun hashCode(): Int {
        var result = errorCode
        result = 31 * result + if (statusCode != null) statusCode!!.hashCode() else 0
        result = 31 * result + if (data != null) data!!.hashCode() else 0
        return result
    }

}