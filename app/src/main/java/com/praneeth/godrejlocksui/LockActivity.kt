package com.praneeth.godrejlocksui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.praneeth.godrejlocksui.ui.theme.*


class LockActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GodrejLocksUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

//this@LockActivity
//context: Context
@Composable
fun LockActivityScreen(navController: NavController) {
    Headers(navController=navController)
    LockAnimationCard(modifier = Modifier)
    FooterIcons()
}

//context = context

@Composable
fun FooterIcons() {
    Row(
        modifier = Modifier
            .padding(21.dp, 555.dp, 24.dp, 14.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {


        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(blue),

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_ic_activity),
                    contentDescription = "Activity",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }

            Text("Activity",
                modifier = Modifier.padding(0.dp, 12.dp),
                fontFamily = FontFamily(Font(R.font.firasans_regular)),
                fontSize = 12.sp, color = Color.Black)

        }

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(blue)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_ic_users),
                    contentDescription = "Users",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }

            Text("Users",
                modifier = Modifier.padding(0.dp, 12.dp),
                fontFamily = FontFamily(Font(R.font.firasans_regular)),
                fontSize = 12.sp, color = Color.Black)

        }


        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(blue)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_ic_settings),
                    contentDescription = "Settings",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }

            Text("Settings",
                modifier = Modifier.padding(0.dp, 12.dp),
                fontFamily = FontFamily(Font(R.font.firasans_regular)),
                fontSize = 12.sp, color = Color.Black)

        }
    }

}



@Composable
fun LockAnimationCard(modifier: Modifier) {

    var lockBackgroundColor by remember { mutableStateOf(true) }
    val colorState by animateColorAsState(if (lockBackgroundColor) redOrange else green)

    Card(
        modifier
            .padding(24.dp, 190.dp, 24.dp, 0.dp)
            .fillMaxWidth()
            .height(327.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
        backgroundColor = cream,
    ) {

        Column(Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(0.dp, 38.dp, 0.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween) {


            Box(contentAlignment = Center) {
                Canvas(modifier = Modifier.size(187.dp), onDraw = {
                    drawCircle(colorState)
                })

                Canvas(modifier = Modifier.size(182.dp), onDraw = {
                    drawCircle(cream)
                })

                Canvas(modifier = Modifier.size(167.dp), onDraw = {
                    drawCircle(colorState)
                })

                IconButton(modifier = Modifier.size(93.dp),
                    onClick = { lockBackgroundColor = !lockBackgroundColor }) {
                    Icon(
                        painter = painterResource(id = if (lockBackgroundColor) R.drawable.ic_locked else R.drawable.ic_unlocked),
                        modifier = Modifier.size(93.dp),
                        contentDescription = "Locked",
                        tint = Color.White,
                        )
                }
            }
            Surface(modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()) {
                Box(Modifier
                    .background(cream)
                    .fillMaxWidth()
                    .padding(60.dp, 10.dp, 10.dp, 0.dp)
                ) {

                    Row(modifier = Modifier.matchParentSize(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically) {

                        Column(Modifier.fillMaxWidth(0.8f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally) {

                            Text(text = if (lockBackgroundColor) "LOCKED" else "UNLOCKED",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.firasans_bold)),
                                color = colorState)

                            Text(" by Kunal Sharma at 11:44 PM",
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.firasans_regular)),
                                color = Color.Black)


                            Text("using Smartphone",
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.firasans_regular)),
                                color = grey)

                        }
                        Column(verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(25.dp, 0.dp, 0.dp, 0.dp)
                                .fillMaxWidth()) {

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
    }
}


//context : Context
@Composable
fun Headers(navController: NavController) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 25.dp, 24.dp, 0.dp)) {


        Icon(
            painter = painterResource(R.drawable.ic_back),
            contentDescription = "Back",
            modifier = Modifier.size(24.dp).clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { navController.navigate(route =Screen.HomeScreen.route)})


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(darkGrey)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dnd),
                contentDescription = "NightMode",
                tint = Color.White,
                modifier = Modifier.size(18.dp)
            )
        }
    }

    Column(modifier = Modifier.padding(24.dp, 100.dp, 0.dp, 0.dp)) {

        Text("A-201 (YourSpace)",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.firasans_semibold)),
            color = Color.Black)

        Text("SmartLock Pro (2nd Gen)",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.firasans_regular)),
            color = grey)
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    GodrejLocksUiTheme {
//        LockActivityScreen()
    }
}


