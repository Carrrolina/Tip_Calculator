package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            val totalAmountTemporary = binding.tieTotal.text
            val numberOfPeopleTemporary = binding.tieNumberOfPeople.text
            val percentageTemporary = binding.tiePercentage.text

            if (totalAmountTemporary?.isEmpty() == true ||
                numberOfPeopleTemporary?.isEmpty() == true ||
                percentageTemporary?.isEmpty() == true
            ) {
                Snackbar
                    .make(binding.tieTotal,
                        getString(R.string.fill_in_all_fields), Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val totalAmount: Float = totalAmountTemporary.toString().toFloat()
                val numberPeople: Int = numberOfPeopleTemporary.toString().toInt()
                val percentage: Int = percentageTemporary.toString().toInt()
                val totalTemporary = totalAmount / numberPeople
                val totalTips = totalTemporary * percentageTemporary.toString().toInt() / 100
                val totalWithTips = totalTemporary + totalTips

                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("totalAmount", totalAmount)
                    putExtra("numberPeople", numberPeople)
                    putExtra("percentage", percentage)
                    putExtra("totalGlobal", totalWithTips)
                }
                clean()
                startActivity(intent)
            }

        }

        binding.btnClean.setOnClickListener {
            clean()

        }
    }

    private fun clean(){
        binding.tieTotal.setText("")
        binding.tiePercentage.setText("")
        binding.tieNumberOfPeople.setText("")

    }
}