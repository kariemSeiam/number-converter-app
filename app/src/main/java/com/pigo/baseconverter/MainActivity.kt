package com.pigo.baseconverter

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    private lateinit var inputNumberTextInput: TextInputEditText
    private lateinit var resultTextView: TextView
    private lateinit var convertFromTextView: TextView
    private lateinit var convertToTextView: TextView
    private lateinit var deleteButton: Button
    private lateinit var convertButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViews()
        setUpClickListeners()

    }

    private fun setUpViews() {
        inputNumberTextInput = findViewById(R.id.editTextInputNumber)
        resultTextView = findViewById(R.id.textViewResult)
        convertFromTextView = findViewById(R.id.textViewPopupMenuConvertFrom)
        convertToTextView = findViewById(R.id.textViewPopupMenuConvertTo)
        deleteButton = findViewById(R.id.button_delete)
        convertButton = findViewById(R.id.button_convert)
    }

    private fun setUpClickListeners() {
        setupThemes()
        setupGridLayoutNumbers()
        setupDeleteButtons()
        setupConversionStates()
    }


    private fun setupThemes() {
        findViewById<View>(R.id.img_light_mode).setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            recreate()
        }
        findViewById<View>(R.id.img_dark_mode).setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            recreate()
        }
    }

    private fun setupGridLayoutNumbers() {
        val numberButtons = listOf(
            findViewById<Button>(R.id.button_0),
            findViewById(R.id.button_1),
            findViewById(R.id.button_2),
            findViewById(R.id.button_3),
            findViewById(R.id.button_4),
            findViewById(R.id.button_5),
            findViewById(R.id.button_6),
            findViewById(R.id.button_7),
            findViewById(R.id.button_8),
            findViewById(R.id.button_9),
            findViewById(R.id.button_A),
            findViewById(R.id.button_b),
            findViewById(R.id.button_c),
            findViewById(R.id.button_d),
            findViewById(R.id.button_e),
            findViewById(R.id.button_f)
        )
        numberButtons.forEach { button ->
            button.setOnClickListener {
                inputNumberTextInput.append(button.text)
            }
        }
    }

    private fun setupDeleteButtons() {
        deleteButton.apply {
            setOnClickListener {
                inputNumberTextInput.text?.let { text ->
                    if (text.isNotEmpty()) {
                        text.delete(text.length - 1, text.length)
                    }
                }
            }

            setOnLongClickListener {
                inputNumberTextInput.text?.clear()
                true
            }
        }
    }

    private fun setupConversionStates() {
        convertFromTextView.setOnClickListener { showPopupMenu(it) }
        convertToTextView.setOnClickListener { showPopupMenu(it) }
        convertButton.setOnClickListener { convertNumber() }
    }

    private fun convertNumber() {
        val inputNumber = inputNumberTextInput.text.toString()
        val fromBase = convertFromTextView.text.toString()
        val toBase = convertToTextView.text.toString()

        val result = try {
            val fromRadix = getRadixFromBase(fromBase)
            val toRadix = getRadixFromBase(toBase)
            val decimalNumber = inputNumber.toInt(fromRadix)
            decimalNumber.toString(toRadix)
        } catch (e: NumberFormatException) {
            "Invalid input"
        }

        resultTextView.text = result
    }

    private val baseToRadix = mapOf("Binary" to 2,
    "Octal" to 8,
    "Decimal" to 10,
    "Hexadecimal" to 16)
    


    fun getRadixFromBase(base: String): Int {
        return baseToRadix[base] ?: 0
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(applicationContext, view)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.binary -> {
                    (view as? TextView)?.text = getString(R.string.binary)
                    true
                }
                R.id.octal -> {
                    (view as? TextView)?.text = getString(R.string.octal)
                    true
                }
                R.id.decimal -> {
                    (view as? TextView)?.text = getString(R.string.decimal)
                    true
                }
                R.id.hexadecimal -> {
                    (view as? TextView)?.text = getString(R.string.hexadecimal)
                    true
                }
                else -> false
            }
        }
        popupMenu.inflate(R.menu.menu_conversion_bases)
        popupMenu.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_conversion_bases, menu)
        return true
    }

}
