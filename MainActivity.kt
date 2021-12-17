package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ageButton.setOnClickListener {view ->
            clickDatePicker(view)
        }

    }

    fun clickDatePicker(view: View) {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,DatePickerDialog.OnDateSetListener {

                view, selectedYear, selectedMonth, selectedDay ->
            Toast.makeText(this," The chosen day is " + selectedDay + "/" +  selectedMonth + "/" + selectedYear,

                Toast.LENGTH_LONG).show()

            val selectedDate = " Selected Date - "+ "$selectedDay/$selectedMonth/$selectedYear"

            val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)

            tvselectedDate.setText(selectedDate)


        }
            , year, month, day).show()



    }
}