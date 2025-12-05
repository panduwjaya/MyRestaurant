package com.example.myrestaurant.ui.screen.customer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myrestaurant.R
import com.example.myrestaurant.data.model.RegisterCustomerResponse
import com.example.myrestaurant.util.Result

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerScreenContent(
    name: String,
    phone: String,
    onNameChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    onBackClick: () -> Unit,
    onRegisterClick: () -> Unit,
    registerCustomerResult: Result<RegisterCustomerResponse>?,
    onRegisterCustomerSuccess: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Insert Your Information",
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
                .padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column {

                // Input Name
                OutlinedTextField(
                    value = name,
                    onValueChange = onNameChange,
                    placeholder = { Text("Input Your Name", color = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFE0E0E0), RoundedCornerShape(8.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFE0E0E0),
                        unfocusedContainerColor = Color(0xFFE0E0E0),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Input Phone
                OutlinedTextField(
                    value = phone,
                    onValueChange = onPhoneChange,
                    placeholder = { Text("Input Your Number Phone", color = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFE0E0E0), RoundedCornerShape(8.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFE0E0E0),
                        unfocusedContainerColor = Color(0xFFE0E0E0),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
            }

            // Register Button
            Button(
                onClick = onRegisterClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(32.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF74D47B))
            ) {
                Text(
                    text = "Regist",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            when (registerCustomerResult) {
                is Result.Loading -> CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
                is Result.Success -> LaunchedEffect(Unit) { onRegisterCustomerSuccess() }
                is Result.Error -> Text(
                    (registerCustomerResult as Result.Error).error,
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
                else -> Unit
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomerScreenContentPreview() {
    CustomerScreenContent(
        name = "",
        phone = "",
        onNameChange = {},
        onPhoneChange = {},
        onBackClick = {},
        onRegisterClick = {},
        onRegisterCustomerSuccess = {},
        registerCustomerResult = null
    )
}