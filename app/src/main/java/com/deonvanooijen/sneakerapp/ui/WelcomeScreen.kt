package com.deonvanooijen.sneakerapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deonvanooijen.sneakerapp.R
import com.deonvanooijen.sneakerapp.ui.theme.BlackBackground
import com.deonvanooijen.sneakerapp.ui.theme.avenirFontFamily

@Composable
fun WelcomeScreen(onGetStarted: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground)
            .padding(top = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.arkk_welcome_bg),
            contentDescription = "Welcome Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .align(Alignment.TopCenter)
                .padding(top = 80.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.arkk_banner_transparant),
            contentDescription = "Arkk Banner",
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        )

        Button(
            onClick = { onGetStarted() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 24.dp, bottom = 48.dp)
                .size(width = 160.dp, height = 56.dp)
        ) {
            Text(
                text = "Get Started",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = avenirFontFamily
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen(onGetStarted = {})
}
