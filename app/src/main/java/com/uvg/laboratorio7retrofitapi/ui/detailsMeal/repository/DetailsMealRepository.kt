package com.uvg.laboratorio7retrofitapi.ui.detailsMeal.repository

import com.uvg.laboratorio7retrofitapi.networking.MealWebService
import com.uvg.laboratorio7retrofitapi.networking.datac.DetailsMealsDC

class DetailsMealRepository(private val webService: MealWebService = MealWebService()) {
    suspend fun getMealsDetails(): DetailsMealsDC{
        return webService.getMealsFilter()
    }
}