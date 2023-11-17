package com.example.exercise2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    onSubmitButtonClicked : (MutableList<String>) -> Unit,
){
    var nama by rememberSaveable { mutableStateOf(value = "") }
    var nim by rememberSaveable { mutableStateOf(value = "") }
    var konsentasi by rememberSaveable { mutableStateOf(value = "") }
    var judul by rememberSaveable { mutableStateOf(value = "") }
    var dosenPembimbing1 by rememberSaveable { mutableStateOf(value = "") }
    var dosenPembimbing2 by rememberSaveable { mutableStateOf(value = "") }

    var listData: MutableList<String> = mutableListOf(nama, nim, konsentasi, judul)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()) {
        Text(text = "Formulir Pengajuan Skripsi",
            textAlign = TextAlign.Center,
            fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            label = { Text(text = "Nama") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp))
        OutlinedTextField(
            value = nim,
            onValueChange = {nim = it},
            label = { Text(text = "NIM") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp))
        OutlinedTextField(
            value = konsentasi,
            onValueChange = {konsentasi = it},
            label = { Text(text = "Konsentrasi") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp))
        OutlinedTextField(
            value = judul,
            onValueChange = {judul = it},
            label = { Text(text = "Judul Skripsi") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp))
        Button(
            modifier = Modifier,
            onClick = { onSubmitButtonClicked(listData) }) {
            Text(text = stringResource(id = R.string.btn_submit))
        }
    }
}