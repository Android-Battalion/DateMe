package com.androiders.dateme.features.onboarding.ui.screen

import androidx.annotation.FloatRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androiders.dateme.R
import com.androiders.dateme.core.theme.BottomCardShape
import com.androiders.dateme.core.theme.CardBack
import com.androiders.dateme.core.theme.ColorBlue
import com.androiders.dateme.core.theme.ColorDarkRed
import com.androiders.dateme.core.theme.DateMeTheme
import com.androiders.dateme.core.theme.PoppinsFam
import com.androiders.dateme.features.ui.screens.onboarding.Model.OnBoardingUiModel
import com.androiders.dateme.features.ui.screens.onboarding.Provider.OnBoardingPagesProvider
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen() {

    val onBoardingPages = OnBoardingPagesProvider()

    val pagerState = rememberPagerState(
        pageCount = onBoardingPages.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0,
    )

    OnBoardingPager(
        item = onBoardingPages, pagerState = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorBlue)
    )
}

@ExperimentalPagerApi
@Composable
fun OnBoardingPager(
    item: List<OnBoardingUiModel>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {

    val coroutineScope = rememberCoroutineScope()

    Box(modifier = modifier) {
        Column {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = item[page].image),
                        contentDescription = item[page].title,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillHeight
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(340.dp)
                    .clip(RoundedCornerShape(topStart = 150.dp)),
                backgroundColor = CardBack,
                elevation = 0.dp,
                shape = BottomCardShape.small
            ) {
                Box {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        PagerIndicator(items = item, currentPage = pagerState.currentPage)
                        Text(
                            text = item[pagerState.currentPage].title,
                            color = item[pagerState.currentPage].mainColor,
                            fontFamily = PoppinsFam,
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = item[pagerState.currentPage].desc,
                            modifier = Modifier.padding(top = 20.dp, start = 40.dp, end = 20.dp),
                            color = MaterialTheme.colors.onSurface,
                            fontFamily = MaterialTheme.typography.body1.fontFamily,
                            fontSize = 17.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Light,
                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(30.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            if (pagerState.currentPage != OnBoardingPagesProvider().size - 1) {
                                TextButton(onClick = {
                                    // skip
                                }) {
                                    Text(
                                        text = "Skip Now",
                                        style = TextStyle(
                                            // fontSize = 24.sp,
                                            shadow = Shadow(
                                                color = Color.Black,
                                                // offset = offset,
                                                blurRadius = 0.2f
                                            )
                                        ),
                                        color = ColorDarkRed,
                                        fontFamily = PoppinsFam,
                                        textAlign = TextAlign.Right,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }

                                OutlinedButton(
                                    onClick = {
                                        coroutineScope.launch {
                                            pagerState.scrollToPage(
                                                pagerState.currentPage + 1,
                                                pageOffset = 0f
                                            )
                                        }
                                    },
                                    border = BorderStroke(
                                        14.dp,
                                        item[pagerState.currentPage].mainColor
                                    ),
                                    shape = RoundedCornerShape(50), // = 50% percent
                                    // or shape = CircleShape
                                    colors = ButtonDefaults.outlinedButtonColors(
                                        contentColor =
                                        item[pagerState.currentPage].mainColor
                                    ),
                                    modifier = Modifier.size(65.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_right_arrow),
                                        contentDescription = "",
                                        // tint = item[pagerState.currentPage].backgroundColor,
                                        tint = Color(0xffFFB9BA),
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            } else {
                                Button(
                                    onClick = {
                                        // show home screen
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = item[pagerState.currentPage].mainColor
                                    ),
                                    contentPadding = PaddingValues(vertical = 12.dp),
                                    elevation = ButtonDefaults.elevation(
                                        defaultElevation = 4.dp
                                    )
                                ) {
                                    Text(
                                        text = "Get Started",
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            shadow = Shadow(
                                                color = Color.Black,
                                                // offset = offset,
                                                blurRadius = 1f
                                            )
                                        ),
                                        color = ColorDarkRed,
                                        fontSize = 16.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PagerIndicator(currentPage: Int, items: List<OnBoardingUiModel>) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        repeat(items.size) {
            Indicator(isSelected = it == currentPage, color = items[it].mainColor)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean, color: Color) {
    val width = animateDpAsState(targetValue = if (isSelected) 40.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(4.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) color else Color.Gray.copy(alpha = 0.5f)
            )
    )
}

@ExperimentalPagerApi
@Composable
fun rememberPagerState(
    @androidx.annotation.IntRange(from = 0) pageCount: Int,
    @androidx.annotation.IntRange(from = 0) initialPage: Int = 0,
    @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
    @androidx.annotation.IntRange(from = 1) initialOffscreenLimit: Int = 1,
    infiniteLoop: Boolean = false,
): PagerState = rememberSaveable(saver = PagerState.Saver) {
    PagerState(
        pageCount = pageCount,
        currentPage = initialPage,
        currentPageOffset = initialPageOffset,
        offscreenLimit = initialOffscreenLimit,
        infiniteLoop = infiniteLoop
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DateMeTheme {
        OnBoardingScreen()
    }
}
