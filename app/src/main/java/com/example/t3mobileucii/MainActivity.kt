package com.example.t3mobileucii

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi semua widget
        val etNama        = findViewById<EditText>(R.id.etNama)
        val rgKelamin     = findViewById<RadioGroup>(R.id.rgKelamin)
        val cbMembaca     = findViewById<CheckBox>(R.id.cbMembaca)
        val cbCoding      = findViewById<CheckBox>(R.id.cbCoding)
        val cbOlahraga    = findViewById<CheckBox>(R.id.cbOlahraga)
        val btnTampilkan  = findViewById<Button>(R.id.btnTampilkan)
        val tvHasil       = findViewById<TextView>(R.id.tvHasil)

        btnTampilkan.setOnClickListener {

            // 1. Ambil nilai nama
            val nama = etNama.text.toString().trim()

            // 2. Validasi nama tidak boleh kosong
            if (nama.isEmpty()) {
                etNama.error = "Nama tidak boleh kosong!"
                etNama.requestFocus()
                return@setOnClickListener
            }

            // 3. Ambil jenis kelamin
            val selectedGenderId = rgKelamin.checkedRadioButtonId

            // 4. Validasi gender harus dipilih
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Pilih jenis kelamin terlebih dahulu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val rbDipilih = findViewById<RadioButton>(selectedGenderId)
            val kelamin   = rbDipilih.text.toString()

            // 5. Ambil hobi yang dicentang
            val hobiList = mutableListOf<String>()
            if (cbMembaca.isChecked)  hobiList.add(cbMembaca.text.toString())
            if (cbCoding.isChecked)   hobiList.add(cbCoding.text.toString())
            if (cbOlahraga.isChecked) hobiList.add(cbOlahraga.text.toString())

            val hobiText = if (hobiList.isEmpty()) "-" else hobiList.joinToString(", ")

            // 6. Tampilkan hasil di TextView
            val hasil = """
                Nama     : $nama
                Kelamin  : $kelamin
                Hobi     : $hobiText
            """.trimIndent()

            tvHasil.setTextColor(resources.getColor(android.R.color.black, theme))
            tvHasil.text = hasil
        }
    }
}