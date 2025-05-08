package com.example.learnkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { padding ->
                LoginBody(padding)
            }
        }
    }
}

@Composable
fun LoginBody(paddingValues: PaddingValues) {
//    var counter : Int = 0

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        Image(
            painter = painterResource(R.drawable.login),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            placeholder = {
                Text(text = "Enter email")
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                focusedIndicatorColor = Color.Green,
                unfocusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                unfocusedIndicatorColor = Color.Blue
            ),
            shape = RoundedCornerShape(12.dp),
            prefix = {
                Icon(Icons.Default.Email, contentDescription = null)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        Spacer(modifier = Modifier.height(20.dp))
        Row {
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                placeholder = {
                    Text(text = "Enter password")
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                    focusedIndicatorColor = Color.Green,
                    unfocusedContainerColor = Color.Gray.copy(alpha = 0.2f),
                    unfocusedIndicatorColor = Color.Blue
                ),
                shape = RoundedCornerShape(12.dp),
                prefix = {
                    Icon(Icons.Default.Email, contentDescription = null)
                },
                suffix = {
                    Icon(
                        painterResource(
                            if (isPasswordVisible) R.drawable.baseline_visibility_off_24 else
                                R.drawable.baseline_visibility_24
                        ),
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            //                        1


                            //2
                            isPasswordVisible = !isPasswordVisible

                        }
                    )
                },

                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    checkmarkColor = Color.White
                ),
                checked = rememberMe,
                onCheckedChange = {
                    rememberMe = it

                }
            )
            Text(text = "Remember me")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Forgot password? ")
        }

        Button(onClick = {},
            modifier = Modifier.padding(top = 16.dp)
        )
        {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Don't have an account? ")
        }

        Spacer(modifier = Modifier.height(50.dp))

        Text(text = "Sign in with:")
        Spacer(modifier = Modifier.height(10.dp))

        Row() {
            Image(
                painter = painterResource(R.drawable.git),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.
                height(60.dp).width(60.dp).
                clip(shape = RoundedCornerShape(100.dp))
            )

            Image(
                painter = painterResource(R.drawable.facebook),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.
                height(60.dp).
                width(60.dp).
                clip(shape = RoundedCornerShape(100.dp)))
        }


    }
}

@Preview
@Composable
fun PreviewLogin(){
    LoginBody(paddingValues = PaddingValues(0.dp))
}