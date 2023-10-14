package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.uts.databinding.ActivityPaymentBinding

class payment : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding
    private val jeniskursi = arrayOf(
        "Regular",
        "VIP",
        "VVIP"
    )
    private val tempatBioskop = arrayOf(
        "Sleman City Hall",
        "Empire XXI",
        "CGV J-Walk"
    )
    private val paymeth = arrayOf(
        "Bank Transfer",
        "E-Wallet"
    )
    private val banks = arrayOf(
        "BNI",
        "BCA"
    )
    private val ewallets = arrayOf(
        "GOPAY",
        "DANA"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)

        setContentView(binding.root)
        with(binding){

            bckbutton.setOnClickListener{
                val intentToHome = Intent(this@payment, Details::class.java)
                startActivity(intentToHome)
            }

            val jenisKursiAdapter = ArrayAdapter(this@payment,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, jeniskursi)
            jenisKursiAdapter.setDropDownViewResource(
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item)
            spinSeat.adapter = jenisKursiAdapter

            val TempatBioskopAdapter = ArrayAdapter(this@payment,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, tempatBioskop)
            TempatBioskopAdapter.setDropDownViewResource(
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item)
            spinTempat.adapter = TempatBioskopAdapter

            val PaymentMethodAdapter = ArrayAdapter(this@payment,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, paymeth)
            TempatBioskopAdapter.setDropDownViewResource(
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item)
            metodePembayaran.adapter = PaymentMethodAdapter

            // Listener untuk Spinner metode pembayaran
            binding.metodePembayaran.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val selectedPaymentMethod = parent?.getItemAtPosition(position).toString()
                    val adapter = when (selectedPaymentMethod) {
                        "Bank Transfer" -> ArrayAdapter(this@payment, android.R.layout.simple_spinner_item, banks)
                        "E-Wallet" -> ArrayAdapter(this@payment, android.R.layout.simple_spinner_item, ewallets)
                        else -> ArrayAdapter(this@payment, android.R.layout.simple_spinner_item, emptyArray())
                    }
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    binding.method.adapter = adapter
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

            //Kirim data dari spinenr
            getRecipt.setOnClickListener {
                val intentToRecipt = Intent(this@payment, Recipt::class.java)

                //kirim data jenis kursi
                val selectedSeat = jeniskursi[spinSeat.selectedItemPosition]
                intentToRecipt.putExtra("selectedSeat", selectedSeat)

                //kirim data jenis payment
                val selectedPayment = paymeth[method.selectedItemPosition]
                intentToRecipt.putExtra("selectedType", selectedPayment)

                // Mendapatkan pilihan e-wallet atau bank sesuai dengan metode pembayaran yang dipilih
                val selectedMethod = when (selectedPayment) {
                    "Bank Transfer" -> banks[method.selectedItemPosition]
                    "E-Wallet" -> ewallets[method.selectedItemPosition]
                    else -> ""
                }
                intentToRecipt.putExtra("selectedMethod", selectedMethod)

                //kirim data bioskop
                val selectedCinema = tempatBioskop[spinTempat.selectedItemPosition]
                intentToRecipt.putExtra("selectedCinema", selectedCinema)

                //kirim data kalender
                //Ambil data dari DatePicker
                val hari = binding.pickdate.dayOfMonth
                val bulan = binding.pickdate.month
                val tahun = binding.pickdate.year
                // Format tanggal dan waktu ke dalam sebuah pesan
                val formatTanggal = "$hari/${bulan + 1}/$tahun"
                intentToRecipt.putExtra("pass_tgl", formatTanggal)

                startActivity(intentToRecipt)
            }




        }
    }
}