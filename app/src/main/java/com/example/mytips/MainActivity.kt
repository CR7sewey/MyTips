package com.example.mytips

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
        val tip = findViewById<View>(R.id.tip)
        val tip0 = findViewById<View>(R.id.tip11)
        val tip10 = findViewById<View>(R.id.tip12)
        val tip20 = findViewById<View>(R.id.tip13)
        val tip25 = findViewById<View>(R.id.tip21)
        val tip30 = findViewById<View>(R.id.tip22)
        val billEnd = findViewById<TextView>(R.id.billFinal)
        val tipEnd = findViewById<TextView>(R.id.tipFinal)
        var tipFinal: Double = 0.0

        //var finalValuePreUpdate = 0.0



        billTotal.setOnClickListener {
            //println(billTotal.id.compareTo(billTotal.id))
            //println(billTotal.id.compareTo(minus.id))

            //finalValuePreUpdate = billTotal.text.toString().toDouble() / valueSplit.text.toString().toDouble()
            val finalValuePreUpdateBD = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[2]
            val tipShown = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[0]
            val finalValuePreUpdate = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[1]
            finalValue.text = "€ $finalValuePreUpdateBD"
            tipEnd.text = "€$tipShown"
            billEnd.text = "€$finalValuePreUpdate"
        }

        minus.setOnClickListener {
            if (valueSplit.text.toString().toInt() > 1) {
                valueSplit.text = (valueSplit.text.toString().toInt() - 1).toString()
                val finalValuePreUpdateBD = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[2]
                val tipShown = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[0]
                val finalValuePreUpdate = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[1]
                finalValue.text = "€ $finalValuePreUpdateBD"
                tipEnd.text = "€$tipShown"
                billEnd.text = "€$finalValuePreUpdate"
            }
        }
        plus.setOnClickListener {
            if (valueSplit.text.toString().toInt() < 20) {
                valueSplit.text = (valueSplit.text.toString().toInt() + 1).toString()
                val finalValuePreUpdateBD = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[2]
                val tipShown = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[0]
                val finalValuePreUpdate = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[1]
                finalValue.text = "€ $finalValuePreUpdateBD"
                tipEnd.text = "€$tipShown"
                billEnd.text = "€$finalValuePreUpdate"
            }
        }


        mainActivity.setOnClickListener {

            val finalValuePreUpdateBD = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[2]
            val tipShown = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[0]
            val finalValuePreUpdate = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[1]
            finalValue.text = "€ $finalValuePreUpdateBD"
            tipEnd.text = "€$tipShown"
            billEnd.text = "€$finalValuePreUpdate"
        }

        tip0.setOnClickListener {
            tipFinal = 0.0
            val finalValuePreUpdateBD = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[2]
            val tipShown = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[0]
            val finalValuePreUpdate = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[1]
            finalValue.text = "€ $finalValuePreUpdateBD"
            tipEnd.text = "€$tipShown"
            billEnd.text = "€$finalValuePreUpdate"
        }
        tip10.setOnClickListener {
            tipFinal = 0.1
            val finalValuePreUpdateBD = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[2]
            val tipShown = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[0]
            val finalValuePreUpdate = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[1]
            finalValue.text = "€ $finalValuePreUpdateBD"
            tipEnd.text = "€$tipShown"
            billEnd.text = "€$finalValuePreUpdate"
        }
        tip20.setOnClickListener {
            tipFinal = 0.2
            val finalValuePreUpdateBD = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[2]
            val tipShown = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[0]
            val finalValuePreUpdate = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[1]
            finalValue.text = "€ $finalValuePreUpdateBD"
            tipEnd.text = "€$tipShown"
            billEnd.text = "€$finalValuePreUpdate"
        }
        tip25.setOnClickListener {
            tipFinal = 0.25
            val finalValuePreUpdateBD = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[2]
            val tipShown = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[0]
            val finalValuePreUpdate = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[1]
            finalValue.text = "€ $finalValuePreUpdateBD"
            tipEnd.text = "€$tipShown"
            billEnd.text = "€$finalValuePreUpdate"
        }
        tip30.setOnClickListener {
            tipFinal = 0.3
            val finalValuePreUpdateBD = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[2]
            val tipShown = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[0]
            val finalValuePreUpdate = calculateTotalPerPerson(billTotal, valueSplit, tipFinal)[1]
            finalValue.text = "€ $finalValuePreUpdateBD"
            tipEnd.text = "€$tipShown"
            billEnd.text = "€$finalValuePreUpdate"
        }

    }

    private fun calculateTotalPerPerson(billTotal: TextInputEditText, valueSplit: TextView, tipFinal: Double): Array<String> {
        println("AQUIIIII")
        val tip = (BigDecimal(billTotal.text.toString().toDouble() / valueSplit.text.toString().toDouble() * tipFinal).setScale(2, RoundingMode.HALF_EVEN)).toString()
        val finalValuePreUpdate = (BigDecimal(billTotal.text.toString().toDouble() / valueSplit.text.toString().toDouble()).setScale(2,RoundingMode.HALF_EVEN)).toString()
        val finalValuePreUpdateBD = (BigDecimal(finalValuePreUpdate.toDouble() + tip.toDouble()).setScale(2, RoundingMode.HALF_EVEN)).toString()
        return arrayOf(tip, finalValuePreUpdate, finalValuePreUpdateBD)

    }
}