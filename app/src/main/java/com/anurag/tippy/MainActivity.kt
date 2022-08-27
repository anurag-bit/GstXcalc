package com.anurag.tippy


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anurag.tippy.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (::binding.isInitialized){
            println("true")
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.CalcButton.setOnClickListener{calculatetip()  }

    }

    private fun calculatetip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()
        val tipPercentage = when (binding.radioGroupButtons.checkedRadioButtonId) {
            R.id.quality_choice_amazing -> 0.28
            R.id.quality_choice_good -> 0.18
            else -> 0.12
        }
        var tip = tipPercentage * cost
        val roundUp = binding.approxiSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance(Locale("en", "in")).format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }

}
