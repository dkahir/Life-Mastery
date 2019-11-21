package com.devahir.mastery.data.repository

import com.devahir.mastery.data.db.model.Habit
import io.reactivex.Maybe
import io.reactivex.Observable

interface HabitRepository {
    fun getAllHabits(): Observable<List<Habit>>
    fun addHabit(name: String, description: String): Maybe<Long>
    fun updateHabit(habit: Habit): Maybe<Long>
    fun deleteHabit(habit: Habit): Maybe<Long>
}