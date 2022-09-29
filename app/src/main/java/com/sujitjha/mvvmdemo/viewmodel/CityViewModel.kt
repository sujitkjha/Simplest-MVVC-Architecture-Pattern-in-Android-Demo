package com.sujitjha.mvvmdemo.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sujitjha.mvvmdemo.model.City
import com.sujitjha.mvvmdemo.model.CityDataProvider


class CityViewModel :ViewModel() {



    private val cityData = MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()
    private var currentIndex = 0
    private val delay = 2000L

    fun getCityData() :LiveData<City> =cityData

    init {
        loop()
    }

    private fun loop(){
        Handler(Looper.getMainLooper()).postDelayed({

            updateCity()
        },delay);

    }

private fun updateCity(){
    currentIndex++
    currentIndex %=cities.size
    cityData.value = cities[currentIndex]
    loop()



}

}