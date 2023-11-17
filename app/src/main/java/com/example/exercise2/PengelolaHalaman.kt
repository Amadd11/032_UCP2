package com.example.exercise2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class PengelolaHalaman{
    Home,
    Form,
    Detail
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulir(
    viewModel: OrderViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController()
){
    Scaffold { innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(PengelolaHalaman.Home.name){
                HalamanHome(onNextButtonClicked = {
                    navController.navigate(PengelolaHalaman.Form.name)
                })
            }
            composable(PengelolaHalaman.Form.name){
                HalamanSatu(onSubmitButtonClicked = {
                    viewModel.setContact(it)
                    navController.navigate(PengelolaHalaman.Form.name)
                })
            }
        }
    }

}