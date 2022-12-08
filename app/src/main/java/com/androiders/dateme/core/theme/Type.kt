package com.androiders.dateme.core.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.androiders.dateme.R

// Set of Material typography styles to start with

val PoppinsFam = FontFamily(
    Font(R.font.poppins_bold, weight = FontWeight.Bold)
)
val ReemKufiFam = FontFamily(
    Font(R.font.reem_kufi, weight = FontWeight.Bold)
)

val Typography = Typography(
    defaultFontFamily = PoppinsFam,
    h6 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
