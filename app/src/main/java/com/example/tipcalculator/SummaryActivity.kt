package com.example.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.example.tipcalculator.databinding.ActivitySummaryBinding


class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalAmount = intent.getFloatExtra("totalAmount",0.0f)
        val numberPeople = intent.getIntExtra("numberPeople", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalGlobal = intent.getFloatExtra("totalGlobal", 0.0f)

        binding.tvPercentage.text = percentage.toString() + "%"
        binding.tvTotalGlobal.text = totalGlobal.toString()
        binding.tvTotalAmount.text = totalAmount.toString()
        binding.tvNumberPeople.text = numberPeople.toString()

        binding.btnRefresh.setOnClickListener {
            finish()
        }


        println(totalGlobal)
    }
}