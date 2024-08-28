package com.ir.ali.login_form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.Toast
import com.ir.ali.login_form.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        binding.btnSignIn.setOnClickListener {
            val email: String = binding.editText1.text.toString().trim()
            val password: String = binding.editText2.text.toString().trim()
            val confirmedPassword: String = binding.editText3.text.toString().trim()
            if (
                emailValidation(email)
                &&
                passWordValidation(password)
                &&
                confirmPasswordValidation(confirmedPassword, password)) {
                Toast.makeText(this, "SIGNED IN", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun confirmPasswordValidation(confirmedPassword: String, password: String): Boolean {
        if (password.isEmpty()) {
            binding.passwordEditText.error = "Password Can not be Empty"
            return false
        }
        else {
            if (password != confirmedPassword) {
                binding.confirmPasswordEditText.error = "Confirm Password Correctly"
                return false
            }
        }
        binding.confirmPasswordEditText.error = null
        return true
    }

    private fun passWordValidation(password: String): Boolean {
        if (password.isEmpty()) {
            binding.passwordEditText.error = "Password Can not be Empty"
            return false
        }
        else {
            if (password.length < 8) {
                binding.passwordEditText.error = "Password Should be more than 8 Character"
                binding.passwordEditText.isCounterEnabled = true
                binding.passwordEditText.counterMaxLength = 8
                val textWatcher: TextWatcher = object : TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun afterTextChanged(p0: Editable?) {
                        if (binding.editText2.length() == binding.passwordEditText.counterMaxLength) {
                            binding.passwordEditText.error = null
                            binding.passwordEditText.isCounterEnabled = false
                        }
                    }
                }
                binding.editText2.addTextChangedListener(textWatcher)
                return false
            }
        }
        binding.passwordEditText.error = null
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}