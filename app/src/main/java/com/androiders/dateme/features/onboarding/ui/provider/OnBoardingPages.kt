package com.androiders.dateme.features.onboarding.ui.provider

import androidx.compose.ui.graphics.Color
import com.androiders.dateme.R
import com.androiders.dateme.features.onboarding.ui.model.OnBoardingUiModel

// TODO : Refactor this to use `stringResources`
val page1 = OnBoardingUiModel(
    R.drawable.coupleballoon1080w,
    R.string.welcome_title,
    R.string.welcome_desc,
    backgroundColor = Color(0xFF0189C5),
    mainColor = Color.White
)
val page2 = OnBoardingUiModel(
    R.drawable.ballonpair1080w,
    R.string.discover_title,
    R.string.discover_desc,
    backgroundColor = Color(0xFFE4AF19),
    mainColor = Color.White
)
val page3 = OnBoardingUiModel(
    R.drawable.couplefall1080w,
    R.string.get_started_title,
    R.string.get_started_desc,
    backgroundColor = Color(0xFF96E172),
    mainColor = Color.White
)
