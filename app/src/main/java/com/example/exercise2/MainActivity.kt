package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculate()
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            reset()
        }

    }
    private fun calculate(){
        val weight =findViewById<EditText>(R.id.editTextWeight).text.toString().toDouble()
        val height = findViewById<EditText>(R.id.editTextHeight).text.toString().toDouble()


        val bmi =   weight / ((height/100)*(height/100))

        textViewBMI.text = bmi.toString()
        if(bmi < 18.5){

            findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.under)
        }
        else if(bmi >= 18.5 && bmi <= 24.9){

            findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.normal)
        }
        else if(bmi > 25){

            findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.over)
        }
        else{
            findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.empty)
        }


    }

    private fun reset(){
        editTextWeight.text = null
        editTextHeight.text = null
        textViewBMI.text = null
        findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.empty)
    }
}
