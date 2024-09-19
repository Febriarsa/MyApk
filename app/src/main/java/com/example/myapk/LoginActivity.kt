package com.example.myapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapk.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data yang dikirim dari RegisterActivity
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val gender = intent.getStringExtra("gender")
        val password = intent.getStringExtra("password")

        // Saat tombol Login ditekan
        binding.btnLogin.setOnClickListener {
            val inputUsername = binding.etUsername.text.toString()
            val inputPassword = binding.etPassword.text.toString()
            if (inputUsername == name || inputUsername == email && inputPassword == password) {
                // Passing data ke halaman Profil
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                intent.putExtra("phone", phone)
                intent.putExtra("gender", gender)
                intent.putExtra("password", password)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username/Email atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
