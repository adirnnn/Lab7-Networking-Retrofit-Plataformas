package com.uvg.laboratorio7retrofitapi.ui.meals.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.laboratorio7retrofitapi.networking.datac.MealX
import com.uvg.laboratorio7retrofitapi.ui.meals.repository.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsViewModel(
    private val repository: MealsRepository= MealsRepository()
):ViewModel() {

    val mealsState: MutableState<List<MealX>> = mutableStateOf(emptyList<MealX>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value= meals

        }
    }

    private suspend fun getMeals(): List<MealX>{
        return repository.getMeals().meals
    }
}