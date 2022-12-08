package com.androiders.dateme.features.ui.screens.pages

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androiders.dateme.core.theme.DateMeTheme

@Composable
fun TestPage() {
    // page background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        // vertical composition
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // top app bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(5f)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = null
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Rounded.Favorite,
                    contentDescription = null
                )
                Spacer(Modifier.width(5.dp))
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null
                )
            }
            // first body block
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(35f)
                    .background(Color.White),
                horizontalArrangement = Arrangement.Center
            ) {
            }
            // second body block
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(35f)
                    .background(Color.Green),
                horizontalArrangement = Arrangement.Center
            ) {
            }
            // additional components block
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(10f)
                    .background(Color.Blue),
                horizontalArrangement = Arrangement.Center
            ) {
            }
            // bottom sys nav bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(5f)
                    .background(Color.Yellow),
                horizontalArrangement = Arrangement.Center
            ) {
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TestPagePreview() {
    DateMeTheme {
        TestPage()
    }
}
