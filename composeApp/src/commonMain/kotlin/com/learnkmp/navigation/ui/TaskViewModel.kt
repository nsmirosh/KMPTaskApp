package com.learnkmp.navigation.ui

import androidx.lifecycle.ViewModel
import com.learnkmp.navigation.data.TaskRepository

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {
    val tasks = taskRepository.getTasks()
}