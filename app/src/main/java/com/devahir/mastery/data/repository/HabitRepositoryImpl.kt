package com.devahir.mastery.data.repository

import com.devahir.mastery.data.db.MasteryAppDatabase
import com.devahir.mastery.data.db.model.Habit
import com.devahir.mastery.data.prefs.PreferencesHelper
import io.reactivex.Maybe
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class HabitRepositoryImpl @Inject constructor(
    private val appDatabase: MasteryAppDatabase,
    private val preferencesHelper: PreferencesHelper,
    private val retrofit: Retrofit
) : HabitRepository {
    override fun getAllHabits(): Observable<List<Habit>> {
        return appDatabase.habitDao().getAll()
    }

    override fun addHabit(name: String, description: String): Maybe<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateHabit(habit: Habit): Maybe<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteHabit(habit: Habit): Maybe<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}