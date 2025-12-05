package com.example.myrestaurant.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myrestaurant.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenContent(
    numberOrder: String,
    name: String,
    tableNumber: String,
    foodOrder: String,
    onBackClick: () -> Unit,
    onCloseClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detail",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Restaurant Logo",
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF74D47B)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            // BOX DETAIL
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE0E0E0), RoundedCornerShape(12.dp))
                    .padding(20.dp)
            ) {

                DetailRow(label = "Number Order", value = numberOrder)
                DetailRow(label = "Name", value = name)
                DetailRow(label = "Tables Number", value = tableNumber)
                DetailRow(label = "Food Order", value = foodOrder)
            }

            // CLOSE BUTTON
            Button(
                onClick = onCloseClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF74D47B))
            ) {
                Text(
                    text = "Close",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "$label :", fontWeight = FontWeight.SemiBold, color = Color.Black)
        Text(text = value, color = Color.Black)
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenContentPreview() {
    DetailScreenContent(
        numberOrder = "",
        name = "",
        tableNumber = "",
        foodOrder = "",
        onBackClick = {},
        onCloseClick = {}
    )
}