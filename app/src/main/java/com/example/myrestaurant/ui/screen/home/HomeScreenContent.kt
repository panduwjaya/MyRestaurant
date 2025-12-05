package com.example.myrestaurant.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.myrestaurant.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    onAddClick: () -> Unit,
    onCustomerRegisterClick: () -> Unit,
    innerPadding: PaddingValues = PaddingValues(),
    isEmpty: Boolean = true
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF74D47B)
                )
            )
        },

        floatingActionButton = {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.End
            ) {

                // Tombol untuk Customer Register
                FloatingActionButton(
                    onClick = onCustomerRegisterClick,
                    containerColor = Color.White,
                    contentColor = Color(0xFF6FC971)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_customer),
                        contentDescription = "Customer Register"
                    )
                }

                // Tombol untuk Add Order
                FloatingActionButton(
                    onClick = onAddClick,
                    containerColor = Color.White,
                    contentColor = Color(0xFF6FC971)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add_order),
                        contentDescription = "Add Order"
                    )
                }
            }
        }

    ) { scaffoldPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(scaffoldPadding),
            contentAlignment = Alignment.Center
        ) {
            if (isEmpty) {
                Text(
                    text = "Wellcome,please Order",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            } else {
                // Tempat untuk konten list nanti
                Text("Items Loaded")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenContentPreview() {
    HomeScreenContent(
        onAddClick = {},
        onCustomerRegisterClick = {}
    )
}