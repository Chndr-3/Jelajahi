package com.example.jelajah.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.jelajah.data.ResponseItem
import com.example.jelajah.ui.viewmodel.MainViewModel
import com.example.myapplication.ui.theme.Purple40
import com.example.myapplication.ui.theme.Purple80
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryCard(country: ResponseItem, navHostController: NavHostController, viewModel: MainViewModel) {

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        onClick = {
            viewModel.addCountry(country)
            navHostController.navigate("detail")
        },
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(country.flags.png),
                contentDescription = null,
                modifier = Modifier
                    .size(128.dp)
                    .fillMaxWidth()
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = country.name.common,
                    style = TextStyle(
                        color = Purple40,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
                Text(
                    text = "(${country.name.official})",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                )
            }

            // Add more details as needed
        }
    }
}
