package com.example.improvinghabits.utils

import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object Calculations {

    fun calculateTimeBetweenDates(startDate: String): String {

        //end date which will be the current time of system user
        val endDate = timeStampToString(System.currentTimeMillis())

        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
        val date1 = sdf.parse(startDate)
        val date2 = sdf.parse(endDate)

        var isNegative = false

        var difference: Long = date2.time - date1.time

        //when you enter a future date will be positive
        if (difference < 0) {
            difference = -(difference)
            isNegative = true
        }

        val minutes = difference / 60 / 1000
        val hours = difference / 60 / 1000 / 60
        val days = (difference / 60 / 1000 / 60) / 24
        val months = (difference / 60 / 1000 / 60) / 24 / (365 / 12)
        val years = difference / 60 / 1000 / 60 / 24 / 365

        //will tell if the user has started or will start a new habit
        if (isNegative) {
            return when {
                minutes < 240 -> "Starts in $minutes minutes"
                hours < 48 -> "Starts in $hours hours"
                days < 61 -> "Starts in $days days"
                months < 24 -> "Starts in $months months"
                else -> "Starts in $years years"
            }
        }

        return when {
            minutes < 240 -> "$minutes minutes ago"
            hours < 48 -> "$hours hours ago"
            days < 61 -> "$days days ago"
            months < 24 -> "$months months ago"
            else -> "$years years ago"
        }
    }

    //we'll get a timeStamp and return a date in String
    private fun timeStampToString(timeStamp: Long): String {
        val stamp = Timestamp(timeStamp)
        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
        val date = sdf.format((Date(stamp.time)))

        return date.toString()
    }

    //will receive from the date picker and will be formatted into a very clean format
    fun cleanDate(_day: Int, _month: Int, _year: Int): String {
        var day = _day.toString()
        var month = _month.toString()

        //will make sure that any day that is under 10 will have a 0 in front
        if (_day < 10) {
            day = "0$_day"
        }

        //the month starting with the index at zero, because that will use <9 and +1
        if (_month < 9) {
            month = "0${_month+1}"
        }
        return "$day/$month/$_year"
    }

    //will receive from the time picker and will be formatted into a very clean format
    fun cleanTime(_hour: Int, _minute: Int) : String {
        var hour = _hour.toString()
        var minute = _minute.toString()

        if (_hour < 10) {
            hour = "0$_hour"
        }

        if (_minute <10) {
            minute =  "0$_minute"
        }
        return "$hour:$minute"
    }
}