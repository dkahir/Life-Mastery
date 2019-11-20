package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Preference(
    @PrimaryKey(autoGenerate = true) val preferenceId: Int,
    val name: String

)