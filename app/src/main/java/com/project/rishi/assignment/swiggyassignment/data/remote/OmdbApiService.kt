package com.project.rishi.assignment.swiggyassignment.data.remote

import retrofit2.http.Field
import retrofit2.http.GET

interface OmdbApiService {
    @GET("/")
    fun getMoviesByQueryAndPage(@Field("apikey") apiKey: String, @Field("page") pageNumber: Long)
}