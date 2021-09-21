package com.afrosoft.yourweighton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val marsGravity: Float = 0.38F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weight = enterWeightId.text

        showWeightButtonId.setOnClickListener {
            var result = calculateWeight(weight.toString().toDouble())
            resultTextView.text = "You weigh "+result.toString()+" pounds on mars"
        }

    }
    fun calculateWeight(userWeight: Double): Double{
        return userWeight * marsGravity
    }
}