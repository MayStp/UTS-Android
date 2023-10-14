package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.uts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object{
        const val uname = "username"
        const val pwd = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            btnlogin.setOnClickListener{
                val intentToHome = Intent(this@MainActivity, Home::class.java)
                intentToHome.putExtra(uname, inputUsername.text.toString())
                startActivity(intentToHome)
            }
        }
    }

    fun goToHome(view: View){
        val intent = Intent(this, Details::class.java)
        startActivity(intent)
    }
}