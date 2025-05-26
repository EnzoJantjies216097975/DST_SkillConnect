package com.dst511s.dst_skillconnect.data.models

data class CompanyLocation(
    val city: String,
    val country: String,
    val address: String,
    val isHeadquarters: Boolean,
    val employeeCount: Int
)