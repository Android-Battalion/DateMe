package com.androiders.dateme

import androidx.compose.ui.graphics.Color
import com.androiders.dateme.core.ui.theme.ColorBlue

data class OnBoardingUiModel(
    val image: Int,
    val title: String,
    val desc: String,
    val backgroundColor: Color,
    val mainColor: Color = ColorBlue,
)
