package com.eimtest.sds.data.model

import com.eimtest.sds.Constants.BASE_URL

data class PlaylistResponse(
    val data: List<PlaylistItem>
)

data class PlaylistItem(
    val id: Int,
    val name: String,
    val bgm: String,
    val image: String
) {
    fun getBgmUrl(): String = BASE_URL + bgm
    fun getImageUrl(): String = BASE_URL + image
}