package com.androiders.dateme.features.ui.screens.onboarding.Model

import androidx.compose.ui.graphics.Color
import com.androiders.dateme.core.theme.ColorBlue
import com.androiders.dateme.core.theme.ColorDarkRed

data class OnBoardingUiModel(
    val image: Int,
    val title: String,
    val desc: String,
    val backgroundColor: Color,
    val mainColor: Color = ColorBlue,
    val TextColorFromTheme: Color = ColorDarkRed
)
