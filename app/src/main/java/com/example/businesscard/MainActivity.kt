package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .offset(y = (-80).dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val image = painterResource(id = R.drawable.carat)
            Image(
                painter = image,
                contentDescription = "Android Logo",
                modifier = Modifier
                    .height(150.dp)
                    .width(200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Suci Ihtisabi Hida Nursyifa", color = Color.Black, fontSize = 28.sp)
            Text(text = "Computer Science Student", color = Color(0xFF8972C0), fontSize = 18.sp)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            ContactInfoRow(
                iconId = R.drawable.ic_phone,
                contactText = "+62 857 xxxx xxxx"
            )

            ContactInfoRow(
                iconId = R.drawable.ic_email,
                contactText = "sucinursyifa064@gmail.com"
            )

            ContactInfoRow(
                iconId = R.drawable.ic_location,
                contactText = "Bandung, Indonesia"
            )
        }
    }
}

@Composable
fun ContactInfoRow(iconId: Int, contactText: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val icon = painterResource(id = iconId)
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = contactText,
            color = Color.Black,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
