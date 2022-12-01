package com.androiders.dateme.features.utils

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import java.util.*

@SuppressLint("SimpleDateFormat")
@Composable
fun DisplayClock() {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Current date and time in Android\n", fontSize = 25.sp)
        val sdf = SimpleDateFormat("'Date: 'MM-dd-yyyy'\nand\nTime: 'HH:mm:ss z")
        val currentDateAndTime = sdf.format(Date())
        Text(
            text = currentDateAndTime,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 25.sp
        )
    }
}
