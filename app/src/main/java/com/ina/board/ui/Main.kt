package com.ina.board.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun Main() {
    MaterialTheme (
            ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Top App Bar")
                    },
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = Color.White,
                    elevation = 10.dp
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    DialogUI()
                }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text ="Hello World")
            }
        }
    }
}

@Composable
fun DialogUI() {
    val shouldShowDialog = remember { mutableStateOf(true) } `

    if (shouldShowDialog.value) {
        AlertDialog(onDismissRequest = { shouldShowDialog.value = false },
            title = { Text(text = "Dialog") },
            text = { Text(text = "This is jetpack dialog") },
            confirmButton = {
                Button(
                    onClick = { shouldShowDialog.value = false },
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.vector_tint_color,))
                ) {
                    Text(text = "Close", color = Color.White)
                }
            }
        )
    }
}