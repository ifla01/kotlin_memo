package com.ina.board.di

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel: ViewModel() {

    private val _todo: MutableLiveData<String> = MutableLiveData()
    val todo: LiveData<String> get() = _todo

    fun onTodoChange(newTodo: String) {
        _todo.value = newTodo
    }
}