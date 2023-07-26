package com.example.temperatureconverter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1=findViewById<Button>(R.id.button)
        val btn2=findViewById<Button>(R.id.button2)
        val result=findViewById<TextView>(R.id.result)
        val userValue=findViewById<EditText>(R.id.input)
        val tv2=findViewById<TextView>(R.id.tv2)
        val tv3=findViewById<TextView>(R.id.textView4)
        val btn3=findViewById<Button>(R.id.clear)

        tv3.visibility=View.GONE

        fun validate(userValue:String?):Boolean{
            return  when{
                userValue.isNullOrEmpty() ->{
                    Toast.makeText(this,"Please enter a value",Toast.LENGTH_LONG).show()
                    return false
                }
                else -> {
                    return true
                }
            }
        }

        btn1.setOnClickListener {
            val value=userValue.text.toString()
            if(validate(value)) {
                val farValue = ((value.toFloat() * 1.8) + 32)
                val decimalFormat = DecimalFormat("#.##")
                val formattedAns = decimalFormat.format(farValue)
                result.text = formattedAns.toString()
                tv2.text = "Fahrenheit"
                tv3.visibility = View.VISIBLE
            }
        }
        btn2.setOnClickListener {
            val value=userValue.text.toString()
            if(validate(value)) {
                val celValue = ((value.toFloat() - 32) * 0.56)
                val decimalFormat = DecimalFormat("#.##")
                val formattedAns = decimalFormat.format(celValue)
                result.text = formattedAns.toString()
                tv2.text = "Celsius"
                tv3.visibility = View.VISIBLE
            }
        }
        btn3.setOnClickListener {
            result.text=""
            tv2.text=""
            tv3.visibility=View.GONE
        }
    }

}
