package com.androiders.dateme.features.ui.screens.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androiders.dateme.R
import com.androiders.dateme.features.ui.screens.chat.Uidata.User

// Display ChatScreen with preview data
@Preview("Chat screen body")
@Composable
fun ChatScreenPreview() {
    ChatScreen(User(true, "Marc"))
}

@Composable
fun ChatScreen(
    matchedUser: User
) {
    // Check matchedUser online status for status indicator color
    val statusBackgroundColor = if (matchedUser.onlineStatus) Color.Green else Color.White

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /*TODO: back to Chat list*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back_ios_24),
                    contentDescription = "back button",
                    modifier = Modifier.size(30.dp)
                )
            }
            // Matched user info container
            Row(
                modifier = Modifier,
            ) {
                Image( // Matched user profile image
                    painter = painterResource(id = R.drawable.user_profile_1),
                    "matched user profile picture",
                    modifier = Modifier.size(30.dp)
                )
                Text( // Matched user profile name
                    matchedUser.username,
                    fontSize = 20.sp,
                    color = Color.Black,
                )
                Box( // Matched user online status indicator
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(statusBackgroundColor)
                )
            }
            IconButton(onClick = { /*TODO: display chat options*/ }) {
                Icon(
                    painter = painterResource(R.drawable.more_button_icon),
                    "chat options display button",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
        // Chat message display section
        Box(Modifier.weight(1f).fillMaxWidth()
        ) {
            // TODO: fill with message list
        }
        Divider(
            modifier = Modifier
                .height(1.dp)
                .background(Color.LightGray)
        )
        // New message entry section
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /*TODO: open emotes tab*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_emot_24),
                    contentDescription = "emotes drawer",
                    modifier = Modifier.size(30.dp)
                )
            }
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = stringResource(id = R.string.say_something_nice)) }
            )
            IconButton(onClick = { /*TODO: open emotes tab*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_emot_24),
                    contentDescription = "emotes drawer",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}
