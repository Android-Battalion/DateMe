package com.androiders.dateme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.FloatRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androiders.dateme.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class, DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DateMeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // onboarding component
                    val items = ArrayList<OnBoardingData>()

                    items.add(
                        OnBoardingData(
                            R.drawable.fruit,
                            "Hmmm, Healthy Food",
                            "A variety of healthy foods made by the best chefs. Ingredients are easy to find. all delicious flavors can only be found at cookbunda",
                            backgroundColor = Color(0xFF0189C5),
                            mainColor = Color(0xFF00B5EA)
                        )
                    )

                    items.add(
                        OnBoardingData(
                            R.drawable.food,
                            "Fresh Drinks, Stay Fresh",
                            "Not only food. we provide clear healthy drink options for you. Fresh taste always accompanies you",
                            backgroundColor = Color(0xFFE4AF19),
                            mainColor = ColorYellow
                        )
                    )

                    items.add(
                        OnBoardingData(
                            R.drawable.cookingcrop,
                            "Let’s Cooking",
                            "Are you ready to make a dish for your friends or family? create an account and cook",
                            backgroundColor = Color(0xFF96E172),
                            mainColor = ColorGreen
                        )
                    )

                    val pagerState = rememberPagerState(
                        pageCount = items.size,
                        initialOffscreenLimit = 2,
                        infiniteLoop = false,
                        initialPage = 0,
                    )

                    OnBoardingPager(
                        item = items, pagerState = pagerState, modifier = Modifier
                            .fillMaxWidth()
                            .background(color = ColorBlue)
                    )



                    //OldStephaneFunc()
                }
            }
        }
    }
}

@DelicateCoroutinesApi
@ExperimentalPagerApi
@Composable
fun OnBoardingPager(
    item: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(item[page].backgroundColor),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {

                    Image(
                        painter = painterResource(
                            id = item[page].image),
                        contentDescription = item[page].title,
                        modifier = Modifier
                            .fillMaxWidth()
                    )


                }
            }

        }

        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(340.dp),
                backgroundColor = Color.White,
                elevation = 0.dp,
                shape = BottomCardShape.large
            ) {
                Box() {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        PagerIndicator(items = item, currentPage = pagerState.currentPage)
                        Text(
                            text = item[pagerState.currentPage].title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, end = 30.dp),
//                            color = Color(0xFF292D32),
                            color = item[pagerState.currentPage].mainColor,
                            fontFamily = PoppinsFam,
                            textAlign = TextAlign.Right,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = item[pagerState.currentPage].desc,
                            modifier = Modifier.padding(top = 20.dp, start = 40.dp, end = 20.dp),
                            color = Color.Gray,
                            fontFamily = PoppinsFam,
                            fontSize = 17.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraLight
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


                            if (pagerState.currentPage != 2) {
                                TextButton(onClick = {
                                    //skip
                                }) {
                                    Text(
                                        text = "Skip Now",
                                        color = Color(0xFF292D32),
                                        fontFamily = PoppinsFam,
                                        textAlign = TextAlign.Right,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }

                                OutlinedButton(
                                    onClick = {
                                        GlobalScope.launch {
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
                                    //or shape = CircleShape
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = item[pagerState.currentPage].mainColor),
                                    modifier = Modifier.size(65.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_right_arrow),
                                        contentDescription = "",
                                        tint = item[pagerState.currentPage].mainColor,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            } else {
                                Button(
                                    onClick = {
                                        //show home screen
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = item[pagerState.currentPage].mainColor
                                    ),
                                    contentPadding = PaddingValues(vertical = 12.dp),
                                    elevation = ButtonDefaults.elevation(
                                        defaultElevation = 0.dp
                                    )
                                ) {
                                    Text(
                                        text = "Get Started",
                                        color = Color.White,
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
fun OldStephaneFunc() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        //contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(440.dp)
                .padding(35.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {

            }
            Button(
                modifier = Modifier
                    .width(380.dp)
                ,
                onClick = {},
                shape = RoundedCornerShape(50),
//                contentPadding = PaddingValues(
//                    start = 0.dp,
//                    top = 12.dp,
//                    end = 20.dp,
//                    bottom = 12.dp,
//                )
                ) {
                // Inner content including an icon and a text label
                Box(modifier = Modifier.padding(5.dp),
                    ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logo_z_tran_white),
                        contentDescription = "Favorite",
                        modifier = Modifier
                            .size(45.dp)
                    )
                    Text(text = "Log in with Username or Email",
                        fontFamily = PoppinsFam,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        textAlign = TextAlign.End

                    )

                }
            }

            Spacer(modifier = Modifier
                .size(20.dp)
            )

            Button(
                modifier = Modifier
                    .width(380.dp)
                ,
                onClick = {},
                shape = RoundedCornerShape(50),
            ) {
                // Inner content including an icon and a text label
                Row(modifier = Modifier
                    .padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logo_z_tran_white),
                        contentDescription = "Favorite",
                        modifier = Modifier
                            .size(45.dp)
                    )
                    Text(text = "Create New Account",
                        fontFamily = PoppinsFam,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 25.dp),
                        textAlign = TextAlign.End

                    )
                }
            }
            Text(
                text = "Having trouble logging in?",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier
                    .clickable {}
                    .padding(25.dp),
                textAlign = TextAlign.Center
            )
        } // Start of page column
    }
}

@Composable
fun PagerIndicator(currentPage: Int, items: List<OnBoardingData>) {
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
    infiniteLoop: Boolean = false
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
        //OldStephaneFunc()
    }
}
