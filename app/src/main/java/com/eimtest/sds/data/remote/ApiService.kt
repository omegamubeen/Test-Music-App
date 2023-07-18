package com.eimtest.sds.data.remote

import com.eimtest.sds.Constants
import com.eimtest.sds.data.model.PlaylistResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.API_PLAYLIST)
    suspend fun getPlaylists(): Response<PlaylistResponse>
}