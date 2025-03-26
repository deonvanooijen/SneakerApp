package com.deonvanooijen.sneakerapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deonvanooijen.sneakerapp.ui.theme.avenirFontFamily

@Composable
fun TopSection(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 32.dp)
            .height(96.dp),
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(
            text = title,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = avenirFontFamily
        )
    }
}