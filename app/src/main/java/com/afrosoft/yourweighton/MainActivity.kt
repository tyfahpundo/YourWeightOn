package com.afrosoft.yourweighton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val marsGravity= 0.38
    val venusGravity =0.91
    val jupiterGravity = 2.34

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        showWeightButtonId.setOnClickListener {
//            var result = calculateWeight(weight.toString().toDouble())
//            resultTextView.text = "You weigh "+result.toString()+" pounds on mars"
        }
        marscheckBox.setOnClickListener(this)//Register our clickListener
        venuscheckBox.setOnClickListener(this)
        jupitercheckBox.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked: Boolean = v.isChecked
        var weight = enterWeightId.text

        when(v.id){
            R.id.marscheckBox -> if(isChecked && !TextUtils.isEmpty(enterWeightId.text.toString()))
                                    {
                                        calculateWeight(weight.toString().toDouble(),v)
                                        venuscheckBox.isChecked = false
                                        jupitercheckBox.isChecked = false
                                    }
            R.id.venuscheckBox -> if(isChecked && !TextUtils.isEmpty(enterWeightId.text.toString()))
                                    {
                                        calculateWeight(weight.toString().toDouble(),v)
                                        marscheckBox.isChecked =false
                                        jupitercheckBox.isChecked = false
                                    }
            R.id.jupitercheckBox -> if(isChecked && !TextUtils.isEmpty(enterWeightId.text.toString()))
                                    {
                                        calculateWeight(weight.toString().toDouble(),v)
                                        marscheckBox.isChecked = false
                                        venuscheckBox.isChecked = false
                                    }
        }
    }
    fun calculateWeight(userWeight: Double, checkBox: CheckBox){
        var result: Double?
        when(checkBox.id){
            R.id.marscheckBox -> {
                result = userWeight * marsGravity
                resultTextView.text = "Weight is ${result.format(2)} on Mars"
            }
            R.id.venuscheckBox -> {
                result = userWeight * venusGravity
                resultTextView.text = "Weight is ${result.format(2)} on Venus"
            }
            R.id.jupitercheckBox -> {
                result = userWeight * jupiterGravity
                resultTextView.text = "Weight is ${result.format(2)} on Jupiter"
            }
            else -> {
                result = userWeight * marsGravity
                resultTextView.text = "Weight is ${result.format(2)} on Mars"
            }
        }

    }
    fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f",this)
}