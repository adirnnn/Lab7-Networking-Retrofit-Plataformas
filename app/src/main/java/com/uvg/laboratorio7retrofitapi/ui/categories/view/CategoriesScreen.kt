package com.uvg.laboratorio7retrofitapi.ui.categories.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.uvg.laboratorio7retrofitapi.navigation.AppScreens
import com.uvg.laboratorio7retrofitapi.ui.categories.viewmodel.CategoryViewModel
import com.uvg.laboratorio7retrofitapi.ui.components.TopBar

@Composable
fun CategoriesScreen(navController: NavHostController) {

    val viewModel: CategoryViewModel= viewModel()
    val categories= viewModel.categoriesState.value

    Column {
        TopBar(navController,"Categories" )

        LazyColumn(modifier = Modifier.fillMaxWidth()){

            categories?.let{
                items(categories){ category->

                    val str: String = category.strCategory
                    val id: String = category.idCategory
                    val description: String = category.strCategoryDescription
                    val thumb: String = category.strCategoryThumb

                    Card(modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(AppScreens.MealDetailScreen.createRoute(str,id)) {
                                launchSingleTop = true
                            }
                        },
                        shape= RoundedCornerShape(6.dp)
                    ){
                        Row {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(thumb)
                                    .transformations()
                                    .size(500,500)
                                    .build()
                                ,
                                contentDescription = "Image"
                            )
                            Column(modifier = Modifier.padding(6.dp)) {
                                Text(text =str,
                                    fontSize = 15.sp,
                                    fontWeight= FontWeight.Bold,
                                    fontStyle = FontStyle.Italic,
                                    color = Color(0xFF00796B),
                                    lineHeight = 20.sp,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Spacer(modifier =Modifier.height(2.dp))
                                Text(text = description,
                                    fontSize = 8.sp,
                                    fontWeight= FontWeight.Bold,
                                    fontStyle = FontStyle.Normal,
                                    lineHeight = 13.sp,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}