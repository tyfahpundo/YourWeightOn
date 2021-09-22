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

        var weight = enterWeightId.text

        showWeightButtonId.setOnClickListener {
            var result = calculateWeight(weight.toString().toDouble())
            resultTextView.text = "You weigh "+result.toString()+" pounds on mars"
        }
        marscheckBox.setOnClickListener(this)//Register our clickListener
        venuscheckBox.setOnClickListener(this)
        jupitercheckBox.setOnClickListener(this)

    }
    fun calculateWeight(userWeight: Double): Double{
        return userWeight * marsGravity
    }

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked: Boolean = v.isChecked

        when(v.id){
            R.id.marscheckBox -> if(isChecked){
                Log.d("Setup Mars","Mars")}
            R.id.venuscheckBox -> if(isChecked){
                Log.d("Setup Venus", "Venus")}
            R.id.jupitercheckBox -> if(isChecked){
                Log.d("Setup Jupiter","Jupiter")}
        }
    }
}