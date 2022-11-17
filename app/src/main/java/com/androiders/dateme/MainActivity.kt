package com.androiders.dateme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androiders.dateme.ui.theme.DateMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DateMeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    OldStephaneFunc()
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
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



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DateMeTheme {
        OldStephaneFunc()
    }
}
