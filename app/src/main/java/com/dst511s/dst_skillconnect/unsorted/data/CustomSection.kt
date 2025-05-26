package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.SectionType

data class CustomSection(
    val id: String,
    val title: String,
    val content: String,
    val type: SectionType,
    val order: Int,
    val isVisible: Boolean
)