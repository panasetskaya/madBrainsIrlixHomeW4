package com.example.madbrainshw4

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.madbrainshw4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var state = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState!=null) {
            choosePicture(savedInstanceState.getInt("MyArg"), binding)
            Log.i("MyRes", "onCreate savedInstanceState!=null state: $state")
        }

        val myActivityLauncher = registerForActivityResult(MyActivityResultContract()) {
            state = it
            choosePicture(state, binding)
        }

        binding.buttonOne.setOnClickListener {
            myActivityLauncher.launch("What number?")
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getInt("MyArg")
        Log.i("MyRes", "onRestoreInstanceState state: $state")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("MyArg", state)
    }

    fun choosePicture(result: Int, binding: ActivityMainBinding) {
        when (result) {
            2 -> {
                binding.imageViewMain.setImageResource(R.drawable.two)
                binding.buttonOne.setBackgroundColor(Color.parseColor("#FF6200EE"))
            }
            3 -> {
                binding.imageViewMain.setImageResource(R.drawable.three)
                binding.buttonOne.setBackgroundColor(Color.parseColor("#FF000000"))
            }
            else -> {
                binding.imageViewMain.setImageResource(R.drawable.one)
                binding.buttonOne.setBackgroundColor(Color.parseColor("#FF03DAC5"))
            }
        }
    }
}