package com.example.exercise2

import androidx.lifecycle.ViewModel
import com.example.exercise2.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUiState())
    val stateUI: StateFlow<OrderUiState> = _stateUI.asStateFlow()

    fun setContact(listContact: MutableList<String>){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = listContact[0],
                nim = listContact[1],
                konsetrasi = listContact[2],
                judul = listContact[3]
            )
        }
    }
    fun setDosen1(dosenPilihan : String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(dosen1 = dosenPilihan)
        }
    }

}