package com.example.bai1_tuan7

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNumber: EditText = findViewById(R.id.edtNumber)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val btnShow: Button = findViewById(R.id.btnShow)
        val tvError: TextView = findViewById(R.id.tvError)
        val listView: ListView = findViewById(R.id.listView)

        btnShow.setOnClickListener {
            val input = edtNumber.text.toString()
            tvError.visibility = View.GONE
            if (input.isEmpty() || input.toIntOrNull() == null || input.toInt() < 0) {
                tvError.text = "Vui lòng nhập một số nguyên dương."
                tvError.visibility = View.VISIBLE
                return@setOnClickListener
            }

            val n = input.toInt()
            val results = when (radioGroup.checkedRadioButtonId) {
                R.id.radioEven -> getEvenNumbers(n)
                R.id.radioOdd -> getOddNumbers(n)
                R.id.radioPrime -> getPerfectSquares(n)
                else -> listOf()
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, results)
            listView.adapter = adapter
        }
    }

    private fun getEvenNumbers(n: Int): List<Int> {
        return (0..n).filter { it % 2 == 0 }
    }

    private fun getOddNumbers(n: Int): List<Int> {
        return (1..n).filter { it % 2 != 0 }
    }

    private fun getPerfectSquares(n: Int): List<Int> {
        val perfectSquares = mutableListOf<Int>()
        var i = 0
        while (i * i <= n) {
            perfectSquares.add(i * i)
            i++
        }
        return perfectSquares
    }
}
