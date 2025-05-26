package com.dst511s.dst_skillconnect.unsorted.data

import com.dst511s.dst_skillconnect.unsorted.enume.LayoutStyle

data class PortfolioTheme(
    val primaryColor: String,
    val secondaryColor: String,
    val backgroundColor: String,
    val textColor: String,
    val fontFamily: String,
    val layout: LayoutStyle
)