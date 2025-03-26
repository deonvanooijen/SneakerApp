package com.deonvanooijen.sneakerapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.deonvanooijen.sneakerapp.ui.theme.avenirFontFamily
import androidx.compose.ui.text.style.TextAlign
import com.deonvanooijen.sneakerapp.R

@Composable
fun ProfileScreen(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { navController?.popBackStack() },
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Profile",
                fontSize = 32.sp,
                fontFamily = avenirFontFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        Image(
            painter = painterResource(id = R.drawable.profilepic_round),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )

        Text(
            text = "Deon van Ooijen",
            fontSize = 18.sp,
            fontFamily = avenirFontFamily,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "deonvanooijen@gmail.com",
            fontSize = 16.sp,
            fontFamily = avenirFontFamily,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Buttons List
        val buttonTitles = listOf(
            "Account Information",
            "Security",
            "Notification",
            "Language",
            "Privacy Policy"
        )

        buttonTitles.forEach { title ->
            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(60.dp)
                    .border(1.dp, Color.Black, shape = MaterialTheme.shapes.medium),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontFamily = avenirFontFamily,
                    color = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview_NoNav() {
    ProfileScreen(navController = null)
}