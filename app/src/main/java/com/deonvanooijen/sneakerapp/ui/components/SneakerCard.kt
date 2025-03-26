package com.deonvanooijen.sneakerapp

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deonvanooijen.sneakerapp.data.Sneaker
import com.deonvanooijen.sneakerapp.ui.theme.avenirFontFamily

@Composable
fun SneakerCard(
    sneaker: Sneaker,
    onAddToCart: (Sneaker) -> Unit,
    onAddToWishlist: (Sneaker) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Sneaker Image
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    Image(
                        painter = painterResource(id = sneaker.imageResId),
                        contentDescription = "${sneaker.brand} ${sneaker.model}",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                // Brand Name
                Text(
                    text = sneaker.brand,
                    fontWeight = FontWeight.Bold,
                    fontFamily = avenirFontFamily,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 0.dp)
                        .fillMaxWidth(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )

                // Model Name
                Text(
                    text = sneaker.model,
                    fontSize = 12.sp,
                    fontFamily = avenirFontFamily,
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )

                // Price
                Text(
                    text = "$${sneaker.retailPrice}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    fontFamily = avenirFontFamily,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Add to Cart Button
                Button(
                    onClick = { onAddToCart(sneaker) },
                    modifier = Modifier.fillMaxWidth(0.8f)
                ) {
                    Text(
                        text = "Add to cart",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = avenirFontFamily,
                    )
                }
            }

            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .clickable { onAddToWishlist(sneaker) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_star),
                    contentDescription = "Favorites",
                    modifier = Modifier.size(32.dp)
                )

                Text(
                    text = "Add to favorites",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = avenirFontFamily,
                    color = Color.Black
                )
            }
        }
    }
}