package com.camposvega.evaluacioncontinua3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.camposvega.evaluacioncontinua3.ui.Home

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boton1=findViewById<Button>(R.id.button)
        boton1.setOnClickListener {
            val home = Intent(this, Home::class.java)
            startActivity(home)
        }
    }
}