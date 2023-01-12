package com.example.appwithbaha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.appwithbaha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ActivityMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ActivityMainViewModel::class.java]
        viewModel.init()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getCount()?.observe(this
        ) { t -> binding.tvCount.text = t?.getCount().toString() }
        fromViewModel()
    }


    private fun fromViewModel() {
        binding.btnDecrement.setOnClickListener{
            viewModel.decrementCount()
        }
        binding.btnIncrement.setOnClickListener{
            viewModel.incrementCount()
        }
    }




}