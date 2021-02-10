package com.example.improvinghabits.ui.fragments.createhabit

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.improvinghabits.R
import com.example.improvinghabits.data.models.Habit
import com.example.improvinghabits.ui.viewmodels.HabitViewModel
import com.example.improvinghabits.utils.Calculations
import kotlinx.android.synthetic.main.fragment_create_habit_item.*
import java.util.*


class CreateHabitItem : Fragment(R.layout.fragment_create_habit_item),
TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener{

    private var title = ""
    private var description = ""
    private var drawableSelected = 0
    private var timeStamp = ""

    private var day = 0
    private var month = 0
    private var year = 0
    private var hour = 0
    private var minute = 0

    private var cleanDate = ""
    private var cleanTime = ""

    private lateinit var habitViewModel: HabitViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        habitViewModel = ViewModelProvider(this).get(HabitViewModel::class.java)

        //inside here will add a function that will update the database with the current information selected from create habit screen
        btn_confirm.setOnClickListener {
            addHabitToDB()
        }

        pickDateAndTime()

        drawableSelected()
    }

    private fun addHabitToDB() {
        title = et_habitTitle.text.toString()
        description = et_habitDescription.text.toString()

        timeStamp = "$cleanDate $cleanTime"

        if(!(title.isEmpty() || description.isEmpty() || timeStamp.isEmpty() || drawableSelected == 0)){
            val habit = Habit(0, title, description, timeStamp, drawableSelected)

            habitViewModel.addHabit(habit)
            Toast.makeText(context, "Habit created successfully!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_createHabitItem_to_habitList)
        } else {
            Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_LONG).show()
        }

    }

    //Which category the user selected for the habit
    private fun drawableSelected() {

        //art
        iv_artSelected.setOnClickListener {
            iv_artSelected.isSelected = !iv_artSelected.isSelected
            drawableSelected = R.drawable.ic_art

            //ensures that the other categories are false
            iv_dietSelected.isSelected = false
            iv_dogSelected.isSelected = false
            iv_messageSelected.isSelected = false
            iv_schoolSelected.isSelected = false
            iv_sleepSelected.isSelected = false
            iv_smokeSelected.isSelected = false
            iv_sportSelected.isSelected = false
            iv_stopSelected.isSelected = false
            iv_travelSelected.isSelected = false
        }

        //diet
        iv_dietSelected.setOnClickListener {
            iv_dietSelected.isSelected = !iv_dietSelected.isSelected
            drawableSelected = R.drawable.ic_diet

            iv_artSelected.isSelected = false
            iv_dogSelected.isSelected = false
            iv_messageSelected.isSelected = false
            iv_schoolSelected.isSelected = false
            iv_sleepSelected.isSelected = false
            iv_smokeSelected.isSelected = false
            iv_sportSelected.isSelected = false
            iv_stopSelected.isSelected = false
            iv_travelSelected.isSelected = false
        }

        //dog
        iv_dogSelected.setOnClickListener {
            iv_dogSelected.isSelected = !iv_dogSelected.isSelected
            drawableSelected = R.drawable.ic_dog

            iv_artSelected.isSelected = false
            iv_dietSelected.isSelected = false
            iv_messageSelected.isSelected = false
            iv_schoolSelected.isSelected = false
            iv_sleepSelected.isSelected = false
            iv_smokeSelected.isSelected = false
            iv_sportSelected.isSelected = false
            iv_stopSelected.isSelected = false
            iv_travelSelected.isSelected = false
        }

        //message
        iv_messageSelected.setOnClickListener {
            iv_messageSelected.isSelected = !iv_messageSelected.isSelected
            drawableSelected = R.drawable.ic_message

            iv_artSelected.isSelected = false
            iv_dietSelected.isSelected = false
            iv_dogSelected.isSelected = false
            iv_schoolSelected.isSelected = false
            iv_sleepSelected.isSelected = false
            iv_smokeSelected.isSelected = false
            iv_sportSelected.isSelected = false
            iv_stopSelected.isSelected = false
            iv_travelSelected.isSelected = false
        }

        //school
        iv_schoolSelected.setOnClickListener {
            iv_schoolSelected.isSelected = !iv_schoolSelected.isSelected
            drawableSelected = R.drawable.ic_school

            iv_artSelected.isSelected = false
            iv_dietSelected.isSelected = false
            iv_dogSelected.isSelected = false
            iv_messageSelected.isSelected = false
            iv_sleepSelected.isSelected = false
            iv_smokeSelected.isSelected = false
            iv_sportSelected.isSelected = false
            iv_stopSelected.isSelected = false
            iv_travelSelected.isSelected = false
        }

        //sleep
        iv_sleepSelected.setOnClickListener {
            iv_sleepSelected.isSelected = !iv_sleepSelected.isSelected
            drawableSelected = R.drawable.ic_sleep

            iv_artSelected.isSelected = false
            iv_dietSelected.isSelected = false
            iv_dogSelected.isSelected = false
            iv_messageSelected.isSelected = false
            iv_schoolSelected.isSelected = false
            iv_smokeSelected.isSelected = false
            iv_sportSelected.isSelected = false
            iv_stopSelected.isSelected = false
            iv_travelSelected.isSelected = false
        }

        //smoke
        iv_smokeSelected.setOnClickListener {
            iv_smokeSelected.isSelected = !iv_smokeSelected.isSelected
            drawableSelected = R.drawable.ic_smoke

            iv_artSelected.isSelected = false
            iv_dietSelected.isSelected = false
            iv_dogSelected.isSelected = false
            iv_messageSelected.isSelected = false
            iv_schoolSelected.isSelected = false
            iv_sleepSelected.isSelected = false
            iv_sportSelected.isSelected = false
            iv_stopSelected.isSelected = false
            iv_travelSelected.isSelected = false
        }

        //sport
        iv_sportSelected.setOnClickListener {
            iv_sportSelected.isSelected = !iv_sportSelected.isSelected
            drawableSelected = R.drawable.ic_sports

            iv_artSelected.isSelected = false
            iv_dietSelected.isSelected = false
            iv_dogSelected.isSelected = false
            iv_messageSelected.isSelected = false
            iv_schoolSelected.isSelected = false
            iv_sleepSelected.isSelected = false
            iv_smokeSelected.isSelected = false
            iv_stopSelected.isSelected = false
            iv_travelSelected.isSelected = false
        }

        //stop
        iv_stopSelected.setOnClickListener {
            iv_stopSelected.isSelected = !iv_stopSelected.isSelected
            drawableSelected = R.drawable.ic_stop

            iv_artSelected.isSelected = false
            iv_dietSelected.isSelected = false
            iv_dogSelected.isSelected = false
            iv_messageSelected.isSelected = false
            iv_schoolSelected.isSelected = false
            iv_sleepSelected.isSelected = false
            iv_smokeSelected.isSelected = false
            iv_sportSelected.isSelected = false
            iv_travelSelected.isSelected = false
        }

        //travel
        iv_travelSelected.setOnClickListener {
            iv_travelSelected.isSelected = !iv_travelSelected.isSelected
            drawableSelected = R.drawable.ic_travel

            iv_artSelected.isSelected = false
            iv_dietSelected.isSelected = false
            iv_dogSelected.isSelected = false
            iv_messageSelected.isSelected = false
            iv_schoolSelected.isSelected = false
            iv_sleepSelected.isSelected = false
            iv_smokeSelected.isSelected = false
            iv_sportSelected.isSelected = false
            iv_stopSelected.isSelected = false
        }
    }


    private fun pickDateAndTime() {
        
        btn_pickDate.setOnClickListener {
            getDateCalendar()
            DatePickerDialog(requireContext(), this, year, month, day).show()
        }

        btn_pickTime.setOnClickListener {
            getTimeCalendar()
            TimePickerDialog(context, this, hour, minute, true).show()
        }
    }

    override fun onDateSet(view: DatePicker?, yearX: Int, monthX: Int, dayX: Int) {
        cleanDate = Calculations.cleanDate(dayX, monthX, yearX)
        tv_dateSelected.text = "Date: $cleanDate"
     }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        cleanTime = Calculations.cleanTime(hourOfDay, minute)
        tv_timeSelected.text = "Time: $cleanTime"
    }

    //this will return the most recent hour and minute when the user clicks on picktime
    private fun getTimeCalendar() {
        val cal = Calendar.getInstance()
        hour = cal.get(Calendar.HOUR_OF_DAY)
        minute = cal.get(Calendar.MINUTE)
    }

    //this will return the most recent date when the user clicks on pickdate
    private fun getDateCalendar() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
    }

}