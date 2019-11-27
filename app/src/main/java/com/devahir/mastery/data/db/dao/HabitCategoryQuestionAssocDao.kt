package com.devahir.mastery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.devahir.mastery.data.db.model.HabitCategoryQuestionAssoc

@Dao
interface HabitCategoryQuestionAssocDao : BaseDao<HabitCategoryQuestionAssoc> {
    @Query("Select * from HabitCategoryQuestionAssoc")
    fun getAll(): List<HabitCategoryQuestionAssoc>

    @Query("Select * from HabitCategoryQuestionAssoc where id IN (:id)")
    fun getQuestionByCategory(id: String): HabitCategoryQuestionAssoc

}