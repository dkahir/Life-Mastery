package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Answer (
    @PrimaryKey(autoGenerate = true) val answerId: Int,
    val answer: String
)