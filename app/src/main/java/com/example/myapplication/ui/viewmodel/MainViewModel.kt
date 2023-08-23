package com.example.jelajah.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.jelajah.data.ResponseItem
import com.example.jelajah.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _loadingState: MutableState<Boolean> = mutableStateOf(false)
    val loadingState: State<Boolean> get() = _loadingState

    private val _countries: MutableStateFlow<List<ResponseItem>> = MutableStateFlow(listOf());
    val countries: StateFlow<List<ResponseItem>> get() = _countries;

    private val _filteredCountries: MutableStateFlow<List<ResponseItem>> =
        MutableStateFlow(listOf());
    val filteredCountries: StateFlow<List<ResponseItem>> get() = _filteredCountries;

    private var _onFiltered by mutableStateOf(false)
    val onFiltered: Boolean
        get() = _onFiltered

    var country by mutableStateOf<ResponseItem?>(value = null)
        private set

    init {
        fetchCountryData();

    }

    fun addCountry(detailCountry: ResponseItem) {
        country = detailCountry
    }

    fun filterByAlphabeticDesc() {
        viewModelScope.launch {
            _onFiltered = true
            _filteredCountries.value = _countries.value.sortedBy {
                it.name.common
            }
        }
    }
    fun filterByAlphabeticAsc() {
        viewModelScope.launch {
            _onFiltered = true
            _filteredCountries.value = _countries.value.sortedByDescending {
                it.name.common
            }
        }
    }


    fun default(){
        viewModelScope.launch{
            _filteredCountries.value = _countries.value
        }
    }

    fun filterByQuery(text: String) {

        viewModelScope.launch {
            _onFiltered = true
            _filteredCountries.value =
                _countries.value.filter { it.name.common.contains(text, ignoreCase = true) }
        }
    }


    fun fetchCountryData() {
        viewModelScope.launch {
            _loadingState.value = true
            val call: Call<List<ResponseItem>> = RetrofitClient.apiService.getAllCountryData()

            call.enqueue(object : Callback<List<ResponseItem>> {
                override fun onResponse(
                    call: Call<List<ResponseItem>>,
                    response: Response<List<ResponseItem>>
                ) {
                    if (response.isSuccessful) {
                        val country: List<ResponseItem>? = response.body()
                        if (country != null) {
                            _loadingState.value = false
                            _countries.value = country
                        }
                    } else {
                        _loadingState.value = false
                        println("Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                    println("Error: ${t.message}")
                }
            })
        }
    }
}

class CountryViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}