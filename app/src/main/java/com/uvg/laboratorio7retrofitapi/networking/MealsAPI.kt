package com.uvg.laboratorio7retrofitapi.networking

import com.uvg.laboratorio7retrofitapi.networking.datac.CategoriesDC
import com.uvg.laboratorio7retrofitapi.networking.datac.DetailsMealsDC
import com.uvg.laboratorio7retrofitapi.networking.datac.MealDC
import retrofit2.http.GET

interface MealsApi {

    @GET("categories.php")
    suspend fun getCategories(): CategoriesDC

    @GET("filter.php?c=Seafood")
    suspend fun getFilter(): DetailsMealsDC

    @GET("lookup.php?i=52944")
    suspend fun getLookup(): MealDC

}


