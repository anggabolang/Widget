package com.example.myapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar

//membuat varibable binding
private lateinit var binding : ActivityWidgetBinding

class widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi binding
        binding = ActivityWidgetBinding.inflate(layoutInflater)
        //mamanggil layout dengan menggunakan binding.root
        setContentView(binding.root)

        //button Toast
        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "ini adalah Toast", Toast.LENGTH_SHORT).show()
        }
        //button snackbar
        binding.btnsnackbar.setOnClickListener {
            Snackbar.make(it, "ini adalah snackbar", Snackbar.LENGTH_SHORT).show()
        }
        //button alert
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("message")
                setMessage("Ini adalah alert")

                setPositiveButton("OK") { dialog, _ ->
                    Toast.makeText(applicationContext, "Anda click Ok", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                setNegativeButton("Back") { dialog, _ ->
                    Toast.makeText(applicationContext, "Anda click Back", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }.show()
        }
        //button custom dialog
        binding.btnCustomDialog.setOnClickListener {
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.custom_dialog)

                val btnCancel = this.findViewById<Button>(R.id.btnCancel)
                val btnContinue = this.findViewById<Button>(R.id.btnContinue)

                btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext, "anda klik Cancel", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
                btnContinue.setOnClickListener {
                    Toast.makeText(applicationContext, "anda klik Continue", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
            }.show()
        }
    }
}