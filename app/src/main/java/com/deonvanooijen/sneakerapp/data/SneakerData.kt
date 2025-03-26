import com.deonvanooijen.sneakerapp.R
import com.deonvanooijen.sneakerapp.data.Sneaker
import com.deonvanooijen.sneakerapp.data.StockLevel

fun getSneakers(): List<Sneaker> {
    return listOf(
        Sneaker(
            id = "sneaker_raven_mesh",
            imageResId = R.drawable.arkk1,
            brand = "Arkk Copenhagen",
            model = "Raven Mesh HL S-E15 Vibram",
            stock = StockLevel.HIGH,
            retailPrice = 180.00,
            logoResId = R.drawable.arkk_logo
        ),
        Sneaker(
            id = "sneaker_pykro_mesh",
            imageResId = R.drawable.arkk2,
            brand = "Arkk Copenhagen",
            model = "Pykro Mesh F-PRO90",
            stock = StockLevel.LOW,
            retailPrice = 180.00,
            logoResId = R.drawable.arkk_logo
        ),
        Sneaker(
            id = "sneaker_raven_fg",
            imageResId = R.drawable.arkk3,
            brand = "Arkk Copenhagen",
            model = "Raven FG PET 2.0 PWR55",
            stock = StockLevel.MEDIUM,
            retailPrice = 155.00,
            logoResId = R.drawable.arkk_logo
        ),
        Sneaker(
            id = "sneaker_tuzon_suede",
            imageResId = R.drawable.arkk4,
            brand = "Arkk Copenhagen",
            model = "Tuzon Suede W13",
            stock = StockLevel.HIGH,
            retailPrice = 105.00,
            logoResId = R.drawable.arkk_logo
        ),
        Sneaker(
            id = "sneaker_duratek",
            imageResId = R.drawable.arkk5,
            brand = "Arkk Copenhagen",
            model = "Duratek",
            stock = StockLevel.MEDIUM,
            retailPrice = 200.00,
            logoResId = R.drawable.arkk_logo
        ),
        Sneaker(
            id = "sneaker_stormrydr",
            imageResId = R.drawable.arkk6,
            brand = "Arkk Copenhagen",
            model = "Stormrydr",
            stock = StockLevel.MEDIUM,
            retailPrice = 200.00,
            logoResId = R.drawable.arkk_logo
        ),
        Sneaker(
            id = "sneaker_gravity",
            imageResId = R.drawable.arkk7,
            brand = "Arkk Copenhagen",
            model = "Gravity",
            stock = StockLevel.MEDIUM,
            retailPrice = 165.00,
            logoResId = R.drawable.arkk_logo
        ),
        Sneaker(
            id = "sneaker_chrontech_mesh",
            imageResId = R.drawable.arkk8,
            brand = "Arkk Copenhagen",
            model = "Chrontech Mesh HL W13",
            stock = StockLevel.MEDIUM,
            retailPrice = 150.00,
            logoResId = R.drawable.arkk_logo
        ),
        Sneaker(
            id = "sneaker_oserra",
            imageResId = R.drawable.arkk9,
            brand = "Arkk Copenhagen",
            model = "Oserra",
            stock = StockLevel.MEDIUM,
            retailPrice = 140.00,
            logoResId = R.drawable.arkk_logo
        ),
        Sneaker(
            id = "sneaker_kanetyk",
            imageResId = R.drawable.arkk10,
            brand = "Arkk Copenhagen",
            model = "Kanetyk",
            stock = StockLevel.MEDIUM,
            retailPrice = 155.00,
            logoResId = R.drawable.arkk_logo
        ),
        Sneaker(
            id = "sneaker_forma_runner",
            imageResId = R.drawable.arkk11,
            brand = "Arkk Copenhagen",
            model = "Forma Runner",
            stock = StockLevel.MEDIUM,
            retailPrice = 120.00,
            logoResId = R.drawable.arkk_logo
        ),
        Sneaker(
            id = "sneaker_waste_zero",
            imageResId = R.drawable.arkk12,
            brand = "Arkk Copenhagen",
            model = "Waste Zero",
            stock = StockLevel.MEDIUM,
            retailPrice = 155.00,
            logoResId = R.drawable.arkk_logo
        ),
    )
}