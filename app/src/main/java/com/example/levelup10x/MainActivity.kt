package com.example.levelup10x
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.levelup10x.ui.theme.LevelUp10xTheme
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LevelUp10xTheme {
                // A surface container using the 'background' color from the theme
                ScreenRotation()
            }
        }
    }
}

@Composable
fun ScreenRotation() {
    val config = LocalConfiguration.current
    val portraitMode = remember { mutableStateOf(config.orientation) }
    if (portraitMode.value == Configuration.ORIENTATION_PORTRAIT) {
        Surface(color = Color.Magenta) {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TitleDisplay(message = "Level Up 10X", fontSize = 50f)
                LotteryPortrait()
            }
        }
    } else {
        Surface(color = Color.Magenta) {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TitleDisplay(message = "Level Up 10X", fontSize = 60f)
                LotteryLandscape()
            }
        }
    }
}

@Composable
fun TitleDisplay(message: String, fontSize: Float){
    Text(modifier = Modifier
        .padding(top = 60.dp, bottom = 10.dp)
        .background(Color.Blue)
        .fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Green
    )
}

@Composable
fun LotteryPortrait(viewModel: LevelUp10xViewModel = viewModel()) {
    val haptic = LocalHapticFeedback.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .height(1300.dp)
            .padding(bottom = 60.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(10.dp)
    )
    {
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(1000.dp)
            ) {
                //First Column Prize Button
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp),
                    onClick = { if ((viewModel.fourthUp != "STOP") && (viewModel.fourthUp != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(5) }) {
                    Image(painter = painterResource(id = R.drawable.winbutton),
                        contentDescription = null)
                    Text(viewModel.columnPrize, modifier = Modifier .padding(top = 20.dp),
                        fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    when (viewModel.columnPrize) {
                        " " ->  Text("Prize", modifier = Modifier .padding(top = 20.dp),
                            fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    }
                }
                //Second Column Prize Button
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp),
                    onClick = { if ((viewModel.fourthUp2 != "STOP") && (viewModel.fourthUp2 != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(10) }) {
                    Image(painter = painterResource(id = R.drawable.winbutton),
                        contentDescription = null)
                    Text(viewModel.columnPrize2, modifier = Modifier .padding(top = 20.dp),
                        fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    when (viewModel.columnPrize2) {
                        " " ->  Text("Prize", modifier = Modifier .padding(top = 20.dp),
                            fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    }
                }
                //Third Column Prize Button
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp),
                    onClick = { if ((viewModel.fourthUp3 != "STOP") && (viewModel.fourthUp3 != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(15) }) {
                    Image(painter = painterResource(id = R.drawable.winbutton),
                        contentDescription = null)
                    Text(viewModel.columnPrize3, modifier = Modifier .padding(top = 20.dp),
                        fontWeight = FontWeight.Bold, fontSize =30.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    when (viewModel.columnPrize3) {
                        " " ->  Text("Prize", modifier = Modifier .padding(top = 20.dp),
                            fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    }
                }
                //Fourth Column Prize Button
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp),
                    onClick = { if ((viewModel.fourthUp4 != "STOP") && (viewModel.fourthUp4 != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(20) }) {
                    Image(painter = painterResource(id = R.drawable.winbutton),
                        contentDescription = null)
                    Text(viewModel.columnPrize4, modifier = Modifier .padding(top = 20.dp),
                        fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    when (viewModel.columnPrize4) {
                        " " ->  Text("Prize", modifier = Modifier .padding(top = 20.dp),
                            fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    }
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(600.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.fourthUp) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.fourthUp2) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.fourthUp3) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.fourthUp4) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(600.dp)
                    .height(150.dp)
                    .fillMaxWidth()
                    .background(Color.Blue)
            ) {
                Button(
                    onClick = { if ((viewModel.thirdUp3 != "STOP") && (viewModel.thirdUp3 != " "))
                                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(4) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 40.dp)
                        .size(70.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Button(
                    onClick = { if ((viewModel.thirdUp2 != "STOP") && (viewModel.thirdUp2 != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(9) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 40.dp)
                        .size(70.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                // Button 4, third column
                Button(
                    onClick =  { if ((viewModel.thirdUp3 != "STOP") && (viewModel.thirdUp3 != " "))
                                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) };
                        viewModel.playLottery(14) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 40.dp)
                        .size(70.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Button(
                    onClick = { if ((viewModel.thirdUp4 != "STOP") && (viewModel.thirdUp4 != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(19) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 40.dp)
                        .size(70.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(600.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.thirdUp) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.thirdUp2) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.thirdUp3) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.thirdUp4) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(600.dp)
                    .height(150.dp)
                    .fillMaxWidth()
                    .background(Color.Blue)
            ) {
                Button(
                    onClick = { if ((viewModel.secondUp != "STOP") && (viewModel.secondUp != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(3) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 40.dp)
                        .size(70.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Button(
                    onClick = { if ((viewModel.secondUp2 != "STOP") && (viewModel.secondUp2 != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(8)},
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 40.dp)
                        .size(70.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Button(
                    onClick = { if ((viewModel.secondUp3 != "STOP") && (viewModel.secondUp3 != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(13) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 40.dp)
                        .size(70.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Button(
                    onClick = { if ((viewModel.secondUp4 != "STOP") && (viewModel.secondUp4 != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(18) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 40.dp)
                        .size(70.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(600.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.secondUp) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.secondUp2) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.secondUp3) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }

                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.secondUp4) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(600.dp)
                    .height(150.dp)
                    .fillMaxWidth()
                    .background(Color.Blue)
            ) {
                Button(
                    onClick = { if ((viewModel.firstUp != "STOP") && (viewModel.firstUp != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(2) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 40.dp)
                        .size(70.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )

                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Button(
                    onClick = { if ((viewModel.firstUp2 != "STOP") && (viewModel.firstUp2 != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(7) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 40.dp)
                        .size(70.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Button(
                    onClick = { if ((viewModel.firstUp3 != "STOP") && (viewModel.firstUp3 != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(12) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 40.dp)
                        .size(70.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Button(
                    onClick = { if ((viewModel.firstUp4 != "STOP") && (viewModel.firstUp4 != " "))
                    { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
                        viewModel.playLottery(17) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 40.dp)
                        .size(70.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(600.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.firstUp) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.firstUp2) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.firstUp3) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                        painter = painterResource(id = R.drawable.gift),
                        contentDescription = null
                    )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.firstUp4) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )
                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(600.dp)
            ) {
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp),
                    color = Color.Yellow,
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(1) }) {
                    Image(painter = painterResource(id = R.drawable.startbutton),
                        contentDescription = null
                    )
                }
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp),
                    color = Color.Yellow,
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(6) }) {
                    Image(painter = painterResource(id = R.drawable.startbutton),
                        contentDescription = null
                    )
                }
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp),
                    color = Color.Yellow,
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(11) }) {
                    Image(painter = painterResource(id = R.drawable.startbutton),
                        contentDescription = null
                    )
                }
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp),
                    color = Color.Yellow,
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(16) }) {
                    Image(painter = painterResource(id = R.drawable.startbutton),
                        contentDescription = null
                    )
                }
            }
        }
        item {
            Button(
                onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.clear() },
                modifier = Modifier
                    .height(60.dp)
                    .width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Blue
                )
            ) {
                Text("Reset", fontWeight = FontWeight.Bold, fontSize = 25.sp)
            }
        }
    }
}

@Composable
fun LotteryLandscape(viewModel: LevelUp10xViewModel = viewModel()) {
    val haptic = LocalHapticFeedback.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .height(1300.dp)
            .padding(bottom = 60.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(10.dp)
    )
    {
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(1000.dp)
            ) {
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp),
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(5) }) {
                    Image(painter = painterResource(id = R.drawable.winbutton),
                        contentDescription = null)
                    Text(viewModel.columnPrize, modifier = Modifier .padding(top = 30.dp),
                        fontWeight = FontWeight.Bold, fontSize = 40.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    when (viewModel.columnPrize) {
                        " " ->  Text("Prize", modifier = Modifier .padding(top = 30.dp),
                            fontWeight = FontWeight.Bold, fontSize = 40.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    }
                }
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp),
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(10) }) {
                    Image(painter = painterResource(id = R.drawable.winbutton),
                        contentDescription = null)
                    Text(viewModel.columnPrize2, modifier = Modifier .padding(top = 30.dp),
                        fontWeight = FontWeight.Bold, fontSize = 40.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    when (viewModel.columnPrize2) {
                        " " ->  Text("Prize", modifier = Modifier .padding(top = 30.dp),
                            fontWeight = FontWeight.Bold, fontSize = 40.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    }
                }
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp),
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(15) }) {
                    Image(painter = painterResource(id = R.drawable.winbutton),
                        contentDescription = null)
                    Text(viewModel.columnPrize3, modifier = Modifier .padding(top = 30.dp),
                        fontWeight = FontWeight.Bold, fontSize =40.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    when (viewModel.columnPrize3) {
                        " " ->  Text("Prize", modifier = Modifier .padding(top = 30.dp),
                            fontWeight = FontWeight.Bold, fontSize = 40.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    }
                }
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp),
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(20) }) {
                    Image(painter = painterResource(id = R.drawable.winbutton),
                        contentDescription = null)
                    Text(viewModel.columnPrize4, modifier = Modifier .padding(top = 30.dp),
                        fontWeight = FontWeight.Bold, fontSize = 40.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    when (viewModel.columnPrize4) {
                        " " ->  Text("Prize", modifier = Modifier .padding(top = 30.dp),
                            fontWeight = FontWeight.Bold, fontSize = 40.sp, textAlign = TextAlign.Center, color = Color.Blue)
                    }
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(1000.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.fourthUp) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.fourthUp2) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.fourthUp3) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.fourthUp4) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(1000.dp)
                    .height((200.dp))
                    .fillMaxWidth()
                    .background(Color.Blue)
            ) {
                Button(
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress);  viewModel.playLottery(4) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 50.dp)
                        .size(110.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                }
                Button(
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress);  viewModel.playLottery(9) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 50.dp)
                        .size(110.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                }
                Button(
                    onClick =  { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(14) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 50.dp)
                        .size(110.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                }
                Button(
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(19) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 50.dp)
                        .size(110.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(1000.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.thirdUp) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.thirdUp2) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.thirdUp3) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.thirdUp4) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(1000.dp)
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.Blue)
            ) {
                Button(
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(3) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 50.dp)
                        .size(110.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                }
                Button(
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(8)},
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 50.dp)
                        .size(110.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                }
                Button(
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(13) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 50.dp)
                        .size(110.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                }
                Button(
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(18) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 50.dp)
                        .size(110.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(1000.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.secondUp) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.secondUp2) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.secondUp3) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.secondUp4) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(1000.dp)
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.Blue)
            ) {
                Button(
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(2) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 50.dp)
                        .size(110.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )

                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                }
                Button(
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(7) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 50.dp)
                        .size(110.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                }
                Button(
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(12) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 50.dp)
                        .size(110.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                }
                Button(
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(17) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(top = 50.dp)
                        .size(110.dp),
                    border = BorderStroke(5.dp, Color.Red),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Up", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(1000.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.firstUp) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.firstUp2) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.firstUp3) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )

                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    color = Color.Transparent
                )
                {
                    when (viewModel.firstUp4) {
                        "UP" -> Image(
                            painter = painterResource(id = R.drawable.up),
                            contentDescription = null
                        )

                        "STOP" -> Image(
                            painter = painterResource(id = R.drawable.stopsign),
                            contentDescription = null
                        )

                        "2x" -> Image(
                            painter = painterResource(id = R.drawable.twox),
                            contentDescription = null
                        )

                        "5x" -> Image(
                            painter = painterResource(id = R.drawable.fivex),
                            contentDescription = null
                        )

                        "10x" -> Image(
                            painter = painterResource(id = R.drawable.tenx),
                            contentDescription = null
                        )
                        " "-> Image(
                            painter = painterResource(id = R.drawable.gift),
                            contentDescription = null
                        )
                    }
                }
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(1000.dp)
            ) {
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp),
                    color = Color.Yellow,
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress);  viewModel.playLottery(1) }) {
                    Image(painter = painterResource(id = R.drawable.startbutton),
                        contentDescription = null
                    )
                }
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp),
                    color = Color.Yellow,
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(6) }) {
                    Image(painter = painterResource(id = R.drawable.startbutton),
                        contentDescription = null
                    )
                }
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp),
                    color = Color.Yellow,
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(11) }) {
                    Image(painter = painterResource(id = R.drawable.startbutton),
                        contentDescription = null
                    )
                }
                Surface(modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp),
                    color = Color.Yellow,
                    onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.playLottery(16) }) {
                    Image(painter = painterResource(id = R.drawable.startbutton),
                        contentDescription = null
                    )
                }
            }
        }
        item {
            Button(
                onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); viewModel.clear() },
                modifier = Modifier
                    .height(80.dp)
                    .width(400.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Blue
                )
            ) {
                Text("Reset", fontWeight = FontWeight.Bold, fontSize = 40.sp)
            }
        }
    }
}


















































