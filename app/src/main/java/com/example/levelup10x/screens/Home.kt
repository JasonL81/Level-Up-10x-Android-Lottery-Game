package com.example.levelup10x.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.levelup10x.R

import androidx.navigation.NavHostController

import com.example.levelup10x.NavRoutes


@Composable
fun Home(navController: NavHostController) {
    Surface(color = Color.Black) {
        Image(painter = painterResource(id = R.drawable.jason), contentDescription = null, contentScale = ContentScale.FillHeight)
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeTitle(message = "Level Up 10x", fontSize = 50f)
            EnterName(message = "PLEASE ENTER YOUR NAME", fontSize = 30f)
            Button(navController, message = "By Jason Luzar", fontSize = 30f)
        }
    }
}

@Composable
fun HomeTitle(message: String, fontSize: Float){
    Text(modifier = Modifier
        .padding(top = 60.dp, bottom = 40.dp)
        .background(Color.Magenta)
        .fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue
    )
}

@Composable
fun EnterName(message: String, fontSize: Float){
    Text(modifier = Modifier .padding(top = 50.dp, bottom = 30.dp),
        text = message,
        textAlign = TextAlign.Center,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Green
    )
}

@Composable
fun Button(navController: NavHostController, message: String, fontSize: Float) {
    var userName by remember { mutableStateOf("") }
    val onUserNameChange = { text: String ->
        userName = text
    }
    val context = LocalContext.current
    val haptic = LocalHapticFeedback.current

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CustomTextField(
                textState = userName,
                onTextChange = onUserNameChange
            )

            Spacer(modifier = Modifier.size(30.dp))

            Button(
                onClick = { try {
                        navController.navigate(NavRoutes.Lottery.route + "/$userName")
                        } catch (e: Exception)
                        { Toast.makeText(context, "ENTER YOUR NAME", Toast.LENGTH_LONG).show()};
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress) },
                modifier = Modifier
                    .padding(top = 60.dp)
                    .height(70.dp)
                    .width(300.dp),
                border = BorderStroke(5.dp, Color.Blue),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Blue
                )
            ) {
                Text("Play Lottery", fontWeight = FontWeight.Bold, fontSize = 30.sp)
            }

            Text(modifier = Modifier .padding(top = 50.dp),
                text = message,
                textAlign = TextAlign.Center,
                fontSize = fontSize.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Green
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    textState: String,
    onTextChange: (String) -> Unit,
) {
    val transparentYellow =  Color.Yellow.copy(alpha = 0.5f)
    OutlinedTextField(
        value = textState,
        onValueChange = { onTextChange(it) },
        singleLine = true,
        modifier = Modifier
            .padding(10.dp)
            .background(color = transparentYellow),
        textStyle = TextStyle(fontWeight = FontWeight.Bold,
            fontSize = 30.sp, color = Color.Green),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Green, // Outline color when focused
            unfocusedBorderColor = Color.Blue // Outline color when unfocused
        ),
        )
}

