package com.uvg.laboratorio7retrofitapi.navigation

sealed class AppScreens(val route: String){
    object CategoriesScreen: AppScreens("primera")

    object MealDetailScreen: AppScreens("segunda/{category}/{id}"){
        fun createRoute(category: String, id: String) = "segunda/$category/$id"
    }

    object MealsScreen: AppScreens("cuarta/{idFilter}"){
        fun createRoute(id: String) = "cuarta/$id"
    }
}