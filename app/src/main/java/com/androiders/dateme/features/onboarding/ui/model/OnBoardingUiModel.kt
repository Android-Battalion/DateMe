package com.androiders.dateme.features.onboarding.ui.model

import androidx.compose.ui.graphics.Color
import com.androiders.dateme.core.theme.ColorBlue

data class OnBoardingUiModel(
    val image: Int,
    val title: Int,
    val desc: Int,
    val backgroundColor: Color,
    val mainColor: Color = ColorBlue,
)
