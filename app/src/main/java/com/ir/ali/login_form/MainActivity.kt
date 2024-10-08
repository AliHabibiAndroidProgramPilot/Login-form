package com.ir.ali.login_form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ir.ali.login_form.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }
        binding.registerButton.setOnClickListener { startActivity(Intent(this, RegisterActivity::class.java)) }
    }
}