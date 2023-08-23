package com.example.myapplication.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.jelajah.ui.viewmodel.MainViewModel
import com.example.myapplication.ui.theme.Purple40
import com.example.myapplication.ui.theme.Purple80


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(viewModel: MainViewModel, navController: NavController) {
    val country = viewModel.country
    Scaffold(topBar = {
        Surface(shadowElevation = 6.dp) {
            CenterAlignedTopAppBar(title = { Text("Detail Negara") }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            })
        }
    }) {
        Column(verticalArrangement = Arrangement.Top, modifier = Modifier.padding(it).fillMaxSize()) {


            Image(
                painter = rememberAsyncImagePainter(country?.flags?.png ?: "https://flagcdn.com/w320/za.png"),
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )


                Column(Modifier.padding(10.dp).fillMaxWidth()) {
                    Text(
                        country?.name?.common ?: "Country Name" ,
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Purple40
                        )
                    )
                    Text(
                        "(${country?.name?.official ?: "Country Name"})",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Purple80
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CountryInformationRow(label = "Capital", value = country?.capital?.get(0) ?: "Currencies")
                    CountryInformationRow(label = "Population", value = country?.population.toString())
            }

        }
    }

}

@Composable
fun CountryInformationRow(label: String, value : String){
    Row (Modifier.fillMaxWidth(0.7f), horizontalArrangement = Arrangement.SpaceBetween){
        Text(label, modifier = Modifier.weight(2f))
        Text(":",modifier = Modifier.weight(0.5f))
        Text(value,modifier = Modifier.weight(2f))
    }
}
@Preview
@Composable
fun MyComposablePreview() {
    val viewModel = MainViewModel()
    val navController = rememberNavController()
    DetailScreen(viewModel = viewModel, navController)
}






