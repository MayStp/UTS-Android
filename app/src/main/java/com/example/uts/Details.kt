package com.example.uts

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uts.databinding.ActivityDetailsBinding

class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            getTicket.setOnClickListener {
                val intentTopayment = Intent(this@Details, payment::class.java)
                startActivity(intentTopayment)
            }
            bckbutton.setOnClickListener{
                val intentToHome = Intent(this@Details, Home::class.java)
                startActivity(intentToHome)
            }
        }
    }
}