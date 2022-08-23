package com.ina.board.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ina.board.MainActivity.Companion.todoViewModel

@Composable
fun Main(
) {

    var isDialog by remember { mutableStateOf(false) }
    val data: String by todoViewModel.todo.observeAsState("")

    if (isDialog) {
        Log.d("dialog", "$isDialog")
        TodoInputDialog(
            action = { isDialog = false },
            disAction = { isDialog = false },
        )
    }
    Log.d("dialog", "$isDialog")
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
                    isDialog = true
                    Log.d("dialog", "$isDialog")
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
                Text(text = data)
            }
        }
    }
}