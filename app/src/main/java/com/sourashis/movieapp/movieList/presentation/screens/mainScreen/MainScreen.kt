package com.sourashis.movieapp.movieList.presentation.screens.mainScreen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sourashis.movieapp.movieList.data.local.categories.Category
import com.sourashis.movieapp.movieList.presentation.components.CategoryChip

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {

    var searchQuery by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf<Category?>(null) }
    val categories = remember {
        listOf(
            Category(1, "All"),
            Category(2, "Action"),
            Category(3, "Comedy"),
            Category(4, "Drama"),
            Category(5, "Horror"),
            Category(6, "Sci-Fi"),
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {

        // search bar
        SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            onSearch = {
                active = false
            },
            active = active,
            onActiveChange = { active = it },
            modifier = Modifier,
            placeholder = {
                Text(
                    text = "Search movies, shows ...",
                    fontFamily = FontFamily.Monospace
                )
            },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
            content = {
                if (searchQuery.isNotEmpty()) {
                    Text("Searching for $searchQuery...", fontFamily = FontFamily.Monospace)
                } else {
                    Text("Type to search.", fontFamily = FontFamily.Monospace)
                }
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Categories",
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow {
            items(categories.size) { index ->
                val currentCategory = categories[index]
                CategoryChip(
                    category = currentCategory,
                    isSelected = currentCategory == selectedCategory,
                    onSelect = { clickedCategory ->
                        selectedCategory =
                            if (selectedCategory == clickedCategory) {
                                null
                            } else {
                                clickedCategory
                            }
                        Log.d("category", "Category selected: ${clickedCategory.name}")
                    }
                )
            }
        }
    }
}