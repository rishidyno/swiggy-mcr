package com.project.rishi.assignment.swiggyassignment.data.remote

interface MovieRepo {
    fun getMoviesBySeaarchQueryPage(searchQuery:String, pageNumber:Long):NetworkResult<MovieRepo>
}