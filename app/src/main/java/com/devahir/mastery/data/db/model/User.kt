package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val uid: Int,
    val name: String?,
    @PrimaryKey val userName: String,
    val password: String?

)