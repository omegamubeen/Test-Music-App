package com.eimtest.sds.domain.usecase

import com.eimtest.sds.data.model.PlaylistItem
import com.eimtest.sds.data.repo.Repository
import javax.inject.Inject

class GetPlaylist @Inject constructor(private val playlistRepository: Repository) {

    sealed class Result {
        data class Success(val playlists: List<PlaylistItem>?) : Result()
        data class Failure(val error: String?) : Result()
        object Loading : Result()
    }

    suspend fun execute(): Result {
        Result.Loading
        return try {
            val response = playlistRepository.getPlaylists()
            if (response.isSuccessful) {
                Result.Success(response.body()?.data)
            } else {
                Result.Failure(response.message())
            }
        } catch (e: Exception) {
            Result.Failure(e.localizedMessage)
        }
    }
}