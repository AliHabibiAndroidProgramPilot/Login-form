package com.ir.ali.login_form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ir.ali.login_form.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignIn.setOnClickListener {
            val email: String = binding.editText1.text.toString().trim()
            val password: String = binding.editText2.text.toString().trim()
            if(emailValidation(email) && passwordValidation(password)) {
                Toast.makeText(this, "SIGNED IN", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun passwordValidation(password: String): Boolean {
        if (password.isEmpty()) {
            binding.passwordEdittext.error = "Password Can not be Empty"
            return false
        }
        else {
            if (password.length < 8) {
                binding.passwordEdittext.error = "Password Should be more than 8 Character"
                return false
            }
        }
        binding.passwordEdittext.error = null
        return true
    }

    private fun emailValidation(email: String): Boolean {
        if (email.isEmpty()) {
            binding.emailEdittext.error = "Email Can not be Empty"
            return false
        }
        else {
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailEdittext.error = "Enter Valid Email"
                return false
            }
        }
        binding.emailEdittext.error = null
        return true
    }
}