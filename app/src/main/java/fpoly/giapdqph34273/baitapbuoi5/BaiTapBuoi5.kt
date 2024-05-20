package fpoly.giapdqph34273.baitapbuoi5

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.rememberImagePainter

class BaiTapBuoi5 : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            preview()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun preview() {
    Box {
        Scaffold(
            modifier = Modifier.background(Color(0xFF262221)),
            topBar = {
                Box {
                    TopAppBar(
                        title = {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Thanh toán"
                                )
                            }
                        },

                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color("#252121".toColorInt()),
                            titleContentColor = MaterialTheme.colorScheme.onPrimary,
                            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                            actionIconContentColor = MaterialTheme.colorScheme.onSecondary
                        )
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.Black)
                            .align(Alignment.BottomCenter)
                    )

                }

            }, content = {
                GetLayout(it)
            },
            bottomBar = {
                Box {
                    BottomAppBar(
                        containerColor = Color("#262221".toColorInt())
                    ) {
                        navBar()
                    }

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.Black)
                    )
                }

            }
        )
    }
}

@Composable
fun GetLayout(
    innerPadding: PaddingValues = PaddingValues(0.dp),
) {

    val context = LocalContext.current.applicationContext


    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .background(
                    color = Color("#262221".toColorInt()),
                )
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding() + 10.dp,
                    start = 10.dp,
                    end = 10.dp,
                    bottom = 10.dp
                )
        ) {

            diaChi()


            getRowItem(
                color = Color("#fa8500".toColorInt()),
                text = "Paypal",
                image = R.drawable.paypal
            )
            getRowItem(color = Color.Red, text = "Visa", image = R.drawable.visa_icon)
            getRowItem(
                color = Color("#ec1387".toColorInt()),
                text = "Momo",
                image = R.drawable.momo_icon
            )
            getRowItem(
                color = Color("#00c2fd".toColorInt()),
                text = "Momo",
                image = R.drawable.zalopay_icon
            )


            getRowItem(
                color = Color("#18ebea".toColorInt()),
                text = "Momo",
                image = R.drawable.cod_icon
            )
        }

        Button(
            onClick = {
                Toast.makeText(context, "Đã thanh toán", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .padding(
                    bottom = innerPadding.calculateBottomPadding() + 10.dp
                )
                .align(Alignment.BottomCenter)
                .width(280.dp)
                .height(80.dp)

                .background(
                    color = Color("#ff734c".toColorInt()),
                    shape = RoundedCornerShape(15.dp)
                ),
            colors = ButtonDefaults.buttonColors(Color("#ff734c".toColorInt()))
        ) {
            Text(
                text = "Thanh toán",
                fontSize = 20.sp,
            )
        }
    }
}

@Composable
fun navBar() {
    val items = listOf("Trang chủ", "Lịch sử", "Giỏ hàng", "Hồ sơ")
    val icons = listOf(
        R.drawable.home_icon,
        R.drawable.history_icon,
        R.drawable.cart_icon,
        R.drawable.person_icon
    )
    var selectedItem by remember { mutableStateOf(items[0]) }
    Row(
        Modifier
            .background(Color(0xFF262221))
            .fillMaxWidth()
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    Image(
                        painterResource(id = icons[index]),
                        contentDescription = null,
                        Modifier
                            .height(30.dp)
                            .width(30.dp)
                    )
                },
                label = {
                    Text(
                        item,
                        color = Color.White
                    )
                },
                selected = item == selectedItem,
                onClick = { selectedItem = item }
            )
        }
    }
}

@Composable
fun diaChi() {
    Column(
        modifier = Modifier
            .padding(10.dp, 0.dp, 10.dp, 30.dp)
    ) {
        Text(
            text = "Địa chỉ nhận hàng",
            color = Color.White,
        )

        Row(
            modifier = Modifier
                .padding(5.dp)
                .height(IntrinsicSize.Max)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.vitri),
                contentDescription = "",
                Modifier
                    .height(30.dp)
                    .width(30.dp),
            )

            Column {
                Text("Tri | 2222222", color = Color.White)
                Text("22/333 đường Trung Mỹ Tây 1", color = Color.White)
                Text("phường Tân Thới Nhất", color = Color.White)
                Text("quận 12, thành phố Hồ Chí Minh", color = Color.White)
            }
        }


        Text(
            text = "Vui lòng chọn 1 trong những phương thức sau:",
            color = Color.White,
        )
    }

}

@Composable
fun getRowItem(color: Color, text: String, image: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(10.dp, 0.dp, 10.dp, 0.dp)
            .background(
                color = color,
                shape = RoundedCornerShape(10.dp)
            )
            .height(70.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            Modifier
                .height(50.dp)
                .width(50.dp)
        )

        Text(
            text = text,
            color = Color.White,
            modifier = Modifier
                .width(125.dp)
        )

        RadioButton(
            selected = false,
            onClick = { })
    }
}