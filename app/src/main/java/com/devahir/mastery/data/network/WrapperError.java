package com.devahir.mastery.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WrapperError extends RuntimeException {

    @Expose
    @SerializedName("status_code")
    private String statusCode;

    @Expose
    @SerializedName("message")
    private String message;

    public WrapperError(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }


    public WrapperError(String statusCode) {
        this.statusCode = statusCode;
    }


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
