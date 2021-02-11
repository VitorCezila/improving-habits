package com.example.improvinghabits.ui.fragments.updatehabit

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.improvinghabits.R
import com.example.improvinghabits.data.models.Habit
import com.example.improvinghabits.ui.viewmodels.HabitViewModel
import com.example.improvinghabits.utils.Calculations
import kotlinx.android.synthetic.main.fragment_create_habit_item.*
import kotlinx.android.synthetic.main.fragment_update_habit_item.*
import java.util.*

class UpdateHabitItem : Fragment(R.layout.fragment_update_habit_item), TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

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
    private val args by navArgs<UpdateHabitItemArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        habitViewModel = ViewModelProvider(this).get(HabitViewModel::class.java)

        et_habitTitle_update.setText(args.selectedHabit.habit_title)
        et_habitDescription_update.setText(args.selectedHabit.habit_description)

        drawableSelected()

        pickDateAndTime()

        btn_confirm_update.setOnClickListener {
            updateHabit()
        }

        setHasOptionsMenu(true)

    }

    private fun updateHabit() {
        title = et_habitTitle_update.text.toString()
        description = et_habitDescription_update.text.toString()

        timeStamp = "$cleanDate $cleanTime"

        if(!(title.isEmpty() || description.isEmpty() || timeStamp.isEmpty() || drawableSelected == 0)){
            val habit =  Habit(args.selectedHabit.id, title, description, timeStamp, drawableSelected)

            habitViewModel.updateHabit(habit)
            Toast.makeText(context, "Habit updated successfully!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateHabitItem_to_habitList)
        } else {
            Toast.makeText(context, "Please fill all the fields!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun drawableSelected() {

        //art
        iv_artSelected_update.setOnClickListener {
            iv_artSelected_update.isSelected = !iv_artSelected_update.isSelected
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
        iv_dietSelected_update.setOnClickListener {
            iv_dietSelected_update.isSelected = !iv_dietSelected_update.isSelected
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
        iv_dogSelected_update.setOnClickListener {
            iv_dogSelected_update.isSelected = !iv_dogSelected_update.isSelected
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
        iv_messageSelected_update.setOnClickListener {
            iv_messageSelected_update.isSelected = !iv_messageSelected_update.isSelected
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
        iv_schoolSelected_update.setOnClickListener {
            iv_schoolSelected_update.isSelected = !iv_schoolSelected_update.isSelected
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
        iv_sleepSelected_update.setOnClickListener {
            iv_sleepSelected_update.isSelected = !iv_sleepSelected_update.isSelected
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
        iv_smokeSelected_update.setOnClickListener {
            iv_smokeSelected_update.isSelected = !iv_smokeSelected_update.isSelected
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
        iv_sportSelected_update.setOnClickListener {
            iv_sportSelected_update.isSelected = !iv_sportSelected_update.isSelected
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
        iv_stopSelected_update.setOnClickListener {
            iv_stopSelected_update.isSelected = !iv_stopSelected_update.isSelected
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
        iv_travelSelected_update.setOnClickListener {
            iv_travelSelected_update.isSelected = !iv_travelSelected_update.isSelected
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

        btn_pickDate_update.setOnClickListener {
            getDateCalendar()
            DatePickerDialog(requireContext(), this, year, month, day).show()
        }

        btn_pickTime_update.setOnClickListener {
            getTimeCalendar()
            TimePickerDialog(context, this, hour, minute, true).show()
        }
    }

    override fun onDateSet(view: DatePicker?, yearX: Int, monthX: Int, dayX: Int) {
        cleanDate = Calculations.cleanDate(dayX, monthX, yearX)
        tv_dateSelected_update.text = "Date: $cleanDate"
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        cleanTime = Calculations.cleanTime(hourOfDay, minute)
        tv_timeSelected_update.text = "Time: $cleanTime"
    }

    private fun getTimeCalendar() {
        val cal = Calendar.getInstance()
        hour = cal.get(Calendar.HOUR_OF_DAY)
        minute = cal.get(Calendar.MINUTE)
    }

    private fun getDateCalendar() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.single_item_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_delete -> deleteHabit(args.selectedHabit)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteHabit(habit: Habit) {
        habitViewModel.deleteHabit(habit)
        Toast.makeText(context, "Habit successfully deleted!", Toast.LENGTH_SHORT).show()

        findNavController().navigate(R.id.action_updateHabitItem_to_habitList)
    }

}