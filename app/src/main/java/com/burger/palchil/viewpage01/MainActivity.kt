package com.burger.palchil.viewpage01

import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.burger.palchil.viewpage01.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val pageAdapter by lazy {
        PagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initPager()
    }

    private fun initPager() {
        binding.viewPager.apply {
            this.adapter = pageAdapter

            val itemCount = pageAdapter.itemCount // page 갯수
            val barWidth = screenWidth() / itemCount // page 갯수에 따라 bar 의 width 값 설정
            val params = RelativeLayout.LayoutParams(barWidth, 30)
            params.addRule(RelativeLayout.ALIGN_BOTTOM)
            binding.bar.apply {
                binding.bar.layoutParams = params
            }

            this.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                    val translatePosition = barWidth * position // bar 의 시작 포지션 위치
                    val translateOffset = barWidth * positionOffset // page 의 offset 만큼 이동
                    binding.bar.translationX = translatePosition + translateOffset
                }
            })
        }
    }

    private fun screenWidth(): Int {
        val display = windowManager.defaultDisplay
        val displayMetrics = DisplayMetrics()
        display?.getRealMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }
}


