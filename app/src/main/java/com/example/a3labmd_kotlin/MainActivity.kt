package com.example.a3labmd_kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var ChoiceTextView: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ChoiceTextView = findViewById(R.id.textView2)
        var ChoiceButton: Button = findViewById(R.id.Button)
        var EditTextNumber: EditText = findViewById(R.id.editTextNumber)
        var CorrectAnswer = ""
        var Prompt = ""
        var Attempt = 0
        for (i in 0..3) {
            CorrectAnswer += Random.nextInt(0, 9).toString()
        }
        ChoiceButton.setOnClickListener {
            if (EditTextNumber.text.isEmpty()) {
                ChoiceTextView.text = "Вы ничего не ввели!";
            } else if ((EditTextNumber.text).length != 4) {
                ChoiceTextView.text = "Требуется ввести четырехзначное число!"
            } else if (EditTextNumber.text.toString() == CorrectAnswer) {
                Attempt++
                ChoiceTextView.text = "Вы угадали! Ответ:" + CorrectAnswer + "\nПотребовалось попыток: " + Attempt + "\n\nКомпьютер загадал новое число."
                Attempt = 0
                CorrectAnswer = ""
                for (i in 0..3) {
                    CorrectAnswer += Random.nextInt(0, 9).toString()
                }
            } else {
                Attempt++;
                for (i in 0..3) {
                    for (j in 0..3) {
                        if (CorrectAnswer[i] == EditTextNumber.text[j] && i == j) {
                            Prompt += "В"
                        } else if (CorrectAnswer[i] == EditTextNumber.text[j]) {
                            Prompt += "K"
                        }
                    }
                }
                ChoiceTextView.text = "Попытка " + Attempt + ":\n" + EditTextNumber.text + " - " + Prompt
                Prompt = ""
            }
        }
    }
}

