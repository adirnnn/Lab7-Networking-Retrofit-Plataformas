package com.uvg.laboratorio7retrofitapi.ui.detailsMeal.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.laboratorio7retrofitapi.networking.datac.Meal
import com.uvg.laboratorio7retrofitapi.ui.detailsMeal.repository.DetailsMealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealDetailViewModel (
    private val repository: DetailsMealRepository = DetailsMealRepository()

):ViewModel(){
    val MealDetailState: MutableState<List<Meal>> = mutableStateOf(emptyList<Meal>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val mealsDetails = getFilters()
            MealDetailState.value = mealsDetails
        }
    }

    private suspend fun getFilters(): List<Meal>{
        return repository.getMealsDetails().meals
    }
}