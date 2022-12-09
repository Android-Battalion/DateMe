package com.androiders.dateme.features.ui.screens.onboarding.Provider

import com.androiders.dateme.features.ui.screens.onboarding.Model.OnBoardingUiModel

object OnBoardingPagesProvider {

    operator fun invoke() = pages

    private val pages: List<OnBoardingUiModel>
        get() = mutableListOf<OnBoardingUiModel>().apply {
            val onBoardingPages = listOf(page1, page2, page3)
            addAll(onBoardingPages)
        }
}
