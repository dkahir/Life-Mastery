package com.devahir.mastery.data.db.dao

import androidx.room.*
import com.devahir.mastery.data.db.model.User
import io.reactivex.Observable

@Dao
interface UserDao {
    @Query("Select * from User")
    fun getAll(): Observable<List<User>>

    @Query("Select * from USER where userName IN (:userName)")
    fun getUserByUserName(userName: String): User

    @Query("select password from User where userName IN (:userName)")
    fun getPasswordByUsername(userName: String): String

    @Query("select * from User where userName IN (:userNameList)")
    fun getUsersByUsername(userNameList: List<String>): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg user: User)

    @Delete
    fun delete(user: User)
}