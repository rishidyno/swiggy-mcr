package com.project.rishi.assignment.swiggyassignment.data.remote

import com.example.example.MovieResponse
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

@Inject
class MovieRepoImpl(
    private val omdbApiService: OmdbApiService
):MovieRepo {
    override suspend fun getMoviesBySeaarchQueryPage(searchQuery: String, pageNumber: Long):NetworkResult<MovieResponse> {
        val movieResponse= handleApi {  }
    }

    suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): NetworkResult<T> {
        return try {
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                NetworkResult.Success(body)
            } else {
                NetworkResult.Error(code = response.code(), message = response.message())
            }
        } catch (e: HttpException) {
            NetworkResult.Error(code = e.code(), message = e.message())
        } catch (e: Throwable) {
            NetworkResult.Exception(e)
        }
    }
}