package com.afrosoft.yourweighton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            R.id.marscheckBox -> if(isChecked){
                calculateWeight(weight.toString().toDouble(),v)}
            R.id.venuscheckBox -> if(isChecked){
                calculateWeight(weight.toString().toDouble(),v)}
            R.id.jupitercheckBox -> if(isChecked){
                calculateWeight(weight.toString().toDouble(),v)}
        }
    }
    fun calculateWeight(userWeight: Double, checkBox: CheckBox){
        var result: Double?
        when(checkBox.id){
            R.id.marscheckBox -> result = userWeight * marsGravity
            R.id.venuscheckBox -> result = userWeight * venusGravity
            R.id.jupitercheckBox -> result = userWeight * jupiterGravity
            else -> result = userWeight * marsGravity
        }
        resultTextView.text = "Weight is $result "
    }
}