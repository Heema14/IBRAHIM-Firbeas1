package com.ps.firebasetest

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.DealDirect.App.R
import java.util.*

class registerActivity : AppCompatActivity() {

    private lateinit var addDateBtn: Button
    private lateinit var confirmDia: TextView
    private lateinit var CancelDia: TextView
    private lateinit var datePicker: DatePicker
    private lateinit var tvDate: TextView


    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.datepicker_custom, null)

        addDateBtn = findViewById(R.id.Add_BD_btn)
        tvDate = findViewById(R.id.tvDate)
        //

        //يجب وضع متغير view لكل العناصر خارج الاكتيفيتي

        confirmDia = view.findViewById(R.id.AddTxtDia)
        CancelDia = view.findViewById(R.id.CancelTxtDia)
        datePicker = view.findViewById(R.id.date_Picker)

            showDateDialog()



//        confirmDia.setOnClickListener {
//            Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
//            tvDate.text = saveDate()
//            exitDia()
//        }
//        CancelDia.setOnClickListener {
//            exitDia()
//        }
    }


    fun showDateDialog() {

        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.datepicker_custom, null)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        val dialog = builder.create()

        addDateBtn.setOnClickListener {

            dialog.show()
        }
        CancelDia.setOnClickListener {
            dialog.dismiss()
        }

    }

    fun saveDate(): String {
        lateinit var date: String
        val today = Calendar.getInstance()
        datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month = month + 1
            date = "You Selected: $day/$month/$year"
        }
        return date

    }
}