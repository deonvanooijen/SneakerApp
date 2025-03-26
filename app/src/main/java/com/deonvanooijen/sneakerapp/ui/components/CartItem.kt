import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deonvanooijen.sneakerapp.data.Sneaker
import com.deonvanooijen.sneakerapp.ui.theme.avenirFontFamily

@Composable
fun CartItemView(
    sneaker: Sneaker,
    quantity: Int,
    onIncreaseQuantity: (Sneaker) -> Unit,
    onDecreaseQuantity: (Sneaker) -> Unit,
    onRemoveFromCart: (Sneaker) -> Unit
) {
    val context = LocalContext.current

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

                // Quantity Controls and Remove Button
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(
                        onClick = { onDecreaseQuantity(sneaker) },
                        enabled = quantity > 1, // Disable if quantity is 1
                        colors = IconButtonDefaults.iconButtonColors(contentColor = Color.Black)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = "Decrease Quantity",
                        )
                    }

                    Text(
                        text = "$quantity",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    IconButton(
                        onClick = { onIncreaseQuantity(sneaker) },
                        colors = IconButtonDefaults.iconButtonColors(contentColor = Color.Black)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowUp,
                            contentDescription = "Increase Quantity",
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    // Remove from Cart Button
                    Text(
                        text = "Remove",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        modifier = Modifier
                            .clickable {
                                onRemoveFromCart(sneaker)
                            }
                            .padding(end = 16.dp) // Optional padding to the left of the "Remove" text
                    )
                }
            }
        }
    }
}