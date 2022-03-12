package com.example.madbrainshw4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madbrainshw4.databinding.ActivityMainBinding
import com.example.madbrainshw4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener {
            sendNumber(1)
        }
        binding.button2.setOnClickListener {
            sendNumber(2)
        }
        binding.button3.setOnClickListener {
            sendNumber(3)
        }
    }

    private fun sendNumber(number: Int) {
        val intentData = Intent()
        intentData.putExtra("result", number)
        setResult(RESULT_OK,intentData)
        finish()
    }
}