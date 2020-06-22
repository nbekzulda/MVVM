package com.example.moviedbapi.data.network


import com.example.moviedbapi.data.models.AccountData
import com.example.moviedbapi.data.models.MovieData
import com.example.moviedbapi.data.models.MovieResponseData
import com.google.gson.JsonObject
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface MovieApi {


    @POST("authentication/token/validate_with_login")
    fun login(@Body body: JsonObject): Deferred<Response<JsonObject>>


    @POST("authentication/session/new")
    fun createSession(@Body body: JsonObject) : Response<JsonObject>

    @GET("authentication/token/new")
    fun createRequestToken(): Single<Response<JsonObject>>


    @GET("account")
    fun getAccountId(@Query("session_id") sessionId: String): Deferred<Response<AccountData>>



    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page: Int) : Response<MovieResponseData>

    @GET("account/{account_id}/favorite/movies")
    fun getFavoriteMovies(
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String,
        @Query("page") page: Int
    ) : Observable<Response<MovieResponseData>>

    @GET("movie/{movie_id}")
    fun getMovie(@Path("movie_id") movieId: Int): Single<Response<MovieData>>


    @POST("account/{account_id}/favorite")
    fun unrateMovie(
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String,
        @Body body: JsonObject
    ) : Deferred<Response<JsonObject>>

    @POST("account/{account_id}/favorite")
    fun rateMovie(
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String,
        @Body body: JsonObject
    ) : Response<JsonObject>
}