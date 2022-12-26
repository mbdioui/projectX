package fr.leboncoin.projectx.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import fr.leboncoin.projectx.models.Track
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://static.leboncoin.fr/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

interface TrackApiService {
    @GET("img/shared/technical-test.json")
    suspend fun getTracks(): List<Track>
}

fun tracksApi(): TrackApiService {
    return Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build().create(TrackApiService::class.java)
}