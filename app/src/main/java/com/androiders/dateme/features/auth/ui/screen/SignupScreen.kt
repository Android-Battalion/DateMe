package com.androiders.dateme.features.signUp.ui.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.androiders.dateme.features.auth.viewModel.AuthViewModel
import com.androiders.dateme.util.NetworkResult
import com.google.firebase.auth.FirebaseUser

@Composable
fun SignUpScreen(authViewModel: AuthViewModel) {

    val tag = "SignUpScreen"
    val context = LocalContext.current

    val gradient = Brush.verticalGradient(0.5f to CongoPink, 0.5f to Color.White)

    var fullNameTextState by remember { mutableStateOf(TextFieldValue()) }
    var emailTextState by remember { mutableStateOf(TextFieldValue()) }
    var passwordTextState by remember { mutableStateOf(TextFieldValue()) }

    var isPasswordVisible by remember { mutableStateOf(false) }

    val authResource = authViewModel.signupFlow.collectAsState()

    ScreenContent(
        gradient,
        fullNameTextState,
        emailTextState,
        passwordTextState,
        isPasswordVisible,
        { value -> fullNameTextState = value },
        { value -> emailTextState = value },
        { value -> passwordTextState = value },
        {
            isPasswordVisible = !isPasswordVisible
        },
        authViewModel,
        tag,
        context,
        authResource
    )
}

@Composable
fun ScreenContent(
    gradient: Brush,
    fullNameTextState: TextFieldValue,
    emailTextState: TextFieldValue,
    passwordTextState: TextFieldValue,
    isPasswordVisible: Boolean,
    onFullNameTextChange: (value: TextFieldValue) -> Unit,
    onEmailTextChange: (value: TextFieldValue) -> Unit,
    onPasswordTextChange: (value: TextFieldValue) -> Unit,
    onPasswordVisibilityChange: () -> Unit,
    authViewModel: AuthViewModel,
    tag: String,
    context: Context,
    authResource: State<NetworkResult<FirebaseUser>?>

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
                text = "IDate",
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
                    .height(540.dp),
            ) {

                Text(
                    text = "Full Name",
                    color = Color.Black,
                    modifier = Modifier.padding(top = 30.dp, start = 20.dp, bottom = 5.dp)
                )

                TextField(
                    value = fullNameTextState,
                    onValueChange = { onFullNameTextChange(it) },
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
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                Text(
                    text = "Email",
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
                    text = "Password",
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
                                contentDescription = "Password Toggle", tint = Color.Black
                            )
                        }
                    }
                )

                Button(
                    onClick = {
                        authViewModel.signupWithEmailAndPassword(
                            emailTextState.text,
                            passwordTextState.text
                        )

                        authResource.value?.let {
                            when (it) {

                                is NetworkResult.Error -> {
                                    Log.i(tag, "createUserWithEmail:failure ${it.message}")
                                    Toast.makeText(
                                        context,
                                        "createUserWithEmail:failure",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                is NetworkResult.Loading -> {
                                }

                                is NetworkResult.Success -> {
                                    Log.d(tag, "createUserWithEmail:successs")
                                    Toast.makeText(
                                        context, "user created successfully",
                                        Toast.LENGTH_SHORT
                                    ).show() // should be replaced with navigation
                                }
                            }
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 40.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .width(320.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = CongoPink),
                ) {
                    Text(text = "Sign Up", fontWeight = Bold, fontSize = 16.sp)
                }

                Text(
                    text = "Or Sign Up With",
                    color = Color.Black,
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
                            contentDescription = "Facebook Logo",
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "Google Logo",
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_smartphone),
                            contentDescription = "Mobile Logo",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Joined us before?", color = Color.Black, fontSize = 16.sp)
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Login", color = Color.Red, fontSize = 16.sp)
                }
            }
        }
    }
}
