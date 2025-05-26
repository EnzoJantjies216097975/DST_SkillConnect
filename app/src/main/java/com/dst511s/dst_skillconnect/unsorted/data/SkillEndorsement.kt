package com.dst511s.dst_skillconnect.unsorted.data

data class SkillEndorsement(
    val endorserId: String,
    val endorserName: String,
    val endorserTitle: String?,
    val message: String?,
    val timestamp: Long
)