package com.androiders.dateme.features.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.ExtraBold
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androiders.dateme.R
import com.androiders.dateme.core.theme.CongoPink
import com.androiders.dateme.core.theme.PinkLavender

@Composable
fun LoginScreen() {

    val gradient = Brush.verticalGradient(0.5f to CongoPink, 0.5f to Color.White)

    var emailTextState by remember { mutableStateOf(TextFieldValue()) }
    var passwordTextState by remember { mutableStateOf(TextFieldValue()) }

    var isPasswordVisible by remember { mutableStateOf(false) }

    ScreenContent(
        gradient,
        emailTextState,
        passwordTextState,
        isPasswordVisible,
        { value -> emailTextState = value },
        { value -> passwordTextState = value },
        {
            isPasswordVisible = !isPasswordVisible
        }
    )
}

@Composable
fun ScreenContent(
    gradient: Brush,
    emailTextState: TextFieldValue,
    passwordTextState: TextFieldValue,
    isPasswordVisible: Boolean,
    onEmailTextChange: (value: TextFieldValue) -> Unit,
    onPasswordTextChange: (value: TextFieldValue) -> Unit,
    onPasswordVisibilityChange: () -> Unit,

) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradient),
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.i_date),
                modifier = Modifier.padding(top = 100.dp),
                fontWeight = ExtraBold,
                fontSize = 40.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.padding(top = 50.dp))

            Column(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(30.dp))
                    .width(370.dp)
                    .height(500.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.email),
                    color = Color.Black,
                    modifier = Modifier.padding(top = 30.dp, start = 20.dp, bottom = 5.dp)
                )

                TextField(
                    value = emailTextState,
                    onValueChange = { onEmailTextChange(it) },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(330.dp)
                        .height(50.dp)
                        .border(0.5.dp, PinkLavender, shape = RoundedCornerShape(10.dp)),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                Text(
                    text = stringResource(id = R.string.password),
                    color = Color.Black,
                    modifier = Modifier.padding(top = 30.dp, start = 20.dp, bottom = 5.dp)
                )

                TextField(
                    value = passwordTextState,
                    onValueChange = { onPasswordTextChange(it) },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(330.dp)
                        .height(50.dp)
                        .border(0.5.dp, PinkLavender, shape = RoundedCornerShape(10.dp)),
                    singleLine = true,
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                    trailingIcon = {
                        IconButton(onClick = { onPasswordVisibilityChange() }) {
                            Icon(
                                painter = if (isPasswordVisible) painterResource
                                (id = R.drawable.ic_eye_password_show) else painterResource(
                                    id = R.drawable.ic_eye_password_hide
                                ),
                                contentDescription = stringResource(id = R.string.password_toggle),
                                tint = Color.Black
                            )
                        }
                    }
                )

                TextButton(
                    modifier = Modifier.testTag("forgot_pwd"),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = stringResource(id = R.string.forgot_pwd),
                        modifier = Modifier.padding(top = 5.dp, start = 220.dp)
                    )
                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 40.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .width(320.dp)
                        .height(50.dp)
                        .testTag("login_button"),
                    colors = ButtonDefaults.buttonColors(backgroundColor = CongoPink),
                ) {
                    Text(
                        text = stringResource(id = R.string.login),
                        fontWeight = Bold,
                        fontSize = 16.sp
                    )
                }

                Text(
                    text = stringResource(id = R.string.or),
                    color = Color.Black, fontWeight = Bold,
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .align(
                            Alignment.CenterHorizontally
                        ),

                )

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = stringResource(id = R.string.facebook_logo),
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = stringResource(id = R.string.google_logo),
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_smartphone),
                            contentDescription = stringResource(id = R.string.mobile_logo),
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(75.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.donothaveaccount),
                    color = Color.Black,
                    fontSize = 16.sp
                )
                TextButton(
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = stringResource(id = R.string.register),
                        color = Color.Red,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}
