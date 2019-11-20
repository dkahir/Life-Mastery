package com.devahir.mastery.utils

fun String.isNotEmptyNotBlank(): Boolean = !isNullOrEmpty() && isNotBlank()