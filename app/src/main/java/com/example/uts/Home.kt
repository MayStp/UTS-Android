package com.example.uts

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uts.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(MainActivity.uname)

        with(binding){
            ambilNama.text = name
            btnFilm.setOnClickListener{
                val intentToDetails= Intent(this@Home, Details::class.java)
                startActivity(intentToDetails)
            }

            btnFilm1.setOnClickListener{
                val intentToDetails= Intent(this@Home, Details::class.java)
                startActivity(intentToDetails)
            }
        }
    }


}