package com.example.myrestaurant.ui.screen.order

import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myrestaurant.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsertOrderScreenContent(
    selectedCustomer: String,
    selectedTable: String,
    menu: String,
    onMenuChange: (String) -> Unit,
    onCustomerClick: () -> Unit,
    onTableClick: () -> Unit,
    onBack: () -> Unit,
    onOrderClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Insert Order",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    ) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Restaurant Logo",
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF74D47B),
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {

                DropdownCard(
                    label = selectedCustomer.ifEmpty { "Choose Your Customer" },
                    onClick = onCustomerClick
                )

                DropdownCard(
                    label = selectedTable.ifEmpty { "Insert Your Table Number" },
                    onClick = onTableClick
                )

                MenuDropdown(
                    menu = menu,
                    onMenuChange = onMenuChange
                )
            }

            Button(
                onClick = onOrderClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF74D47B)
                )
            ) {
                Text(
                    text = "Order",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun DropdownCard(
    label: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD9D9D9)
        )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = label,
                color = Color.Gray,
                fontSize = 15.sp
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_dropdown),
                contentDescription = "Restaurant Logo",
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuDropdown(
    menu: String,
    onMenuChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val genderOptions = listOf("Bakso", "Mie Ayam")

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = menu,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text("Insert Your Menu", color = Color.Gray) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .padding(12.dp,12.dp,12.dp,12.dp)
                .menuAnchor()
                .height(56.dp),

            // --- BAGIAN YANG DIPERBAIKI ---
            colors = OutlinedTextFieldDefaults.colors(
                // Di Material 3, gunakan focusedContainerColor & unfocusedContainerColor
                focusedContainerColor = Color(0xFFD9D9D9),
                unfocusedContainerColor = Color(0xFFD9D9D9),
                disabledContainerColor = Color(0xFFD9D9D9),

                // Border colors
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            ),
            // ------------------------------

            shape = RoundedCornerShape(8.dp),
            singleLine = true
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            genderOptions.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onMenuChange(option)
                        expanded = false
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun InsertOrderScreenContentPreview() {
    InsertOrderScreenContent(
        selectedCustomer = "",
        selectedTable = "",
        menu = "",
        onMenuChange = {},
        onCustomerClick = {},
        onTableClick = {},
        onBack = {},
        onOrderClick = {}
    )
}