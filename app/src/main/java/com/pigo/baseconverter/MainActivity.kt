package com.pigo.baseconverter

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.pigo.baseconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupStatusBar()
        setupThemeButtonsClickListener()
        setupNumberButtonsClickListener()
        setupDeleteButtonClickListener()
        setupConversionViewsClickListener()
    }

    private fun setupStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    private fun setupThemeButtonsClickListener() {
        binding.imgLightMode.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            recreate()
        }
        binding.imgDarkMode.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            recreate()
        }
    }

    private fun setupNumberButtonsClickListener() {
        val numberButtons = listOf(
            binding.button0,
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9,
            binding.buttonA,
            binding.buttonB,
            binding.buttonC,
            binding.buttonD,
            binding.buttonE,
            binding.buttonF
        )
        numberButtons.forEach { button ->
            button.setOnClickListener {
                binding.editTextInputNumber.append(button.text)
            }
        }
    }

    private fun setupDeleteButtonClickListener() {
        binding.buttonDelete.apply {
            setOnClickListener {
                binding.editTextInputNumber.text?.let { text ->
                    if (text.isNotEmpty()) {
                        text.delete(text.length - 1, text.length)
                    }
                }
            }

            setOnLongClickListener {
                binding.editTextInputNumber.text?.clear()
                true
            }
        }
    }

    private fun setupConversionViewsClickListener() {
        binding.testTextView.setOnClickListener { showPopupMenu(it) }
        binding.testTextView2.setOnClickListener { showPopupMenu(it) }
        binding.buttonConvert.setOnClickListener { convertNumber() }
    }

    private fun convertNumber() {
        val inputNumber = binding.editTextInputNumber.text.toString()
        val fromBase = binding.testTextView.text.toString()
        val toBase = binding.testTextView2.text.toString()

        val result = try {
            val fromRadix = getRadixFromBase(fromBase)
            val toRadix = getRadixFromBase(toBase)
            val decimalNumber = inputNumber.toInt(fromRadix)
            decimalNumber.toString(toRadix)
        } catch (e: NumberFormatException) {
            "Invalid input"
        }

        binding.textViewResult.text = result
    }

    private fun getRadixFromBase(base: String): Int {
        return when (base) {
            "Binary" -> 2
            "Octal" -> 8
            "Decimal" -> 10
            "Hexadecimal" -> 16
            else -> {
                "Invalid Base".also { binding.textViewResult.text = it }
                2
            }
        }
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