package com.example.myapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.myapk.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menyiapkan Spinner untuk Jenis Kelamin
        val genderOptions = arrayOf("Laki-laki", "Perempuan")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderOptions)
        binding.spinnerGender.adapter = adapter

        // Saat tombol "Daftar" ditekan
        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val phone = binding.etPhone.text.toString()
            val gender = binding.spinnerGender.selectedItem.toString()
            val password = binding.etPassword.text.toString()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Mohon isi semua field", Toast.LENGTH_SHORT).show()
            } else {
                // Passing data ke halaman Login
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                intent.putExtra("phone", phone)
                intent.putExtra("gender", gender)
                startActivity(intent)
            }
        }
    }
}
