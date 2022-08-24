package com.anurag.tippy


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anurag.tippy.databinding.ActivityMainBinding
import java.text.NumberFormat


 private class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.CalcButton.setOnClickListener{calculateTip()}

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun calculateTip() {
        val stringIntextField = binding.costOfService.text.toString()
        val cost = stringIntextField.toDouble()

        val tipPercentage = when (binding.radioGroupButtons.checkedRadioButtonId) {
            R.id.quality_choice_amazing -> 0.20
            R.id.quality_choice_good -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundup = binding.approxiSwitch.isChecked
        if (roundup) {
            tip = kotlin.math.ceil(tip)
        }
      NumberFormat.getCurrencyInstance()
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }


}

