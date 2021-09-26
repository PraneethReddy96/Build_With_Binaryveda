package com.praneeth.godrejlocksui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.praneeth.godrejlocksui.ui.theme.*


class MainActivity : ComponentActivity() {

    @ExperimentalAnimationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GodrejLocksUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.White) {
                    Navigation()
                }
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun HomeScreen(navController: NavController) {
    HeaderIcons()
    Welcome(modifier = Modifier)
    CenterCard(navController = navController, modifier = Modifier)
    BottomTabs(modifier = Modifier)
}

@ExperimentalMaterialApi
@Composable
fun BottomTabs(modifier: Modifier) {

    Box(modifier
        .fillMaxWidth()
        .padding(24.dp, 577.dp, 24.dp, 24.dp)
        .clip(RoundedCornerShape(10.dp))) {

        Row(Modifier
            .height(56.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {

            Column(
                modifier
                    .background(color = blue)
                    .fillMaxWidth(0.5f)
                    .height(56.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painterResource(id = R.drawable.ic_lock),
                    contentDescription = "Home Screen Lock",
                    tint = Color.Unspecified,
                )

                Text("Locks",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.firasans_semibold)),
                    color = Color.White
                )

            }

            Column(modifier
                .background(color = cream)
                .fillMaxWidth()
                .height(56.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(
                    painterResource(id = R.drawable.ic_camera),
                    contentDescription = "Home Screen Camera",
                    tint = Color.Unspecified,
                )

                Text("Cameras",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.firasans_semibold)),
                    color = grey
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun CenterCard(navController: NavController, modifier: Modifier) {

    Card(

        modifier
            .padding(24.dp, 190.dp, 24.dp, 0.dp)
            .height(327.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { navController.navigate(route =Screen.LockActivity.route)},
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
    ) {

        Column {
            Box(modifier
                .height(221.dp)
                .fillMaxWidth()) {
                Image(
                    painter = painterResource(R.drawable.background),
                    contentDescription = "Home Screen Image",
                    Modifier.fillMaxSize(),
                    alignment = Alignment.TopStart,
                    contentScale = ContentScale.FillBounds
                )

                Box(modifier
                    .fillMaxSize()
                    .background(Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ), startY = 600f

                    )))

            }

            Box(modifier
                .background(cream)
                .fillMaxSize()
                .padding(12.dp, 12.dp, 12.dp, 10.dp)
            ) {

                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    Column {
                        Text("A-201 (YourSpace)",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.firasans_bold)),
                            color = Color.Black)


                        Text(
                            buildAnnotatedString {

                                withStyle(style = SpanStyle(fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily(Font(R.font.firasans_bold)),
                                    color = redOrange)) {
                                    append("LOCKED")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.firasans_regular)),
                                        color = Color.Black
                                    )
                                ) {
                                    append(" by Kunal Sharma at 11:44 PM")
                                }
                            })

                        Text("using Smartphone",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.firasans_regular)),
                            color = grey)
                    }

                    Column(verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = modifier.padding(60.dp, 20.dp, 0.dp, 0.dp)) {

                        Icon(painter = painterResource(R.drawable.ic_battery),
                            contentDescription = "Battery",
                            modifier = Modifier.size(18.dp),
                            tint = Color.Unspecified
                        )

                        Icon(painter = painterResource(R.drawable.ic_wifi),
                            contentDescription = "Wifi",
                            modifier = Modifier.size(18.dp),
                            tint = Color.Unspecified)

                        Icon(painter = painterResource(R.drawable.ic_bluetooth),
                            contentDescription = "Bluetooth",
                            modifier = Modifier.size(18.dp),
                            tint = Color.Unspecified)
                    }

                }

            }
        }
    }

    ProgressBar()
}

@Composable
fun ProgressBar() {

    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(162.dp, 533.dp, 0.dp, 0.dp)) {
        Box(modifier = Modifier
            .height(5.dp)
            .width(16.dp)
            .background(blue)
            .clip(RoundedCornerShape(180.dp)))
        Box(modifier = Modifier
            .height(5.dp)
            .width(6.dp)
            .background(Color.White))
        Box(modifier = Modifier
            .height(5.dp)
            .width(5.dp)
            .background(lightGrey)
            .clip(CircleShape))
        Box(modifier = Modifier
            .height(5.dp)
            .width(6.dp)
            .background(Color.White))
        Box(modifier = Modifier
            .height(5.dp)
            .width(5.dp)
            .background(lightGrey)
            .clip(CircleShape))

    }
}


@Composable
fun Welcome(modifier: Modifier) {

    Column(modifier.padding(24.dp, 100.dp)) {
        Text(text = "Welcome home",
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.firasans_regular)),
            color = Color.Black)

        Text(text = "Kunal!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.firasans_regular)),
            color = Color.Black)
    }

}

@Composable
fun HeaderIcons() {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 24.dp, 24.dp, 0.dp)) {

        Icon(painter = painterResource(R.drawable.ic_hamburger),
            contentDescription = "Search",
            modifier = Modifier.size(24.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(blue)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}


@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GodrejLocksUiTheme {
        Navigation()
    }
}

