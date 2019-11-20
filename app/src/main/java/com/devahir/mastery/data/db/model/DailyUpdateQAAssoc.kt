package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class DailyUpdateQAAssoc(
    @PrimaryKey(autoGenerate = true) val updateQAAssocId: Int,
    val updateId: Int,
    val qaAssocId: Int

)