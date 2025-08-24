package com.sourashis.movieapp.details.presentation

import com.sourashis.movieapp.movieList.domain.model.Movie

data class DetailsState(
    val isLoading: Boolean = false,
    val movie: Movie? = null
)