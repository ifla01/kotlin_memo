package com.ina.board

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.ina.board.di.TodoViewModel
import com.ina.board.ui.Main

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]
            Main()
        }
    }

    companion object {
        lateinit var todoViewModel: TodoViewModel
    }
}