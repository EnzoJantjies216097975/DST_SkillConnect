package com.dst511s.dst_skillconnect.unsorted.data

data class CertificateInfo(
    val title: String,
    val issuer: String,
    val isAccredited: Boolean,
    val validityPeriod: Int?, // in months
    val requirements: List<String>
)
