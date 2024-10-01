package com.uvg.laboratorio7retrofitapi.ui.meals.repository

import com.uvg.laboratorio7retrofitapi.networking.MealWebService
import com.uvg.laboratorio7retrofitapi.networking.datac.MealDC

class MealsRepository(private val webService: MealWebService = MealWebService()) {
    suspend fun getMeals(): MealDC {
        return webService.getLookUp()
    }
}