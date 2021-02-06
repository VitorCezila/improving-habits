package com.example.improvinghabits.logic.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.improvinghabits.data.models.Habit

//is a data access object
@Dao
interface HabitDao {

    //functions that will tell the program what do with the database
    @Insert(onConflict = OnConflictStrategy.IGNORE) //if get something with same id it will just ignore
    suspend fun addHabit(habit: Habit)

    @Update
    suspend fun updateHabit(habit: Habit)

    @Delete
    suspend fun deleteHabit(habit: Habit)

    @Query ("SELECT * FROM habit_table ORDER BY id DESC")
    fun getAllHabits(): LiveData<List<Habit>>

    @Query ("DELETE FROM habit_table")
    suspend fun deleteAll()
}