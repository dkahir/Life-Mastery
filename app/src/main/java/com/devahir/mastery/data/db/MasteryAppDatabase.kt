package com.devahir.mastery.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.devahir.mastery.data.db.dao.*
import com.devahir.mastery.data.db.model.*

@Database(
    entities = [User::class, Habit::class, DailyUpdate::class, Reminder::class, HabitCategory::class,
        HabitCategoryQuestionAssoc::class, HabitQAAssoc::class,
        HabitReminderAssoc::class, DailyUpdateQAAssoc::class, QuestionAnswerAssoc::class, Question::class,
        Answer::class, Quote::class, Preference::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class MasteryAppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun habitDao(): HabitDao
    abstract fun habitCategoryDao(): HabitCategoryDao
    abstract fun dailyUpdateDao(): DailyUpdateDao
    abstract fun reminderDao(): ReminderDao
    abstract fun questionDao(): QuestionDao
    abstract fun answerDao(): AnswerDao
    abstract fun quoteDao(): QuoteDao
    abstract fun habitCategoryQuestionAssocDao(): HabitCategoryQuestionAssocDao

}