package com.uvg.laboratorio7retrofitapi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.uvg.laboratorio7retrofitapi.ui.categories.view.CategoriesScreen
import com.uvg.laboratorio7retrofitapi.ui.detailsMeal.view.MealDetailScreen
import com.uvg.laboratorio7retrofitapi.ui.meals.view.mealsScreen

@Composable
fun AppNavigation() {
    val navController= rememberNavController();

    NavHost(navController = navController, startDestination = AppScreens.CategoriesScreen.route){
        composable(route= AppScreens.CategoriesScreen.route){
            CategoriesScreen(navController)
        }

        composable(route= AppScreens.MealDetailScreen.route,
            arguments = listOf(navArgument(name= "category"){
                type= NavType.StringType
            }
            )){backStackEntry->
            val arguments = requireNotNull(backStackEntry.arguments)
            val categoryName= arguments.getString("category") ?:""
            val idCategory= arguments.getString("id") ?:""
            MealDetailScreen(navController = navController, name = categoryName, id = idCategory )
        }

        composable(route= AppScreens.MealsScreen.route,
            arguments = listOf(navArgument(name= "idFilter"){
                type= NavType.StringType
            }
            )){backStackEntry->
            val arguments = requireNotNull(backStackEntry.arguments)
            val idFilter= arguments.getString("idFilter") ?:""
            mealsScreen(navController = navController, id = idFilter )
        }
    }
}