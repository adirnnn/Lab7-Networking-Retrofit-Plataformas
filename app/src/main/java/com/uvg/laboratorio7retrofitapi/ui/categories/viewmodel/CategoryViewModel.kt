package com.uvg.laboratorio7retrofitapi.ui.categories.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.laboratorio7retrofitapi.networking.datac.Category
import com.uvg.laboratorio7retrofitapi.ui.categories.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel (

    private val repository: CategoryRepository = CategoryRepository()

):ViewModel() {
    val categoriesState: MutableState<List<Category>> = mutableStateOf(emptyList<Category>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getCategories()
            categoriesState.value = meals
        }
    }

    private suspend fun getCategories(): List<Category>{
        return repository.getCategories().categories
    }
}