package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.PriceType

data class PathPrice(
    val type: PriceType,
    val amount: Double,
    val currency: String,
    val originalPrice: Double?,
    val discount: Int?
)