package com.dst511s.dst_skillconnect.unsorted.data

data class MessageAttachment(
    val id: String,
    val url: String,
    val fileName: String,
    val fileSize: Long,
    val mimeType: String,
    val thumbnailUrl: String? = null
)