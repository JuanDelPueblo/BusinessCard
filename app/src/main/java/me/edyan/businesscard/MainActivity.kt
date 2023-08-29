package me.edyan.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.edyan.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardLayout()
                }
            }
        }
    }
}

@Composable
fun BusinessCardLayout() {
    val image = painterResource(id = R.drawable.profile_picture)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            Modifier
            .weight(2f, fill = true)
        )
        PersonalInformation(
            image = image,
            name = "Juan Del Pueblo",
            title = "Software Engineer",
            modifier = Modifier
                .weight(3f, fill = true)
                .fillMaxWidth()
        )
        Spacer(
            Modifier
                .weight(2f, fill = true)
        )
        ContactInformation(
            phone = "+1 (787) 000 - 0000",
            social = "@JuanDelPueblo",
            email = "juan@delpueblo.me",
            modifier = Modifier
                .weight(2f, fill = true)
        )
    }
}

@Composable
fun PersonalInformation(image: Painter, name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = "Picture of the subject",
            modifier = Modifier
                .height(192.dp)
                .width(192.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    }
}

@Composable
fun ContactInformation(phone: String, social: String, email: String, modifier: Modifier = Modifier) {
    Column(modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                Icons.Default.Call,
                contentDescription = "Phone Number: ",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = phone,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                Icons.Default.AccountCircle,
                contentDescription = "Social Username: ",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = social,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                Icons.Default.Email,
                contentDescription = "Email Address: ",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = email,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardLayout()
    }
}