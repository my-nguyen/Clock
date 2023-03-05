package com.theandroidfactory.clock

import android.os.Bundle
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.theandroidfactory.clock.databinding.ActivityMainBinding
import com.theandroidfactory.clock.databinding.DigitBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by lazy {
        ViewModelProvider(this)[MyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.digitLeft.digit.observe(this) {
            setupLayout(binding.digitLeft, it)
        }
        viewModel.digitRight.digit.observe(this) {
            setupLayout(binding.digitRight, it)
        }
        viewModel.startCounting()
    }

    private fun setupLayout(binding: DigitBinding, map: Map<Int, Int>) {
        styleCard(binding.segmentTop.root, map[R.id.segmentTop]!!)
        styleCard(binding.segmentTopLeft.root, map[R.id.segmentTopLeft]!!)
        styleCard(binding.segmentTopRight.root, map[R.id.segmentTopRight]!!)
        styleCard(binding.segmentMiddle.root, map[R.id.segmentMiddle]!!)
        styleCard(binding.segmentBottomLeft.root, map[R.id.segmentBottomLeft]!!)
        styleCard(binding.segmentBottomRight.root, map[R.id.segmentBottomRight]!!)
        styleCard(binding.segmentBottom.root, map[R.id.segmentBottom]!!)
    }

    private fun styleCard(cardView: CardView, @ColorRes colorRes: Int) {
        cardView.setCardBackgroundColor(ContextCompat.getColor(this, colorRes))
    }
}