package com.example.aplication

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {

    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets




        }

        val inputvalue: EditText = findViewById(R.id.valueInput)
        val botaoInicar: Button = findViewById(R.id.start)
        val botaoPara: Button = findViewById(R.id.stop)
        val resul: TextView = findViewById(R.id.textResult)

        botaoInicar.setOnClickListener {

            try {
                val number = inputvalue.text.toString().toLong()

                timer = object : CountDownTimer (number * 60 * 1000, 1000){
                    override fun onTick(millisUntilFinished: Long) {
                        var seconds = millisUntilFinished / 1000
                        var minutes = seconds / 60
                        seconds = seconds % 60
                        resul.text = String.format("%02d: %02d" , minutes, seconds)
                    }

                    override fun onFinish() {
                        resul.text = "Vishi, O tempo Acabou !"
                    }

                }

                timer?.start()

            } catch (e: NumberFormatException ) {
                Toast.makeText(this, "Digite seu Tempo !", Toast.LENGTH_SHORT).show()
            }

            botaoPara.setOnClickListener {
                timer?.cancel()
            }
        }


    }




}