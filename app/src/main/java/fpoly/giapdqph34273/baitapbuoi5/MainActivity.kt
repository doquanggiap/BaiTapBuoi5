package fpoly.giapdqph34273.lab3_ph34273

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import fpoly.giapdqph34273.baitapbuoi5.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            preview()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun preview() {
    GetLayout(title = "Thanh toán")
}

@Composable
fun GetLayout(title: String) {

    Column(
        modifier = Modifier
            .background(
                color = Color(0xff262221)
            )
            .fillMaxSize()
    ) {
        GetTextTitle(title = title)

        duongKeNgang()

        diaChi()


        getRowItem(
            Color(0xFFFA8500),
            "Paypal",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbwPS9eOLfOLJQFma_sVLpO6Ptu3bW9ad6KMhgBAjxmQ&s"
        )
        getRowItem(
            Color.White,
            "Visa",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYPkrXl2UNqKdOlijbtcwzD4LG5DgGiY25i6tqarWsbQ&s"
        )
        getRowItem(
            Color(0xffec1287),
            "Momo",
            "https://upload.wikimedia.org/wikipedia/vi/f/fe/MoMo_Logo.png"
        )
        getRowItem(
            Color(0xff01c2fe),
            "Zalo Pay",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0Q61cmN0yQskrPTA_TUyiPbeH6wp1AffnFvTWSFVgmw&s"
        )
        getRowItem(
            Color(0xff1aebeb),
            "Thanh toán trực tiếp",
            "https://cdn.tgdd.vn/hoi-dap/1307810/ship-cod-la-gi-uu-nhuoc-diem-ra-sao-quy-trinh-mua-chuyen2%20copy.jpg"
        )

        nutThanhToan()

        navBar()


    }
}

@Composable
private fun duongKeNgang() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = Color.Black,
                shape = RoundedCornerShape(10.dp)
            )
            .height(5.dp)
            .fillMaxWidth()
    ) {}
}

@Composable
fun navBar() {
    Column(
        modifier = Modifier
            .padding(0.dp, 190.dp, 0.dp, 0.dp)
    ) {
        duongKeNgang()

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {

            navItem(image = R.drawable.home_icon, title = "Trang chủ")
            navItem(image = R.drawable.history_icon, title = "Lịch sử")
            navItem(image = R.drawable.cart_icon, title = "Giỏ hàng")
            navItem(image = R.drawable.person_icon, title = "Hồ sơ")


        }
    }


}

@Composable
fun navItem(image: Int, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            Modifier
                .height(30.dp)
                .width(30.dp)
        )

        Text(
            text = title,
            color = Color.White,
            modifier = Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp)
        )
    }
}

@Composable
fun nutThanhToan() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(Color(0xffff734c)),
        modifier = Modifier
            .offset(30.dp, 10.dp)
            .width(340.dp)
    ) {
        Text("Thanh toán")
    }
}

@Composable
private fun diaChi() {
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
            AsyncImage(
                url = "https://cdn-icons-png.flaticon.com/512/4781/4781517.png",
                Modifier
                    .height(30.dp)
                    .width(30.dp)
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
private fun getRowItem(color: Color, text: String, image: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(10.dp, 5.dp, 10.dp, 5.dp)
            .background(
                color = color,
                shape = RoundedCornerShape(10.dp)
            )
            .height(50.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            url = image,
            Modifier
                .height(50.dp)
                .width(50.dp)
                .padding(10.dp, 0.dp, 0.dp, 0.dp)
        )
        Text(
            text = text,
            modifier = Modifier
                .padding(90.dp, 0.dp, 0.dp, 0.dp)
                .width(130.dp),
        )
        RadioButton(
            selected = false,
            modifier = Modifier.padding(50.dp, 0.dp, 10.dp, 0.dp),
            onClick = { })
    }
}

@Composable
fun AsyncImage(url: String, modifier: Modifier = Modifier) {
    Image(
        painter = rememberImagePainter(data = url),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
private fun GetTextTitle(title: String) {
    Text(
        title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        fontSize = 20.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}