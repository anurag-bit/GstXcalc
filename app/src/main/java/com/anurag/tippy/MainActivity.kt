package com.anurag.tippy


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anurag.tippy.databinding.ActivityMainBinding
import java.sql.SQLData
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (::binding.isInitialized){
            println("true")
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.CalcButton.setOnClickListener{Calculat_tip()  }
    }

    fun Calculat_tip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()
        val tipPercentage = when (binding.radioGroupButtons.checkedRadioButtonId) {
            R.id.quality_choice_amazing -> 0.20
            R.id.quality_choice_good -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundUp = binding.approxiSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }

}
