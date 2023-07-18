package com.eimtest.sds.data.repo

import com.eimtest.sds.data.model.PlaylistResponse
import retrofit2.Response

interface Repository {
    suspend fun getPlaylists(): Response<PlaylistResponse>
}