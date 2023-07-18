package com.eimtest.sds.domain.repo

import com.eimtest.sds.data.repo.Repository
import com.eimtest.sds.data.model.PlaylistResponse
import com.eimtest.sds.data.remote.ApiService
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {

    override suspend fun getPlaylists(): Response<PlaylistResponse> {
        return apiService.getPlaylists()
    }
}