package com.example.execise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat
import android.content.Intent
import android.text.TextUtils
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val price = findViewById<EditText>(R.id.editTextCarPrice)
        val pay = findViewById<EditText>(R.id.editTextDownPayment)
        val per = findViewById<EditText>(R.id.editTextLoanPeriod)
        val intr = findViewById<EditText>(R.id.editTextInterestRate)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            if (TextUtils.isEmpty(price.getText())||TextUtils.isEmpty(pay.getText())||TextUtils.isEmpty(per.getText())||TextUtils.isEmpty(intr.getText())) {
                Toast.makeText(this, R.string.error_input,
                    Toast.LENGTH_SHORT).show()

            }
            else{
                calcuLoan(it)
            }
        }

        findViewById<TextView>(R.id.buttonReset).setOnClickListener {
            btnRe(it)
        }

    }

    private fun calcuLoan(view: View) {
        val price = findViewById<EditText>(R.id.editTextCarPrice)
        val pay = findViewById<EditText>(R.id.editTextDownPayment)
        val per = findViewById<EditText>(R.id.editTextLoanPeriod)
        val intr = findViewById<EditText>(R.id.editTextInterestRate)
        val txtLoan = findViewById<TextView>(R.id.textViewLoan)
        val txtInt = findViewById<TextView>(R.id.textViewInterest)
        val txtMon = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        val carLoan = price.text.toString().toDouble() - pay.text.toString().toDouble()
        val interest = carLoan * (intr.text.toString().toDouble()/100) * per.text.toString().toInt()

        val decF = DecimalFormat("RM###########.##")
        txtLoan.text = "Loan : " + decF.format(carLoan)
        txtInt.text = "Interest : " +  decF.format(interest)
        txtMon.text = "Monthly Repayment : " + decF.format((carLoan + interest)/per.text.toString().toInt()/12)
    }

    private fun btnRe(view: View) {
        val price = findViewById<EditText>(R.id.editTextCarPrice)
        val pay = findViewById<EditText>(R.id.editTextDownPayment)
        val per = findViewById<EditText>(R.id.editTextLoanPeriod)
        val intr = findViewById<EditText>(R.id.editTextInterestRate)
        val txtLoan = findViewById<TextView>(R.id.textViewLoan)
        val txtInt = findViewById<TextView>(R.id.textViewInterest)
        val txtMon = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        price.text.clear()
        pay.text.clear()
        per.text.clear()
        intr.text.clear()
        txtLoan.text = "Loan :"
        txtInt.text = "Interest :"
        txtMon.text = "Monthly Repayment :"
    }
}
