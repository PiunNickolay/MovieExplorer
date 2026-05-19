package com.example.movieexplorer.presentation.mainScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movieexplorer.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Singleton


@AndroidEntryPoint
class MainFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
}