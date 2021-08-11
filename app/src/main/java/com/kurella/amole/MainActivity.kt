package com.kurella.amole

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kurella.amole.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.winStateLD.observe(this, {
            if (it) {
                binding.imageView.visibility = View.VISIBLE
            }
        })

        viewModel.activeButtonLD.observe(this, {
            when (it.first) {
                0 -> updateButtonColor(binding.button, R.color.black)
                1 -> updateButtonColor(binding.button2, R.color.black)
                2 -> updateButtonColor(binding.button3, R.color.black)
                3 -> updateButtonColor(binding.button10, R.color.black)
                4 -> updateButtonColor(binding.button11, R.color.black)
                5 -> updateButtonColor(binding.button12, R.color.black)
                6 -> updateButtonColor(binding.button13, R.color.black)
                7 -> updateButtonColor(binding.button14, R.color.black)
                8 -> updateButtonColor(binding.button15, R.color.black)
            }

            when (it.second) {
                0 -> updateButtonColor(binding.button, R.color.red)
                1 -> updateButtonColor(binding.button2, R.color.red)
                2 -> updateButtonColor(binding.button3, R.color.red)
                3 -> updateButtonColor(binding.button10, R.color.red)
                4 -> updateButtonColor(binding.button11, R.color.red)
                5 -> updateButtonColor(binding.button12, R.color.red)
                6 -> updateButtonColor(binding.button13, R.color.red)
                7 -> updateButtonColor(binding.button14, R.color.red)
                8 -> updateButtonColor(binding.button15, R.color.red)
            }
        })

        binding.button.setOnClickListener {
            viewModel.onButtonClick(0)
        }
        binding.button2.setOnClickListener {
            viewModel.onButtonClick(1)
        }
        binding.button3.setOnClickListener {
            viewModel.onButtonClick(2)
        }
        binding.button10.setOnClickListener {
            viewModel.onButtonClick(3)
        }
        binding.button11.setOnClickListener {
            viewModel.onButtonClick(4)
        }
        binding.button12.setOnClickListener {
            viewModel.onButtonClick(5)
        }
        binding.button13.setOnClickListener {
            viewModel.onButtonClick(6)
        }
        binding.button14.setOnClickListener {
            viewModel.onButtonClick(7)
        }
        binding.button15.setOnClickListener {
            viewModel.onButtonClick(8)
        }
        binding.imageView.setOnClickListener {
            viewModel.reset()
            binding.imageView.visibility = View.GONE
        }

        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                viewModel.level.value = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }

    private fun updateButtonColor(button: Button, color: Int) {
        button.setBackgroundColor(this.getColor(color))
    }


}