package com.example.uts

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uts.databinding.ActivityReciptBinding

class Recipt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityReciptBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            bckbutton.setOnClickListener{
                val intentToHome = Intent(this@Recipt, payment::class.java)
                startActivity(intentToHome)
            }
        }

        val selSeat = intent.getStringExtra("selectedSeat")
        val selPayMeth = intent.getStringExtra("selectedType")
        val methodChoosed = intent.getStringExtra("selectedMethod")
        val getTgl = intent.getStringExtra("pass_tgl")
        val getCinema = intent.getStringExtra("selectedCinema")

        binding.seat.text = "$selSeat"
        binding.tglDanWaktu.text = "$getTgl"
        binding.paymentMethodChoosed.text = "$selPayMeth ($methodChoosed)"
        binding.cinema.text = "$getCinema"


    }
}