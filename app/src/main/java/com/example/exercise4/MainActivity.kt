package com.example.exercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dob2.setOnClickListener(){
            val cal : Calendar = Calendar.getInstance()
            val getDate =cal.get(Calendar.DAY_OF_MONTH)
            val getMonth = cal.get(Calendar.MONTH)
            val getYear = cal.get(Calendar.YEAR)

            val picker = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener
                { view, year, month, day ->
                    dob2.setText(day.toString() + "/" + (month + 1).toString() + "/" + year.toString())

                    calculate.setOnClickListener(){

                        val decimalPoint = DecimalFormat("##.##")

                        val age = getYear - year
                        age2.setText(age.toString())
                        val basicSaving= calSaving(age2)
                        minSav2.setText("RM " + decimalPoint.format(basicSaving))
                        val investAmount = basicSaving * 30 / 100
                        investment2.setText("RM " + decimalPoint.format(investAmount))
                    }

                }, getYear, getMonth, getDate
            )
            picker.show()
        }

        resetBtn.setOnClickListener(){
            dob2.setText(R.string.input)
            age2.setText("")
            minSav2.setText("")
            investment2.setText("")
        }


        }
   /* fun calSaving():Int{
        return when(Integer.valueOf(age2.getText().toString())){
            in 16..20->5000
            in 21..25->14000
            in 26..30->29000
            in 31..35->50000
            in 36..40->78000
            in 41..45->116000
            in 46..50->165000
            in 51..55->228000
            else ->0
        }
    }*/

    fun calSaving(age2: TextView): Int {
            val calAge = (Integer.valueOf(age2.getText().toString()))
            if(calAge>=16&&calAge<=20){
                return 5000 }
            else if(calAge>=21 && calAge<=25){
                return 14000 }
            else if(calAge>=26 && calAge<=30) {
                return 29000 }
            else if(calAge>=31 && calAge<=35) {
                return 50000 }
            else if(calAge>=36 && calAge<=40) {
                return 78000 }
            else if(calAge>=41 && calAge<=45){
                return 116000}
            else if(calAge>=46 && calAge<=50){
                return 165000}
            else if(calAge>=51 && calAge<=55){
                return 228000}
            else return 0
        }
        }


