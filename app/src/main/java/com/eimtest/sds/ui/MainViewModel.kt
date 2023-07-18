package com.eimtest.sds.ui

import android.media.MediaPlayer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eimtest.sds.data.model.PlaylistItem
import com.eimtest.sds.domain.usecase.GetPlaylist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPlaylist: GetPlaylist
) : ViewModel() {

    val currentTrack = MutableLiveData<PlaylistItem>()

    private val _playlists = MutableLiveData<List<PlaylistItem>>()
    val playlists: LiveData<List<PlaylistItem>> = _playlists

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private var mediaPlayer: MediaPlayer? = null
    private var currentTrackIndex = 0

    init {
        fetchPlaylists()
    }

    private fun fetchPlaylists() {
        viewModelScope.launch {
            when (val result = getPlaylist.execute()) {
                is GetPlaylist.Result.Success -> {
                    _isLoading.postValue(false)
                    _playlists.postValue(result.playlists)
                }

                is GetPlaylist.Result.Failure -> {
                    _isLoading.postValue(false)
                    _error.postValue(result.error ?: "Something Went Wrong")
                }

                is GetPlaylist.Result.Loading -> {
                    _isLoading.postValue(true)
                }
            }
        }
    }

    fun playTrack(trackIndex: Int) {
        currentTrackIndex = trackIndex
        val track = playlists.value?.get(trackIndex) ?: return

        mediaPlayer?.release()
        mediaPlayer = MediaPlayer().apply {
            setDataSource(track.getBgmUrl())
            prepare()
            setOnCompletionListener {
                playNextTrack()
            }
            start()
        }

        currentTrack.postValue(track)
    }

    fun playNextTrack() {
        if (currentTrackIndex + 1 < (playlists.value?.size ?: 0)) {
            playTrack(currentTrackIndex + 1)
        } else {
            playTrack(0)
        }
    }

    fun playPreviousTrack() {
        if (currentTrackIndex > 0) {
            playTrack(currentTrackIndex - 1)
        } else {
            playTrack((playlists.value?.size ?: 1) - 1)
        }
    }

    override fun onCleared() {
        super.onCleared()
        mediaPlayer?.release()
    }
}
