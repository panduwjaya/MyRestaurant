package com.example.myrestaurant.ui.screen.listorder

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun ListOrderScreenContent(
    orders: List<String>,
    onBackClick: () -> Unit,
    onAddClick: () -> Unit,
    onDeleteClick: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Order List",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    ) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Restaurant Logo",
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6BCB77),
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddClick,
                containerColor = Color(0xFFFFFFFF),
                contentColor = Color(0xFF6FC971)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_order),
                    contentDescription = "Restaurant Logo",
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            orders.forEach { order ->
                OrderItemCard(
                    title = "Pesanan",
                    subtitle = order,
                    onDelete = { onDeleteClick(order) }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

// fungsi untuk pembuatn ItemCard
@Composable
fun OrderItemCard(
    title: String,
    subtitle: String,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE5E5E5))
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Bagian kiri
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_food),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                    tint = Color.Black
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    Text(
                        text = subtitle,
                        color = Color.Gray,
                        fontSize = 13.sp
                    )
                }
            }

            // Ikon Trash di kanan
            Image(
                painter = painterResource(id = R.drawable.ic_trash),
                contentDescription = "Delete",
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onDelete() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListOrderScreenContentPreview() {
    ListOrderScreenContent(
        orders = listOf("Ayam Goreng", "Nasi Goreng", "Sate Ayam"),
        onBackClick = {},
        onAddClick = {},
        onDeleteClick = {}
    )
}