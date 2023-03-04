package com.theandroidfactory.clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
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
        viewModel.liveSegment.observe(this) {
            binding.segment.root.apply {
                setBackgroundColor(ContextCompat.getColor(context, it))
            }
        }
    }

    private fun getRandomString() = Random().nextInt(100).toString()
}