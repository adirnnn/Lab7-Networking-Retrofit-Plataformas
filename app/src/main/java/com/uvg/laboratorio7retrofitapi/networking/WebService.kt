package com.uvg.laboratorio7retrofitapi.networking

import com.uvg.laboratorio7retrofitapi.networking.datac.CategoriesDC
import com.uvg.laboratorio7retrofitapi.networking.datac.DetailsMealsDC
import com.uvg.laboratorio7retrofitapi.networking.datac.MealDC
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealWebService {
    private var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getMealsCategories():CategoriesDC{
        return api.getCategories()
    }

    suspend fun getMealsFilter():DetailsMealsDC{
        return api.getFilter()
    }

    suspend fun getLookUp(): MealDC {
        return api.getLookup()
    }
}