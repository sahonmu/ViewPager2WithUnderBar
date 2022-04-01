package com.burger.palchil.viewpage01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.burger.palchil.viewpage01.databinding.FragmentPageBinding

class PageFragment(private var position: Int): Fragment() {

    private lateinit var binding: FragmentPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_page, container, false)
        binding.number.text = "POSITION = $position"
        return binding.root
    }
}