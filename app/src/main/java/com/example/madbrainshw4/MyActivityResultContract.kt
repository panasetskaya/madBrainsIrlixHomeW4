package com.example.madbrainshw4

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class MyActivityResultContract: ActivityResultContract<String, Int>() {
    override fun createIntent(context: Context, input: String): Intent {
        return Intent(context,SecondActivity::class.java).apply {
            putExtra("input",input)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Int {
        val data = intent?.getIntExtra("result",1)
        return if (resultCode == Activity.RESULT_OK && data != null) data else 1
    }
}