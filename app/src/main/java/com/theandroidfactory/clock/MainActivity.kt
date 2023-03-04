package com.theandroidfactory.clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.theandroidfactory.clock.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by lazy {
        ViewModelProvider(this)[MyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            viewModel.onButtonClicked()
        }
        viewModel.liveInfo.observe(this) {
            binding.text.apply {
                text = it.text
                rotation = it.rotation.toFloat()
                setBackgroundColor(it.backgroundColor)
            }
        }
    }

    private fun getRandomString() = Random().nextInt(100).toString()
}