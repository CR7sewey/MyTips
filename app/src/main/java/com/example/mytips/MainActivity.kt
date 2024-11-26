package com.example.mytips

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mainActivity = findViewById<View>(R.id.main)
        val finalValue = findViewById<TextView>(R.id.finalValue)
        val billTotal = findViewById<TextInputEditText>(R.id.price)
        val minus = findViewById<TextView>(R.id.minus)
        val plus = findViewById<TextView>(R.id.plus)
        val valueSplit = findViewById<TextView>(R.id.valueSplit)
        //var finalValuePreUpdate = 0.0

        mainActivity.setOnClickListener {
            val finalValuePreUpdateBD = calculateTotalPerPerson(billTotal, valueSplit)
            finalValue.text = "€ " + finalValuePreUpdateBD
        }
        billTotal.setOnClickListener {
            println(billTotal.id.compareTo(billTotal.id))
            println(billTotal.id.compareTo(minus.id))

            //finalValuePreUpdate = billTotal.text.toString().toDouble() / valueSplit.text.toString().toDouble()
            val finalValuePreUpdateBD = calculateTotalPerPerson(billTotal, valueSplit)
            finalValue.text = "€ " + finalValuePreUpdateBD
        }

        minus.setOnClickListener {
            if (valueSplit.text.toString().toInt() > 1) {
                valueSplit.text = (valueSplit.text.toString().toInt() - 1).toString()
                val finalValuePreUpdateBD = calculateTotalPerPerson(billTotal, valueSplit)
                finalValue.text = "€ " + finalValuePreUpdateBD
            }
        }
        plus.setOnClickListener {
            if (valueSplit.text.toString().toInt() < 20) {
                valueSplit.text = (valueSplit.text.toString().toInt() + 1).toString()
                val finalValuePreUpdateBD = calculateTotalPerPerson(billTotal, valueSplit)
                finalValue.text = "€ " + finalValuePreUpdateBD
            }
        }






    }

    private fun calculateTotalPerPerson(billTotal: TextInputEditText, valueSplit: TextView): String {
        val finalValuePreUpdate = billTotal.text.toString().toDouble() / valueSplit.text.toString().toDouble()
        val finalValuePreUpdateBD = (BigDecimal(finalValuePreUpdate).setScale(2, RoundingMode.HALF_EVEN)).toString()
        return finalValuePreUpdateBD

    }
}