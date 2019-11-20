package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(
    @PrimaryKey(autoGenerate = true) val quoteId: Int,
    val quote: String,
    val author: String,
    val isUserDefined: Boolean

)