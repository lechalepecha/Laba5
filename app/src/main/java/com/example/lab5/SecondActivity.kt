package com.example.lab5

import android.os.Bundle
import android.widget.EditText
import java.text.DecimalFormat
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private lateinit var result: TextView
    val decimalFormat = DecimalFormat("#.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val Selected_Radio = intent.getStringExtra("Selected_Radio")
        val percent = intent.getStringExtra("Percent")?.toDoubleOrNull() ?: 0.0

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        result=findViewById(R.id.result)
        var resault:Double=percent
        when(Selected_Radio){
            "option1"->{
                    resault += resault*0.03
            }
            "option2"->{
                    resault += resault*0.05
            }
            "option3"->{
                    resault += resault*0.09
            }
        }
        val editedText = decimalFormat.format(resault)
        result.text=editedText
    }
}