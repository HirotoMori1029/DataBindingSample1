package com.hirogram.databindingsample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.hirogram.databindingsample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonConfirm.setOnClickListener {
            Toast.makeText(this, binding.inputText, Toast.LENGTH_LONG).show()
        }
    }
}