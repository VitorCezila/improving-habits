package com.example.improvinghabits.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize //able to pass this an argument in our another fragment
@Entity(tableName = "habit_table") //table from database
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val habit_title: String,
    val habit_description: String,
    val habit_startTime: String,
    val imageId: Int
) : Parcelable