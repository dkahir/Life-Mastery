package com.devahir.mastery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.devahir.mastery.data.db.model.HabitCategory

@Dao
interface HabitCategoryDao : BaseDao<HabitCategory> {
    @Query("Select * from HabitCategory")
    fun getAll(): List<HabitCategory>

    @Query("Select * from HabitCategory where id IN (:id)")
    fun getAnswerById(id: String): HabitCategory

}