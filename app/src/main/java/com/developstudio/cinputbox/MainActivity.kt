package com.developstudio.cinputbox

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.developstudio.coinputbox.DevelopTextWatcher
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var editText: TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        editText = findViewById(R.id.editText)

        val maxPlateLength = 13// 7  OTP,  //13 plate
        val separatorIndices = listOf(1, 3, 5)//listOf(2, 5, 8)

        val textWatcher = DevelopTextWatcher(editText, maxPlateLength, separatorIndices, '-')
        editText.addTextChangedListener(textWatcher)


    }
}