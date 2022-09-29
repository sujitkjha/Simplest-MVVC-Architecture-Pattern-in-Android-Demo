package com.sujitjha.mvvmdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import com.sujitjha.mvvmdemo.R
import com.sujitjha.mvvmdemo.databinding.ActivityMainBinding
import com.sujitjha.mvvmdemo.model.City
import com.sujitjha.mvvmdemo.viewmodel.CityViewModel

class MainActivity : AppCompatActivity() {
    private val cityModel :CityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()

        cityModel.getCityData().observe(this, Observer { city ->
            binding.cityImage.setImageDrawable(ResourcesCompat.getDrawable(resources,city.image,applicationContext.theme))
            binding.cityNameTV.text =city.name
            binding.cityPopulationTV.text =city.population.toString()
        })

    }
}