package com.theandroidfactory.clock

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.theandroidfactory.clock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by lazy {
        ViewModelProvider(this)[MyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindData(viewModel.segmentTop, binding.segmentTop.root)
        bindData(viewModel.segmentTopLeft, binding.segmentTopLeft.root)
        bindData(viewModel.segmentTopRight, binding.segmentTopRight.root)
        bindData(viewModel.segmentMiddle, binding.segmentMiddle.root)
        bindData(viewModel.segmentBottomLeft, binding.segmentBottomLeft.root)
        bindData(viewModel.segmentBottomRight, binding.segmentBottomRight.root)
        bindData(viewModel.segmentBottom, binding.segmentBottom.root)

        viewModel.startCounting()
    }

    private fun bindData(data: LiveData<Int>, cardView: CardView) {
        data.observe(this) {
            cardView.setBackgroundColor(ContextCompat.getColor(this, it))
        }
    }
}