package com.example.myapplication.ui.screen


import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jelajah.data.ResponseItem
import com.example.jelajah.ui.theme.CountryCard
import com.example.jelajah.ui.viewmodel.MainViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navHostController: NavHostController, viewModel: MainViewModel) {
    val countries by viewModel.countries.collectAsState()
    val filteredCountries by viewModel.filteredCountries.collectAsState()
    val onFilteredValue = viewModel.onFiltered
    val loadingState by viewModel.loadingState
    var query by remember { mutableStateOf("") }
    var onSearch by remember { mutableStateOf(false) }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        Modifier
            .fillMaxSize(),
        topBar = {


            SearchTopApp(

                visible = onSearch,
                viewModel = viewModel,
                text = query,
                onQuery = { query = it },
                iconOnClick = { onSearch = false }, listState = listState
            )


            CustomTopApp(viewModel = viewModel, { onSearch = true }, visible = !onSearch)

        }, floatingActionButton = {
            AnimatedVisibility(visible = listState.isScrolled, enter = fadeIn(), exit = fadeOut()) {
                FloatingActionButton(onClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(index = 0)
                    }

                }) {
                    Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "Up")
                }
            }
        }
    ) {
        SwipeRefresh(
            state = SwipeRefreshState(isRefreshing = loadingState),
            onRefresh = { viewModel.fetchCountryData() }) {
            CountryList(

                listState = listState,
                countries = if (!onFilteredValue) {
                    countries
                } else {
                    filteredCountries
                },
                isLoading = loadingState,
                modifier = Modifier
                    .padding(it),
                navController = navHostController,
                viewModel = viewModel


            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SearchTopApp(
    viewModel: MainViewModel,
    text: String,
    onQuery: (String) -> Unit,
    iconOnClick: () -> Unit,
    visible: Boolean,
    listState: LazyListState
) {

    AnimatedVisibility(
        visible = visible,
        enter = scaleIn(animationSpec = tween(300, easing = FastOutLinearInEasing)),
        exit = scaleOut(
            tween(300)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .animateContentSize(animationSpec = tween(durationMillis = 300))
                .height(height = if (listState.isScrollInProgress) 0.dp else 56.dp)
        ) {
            TextField(
                placeholder = { Text("Search Country by Name") },
                shape = RoundedCornerShape(60.dp),
                modifier = Modifier.weight(10f),
                value = text,
                onValueChange = onQuery,
                keyboardActions = KeyboardActions(
                    onDone = {
                        viewModel.filterByQuery(text) // Call your ViewModel function
                    }
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                trailingIcon = {
                    IconButton(onClick = { viewModel.filterByQuery(text) }) {
                        Icon(Icons.Filled.Search, contentDescription = "Close")
                    }
                },
                colors = TextFieldDefaults.colors(

                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent

                )

            )
            IconButton(onClick = iconOnClick, modifier = Modifier.weight(1f)) {
                Icon(Icons.Filled.Close, contentDescription = "Close")
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun CustomTopApp(
    viewModel: MainViewModel,
    onClick: () -> Unit,
    visible: Boolean,
) {

    var expanded by remember { mutableStateOf(false) }
    AnimatedVisibility(
        visible = visible,
        enter = scaleIn(animationSpec = tween(300, easing = FastOutLinearInEasing)),
        exit = scaleOut(
            tween(300)
        )
    ) {
        Surface(
            shadowElevation = 10.dp,
        ) {
            CenterAlignedTopAppBar(title = { Text("Jelajahi") }, actions = {
                IconButton(onClick = onClick) {
                    Icon(Icons.Filled.Search, contentDescription = "Search")
                }
                IconButton(onClick = { expanded = true }) {
                    Icon(Icons.Default.Menu, contentDescription = "Search")
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        },
                    ) {
                        DropdownMenuItem(
                            text = { Text("Filter by Alphabetic A-Z") },
                            onClick = { viewModel.filterByAlphabeticDesc() }
                        )
                        DropdownMenuItem(
                            text = { Text("Filter by Alphabetic Z-A") },
                            onClick = { viewModel.filterByAlphabeticAsc() }
                        )
                        DropdownMenuItem(
                            text = { Text("Return to Default") },
                            onClick = { viewModel.default() }
                        )

                    }
                }
            })
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CountryList(
    countries: List<ResponseItem>,
    isLoading: Boolean,
    modifier: Modifier,
    navController: NavHostController,
    viewModel: MainViewModel,
    listState: LazyListState
) {

    AnimatedVisibility(visible = isLoading, enter = fadeIn(), exit = fadeOut()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White) // Background color if needed
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    AnimatedVisibility(
        !isLoading,
        enter = slideInHorizontally(animationSpec = tween(300), initialOffsetX = { -300 }),
        exit = fadeOut()
    ) {

        LazyColumn(

            state = listState,
            modifier = modifier,
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(items = countries, key = { it.name.common }) { country ->
                Box(Modifier.animateItemPlacement(animationSpec = tween(durationMillis = 1000))) {
                    CountryCard(country, navController, viewModel)
                }
            }

        }
    }

}

val LazyListState.isScrolled: Boolean
    get() = firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0