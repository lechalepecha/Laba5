package com.example.lab5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var money_amount: EditText
    private lateinit var option1: RadioButton
    private lateinit var option2: RadioButton
    private lateinit var option3: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        option1=findViewById(R.id.option_1)
        option2=findViewById(R.id.option_2)
        option3=findViewById(R.id.option_3)
        money_amount=findViewById(R.id.amount)
        btn=findViewById(R.id.calc_button)
        btn.setOnClickListener()
        {
            val intent=Intent(this,SecondActivity::class.java)
            when{
                option1.isChecked->intent.putExtra("Selected_Radio","option1")
                option2.isChecked->intent.putExtra("Selected_Radio","option2")
                option3.isChecked->intent.putExtra("Selected_Radio","option3")
            }
            intent.putExtra("MoneyAmount",money_amount.text.toString())
            startActivity(intent)
        }

    }


}