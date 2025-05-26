package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.InterviewCategory

data class InterviewTip(
    val id: String,
    val title: String,
    val content: String,
    val category: InterviewCategory,
    val icon: String
)