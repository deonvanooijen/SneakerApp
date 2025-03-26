package com.deonvanooijen.sneakerapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deonvanooijen.sneakerapp.R
import com.deonvanooijen.sneakerapp.data.CartItem

private val avenirFontFamily = FontFamily(
    Font(R.font.avenir_light)
)

@Composable
fun BottomSection(cartItems: List<CartItem>) {
    val totalPrice = cartItems.sumOf { it.sneaker.retailPrice * it.quantity }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .height(64.dp)
            .padding(16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Total price Text
            Text(
                text = "Total price: $${"%.2f".format(totalPrice)}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                color = Color.White,
                fontFamily = avenirFontFamily
            )

            Spacer(Modifier.weight(1f))

            Text(
                text = "Checkout",
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                color = Color.White,
                fontFamily = avenirFontFamily
            )

            Spacer(Modifier.width(8.dp))

            Box(
                modifier = Modifier
                    .size(20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cart_checkout_logo),
                    contentDescription = "Cart Logo",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
