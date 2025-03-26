package com.deonvanooijen.sneakerapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deonvanooijen.sneakerapp.data.Sneaker
import com.deonvanooijen.sneakerapp.ui.theme.avenirFontFamily

@Composable
fun FavoritesCard(
    sneaker: Sneaker,
    onRemoveFromFavorites: (Sneaker) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Sneaker Image
            Image(
                painter = painterResource(id = sneaker.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                // Brand Logo
                Image(
                    painter = painterResource(id = sneaker.logoResId),
                    contentDescription = "${sneaker.brand} Logo",
                    modifier = Modifier
                        .size(36.dp)
                        .padding(bottom = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

                // Brand Name & Model
                Text(
                    text = sneaker.brand,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    fontFamily = avenirFontFamily
                )
                Text(
                    text = sneaker.model,
                    fontSize = 14.sp,
                    fontFamily = avenirFontFamily,
                    color = Color.Gray
                )

                // Retail Price
                Text(
                    text = "Price: $${sneaker.retailPrice}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    fontFamily = avenirFontFamily,
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Remove from Favorites Button
                Text(
                    text = "Remove",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    modifier = Modifier
                        .clickable {
                            onRemoveFromFavorites(sneaker)
                        }
                        .padding(end = 16.dp)
                )
            }
        }
    }
}