package com.uvg.laboratorio7retrofitapi.ui.categories.repository

import com.uvg.laboratorio7retrofitapi.networking.MealWebService
import com.uvg.laboratorio7retrofitapi.networking.datac.CategoriesDC

class CategoryRepository(private val webService: MealWebService= MealWebService()) {

    suspend fun getCategories(): CategoriesDC {
        return webService.getMealsCategories()
    }
}