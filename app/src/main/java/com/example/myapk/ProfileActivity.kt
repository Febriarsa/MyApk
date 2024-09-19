package com.example.myapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapk.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data yang dikirim dari LoginActivity
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val gender = intent.getStringExtra("gender")

        // Menampilkan data di halaman profil
        binding.tvName.text = "Nama: $name"
        binding.tvEmail.text = "Email: $email"
        binding.tvPhone.text = "No HP: $phone"
        binding.tvGender.text = "Jenis Kelamin: $gender"
    }
}
