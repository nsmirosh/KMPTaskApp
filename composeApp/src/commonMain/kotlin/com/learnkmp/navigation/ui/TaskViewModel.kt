package com.learnkmp.navigation.ui

import androidx.lifecycle.ViewModel
import com.learnkmp.navigation.data.TaskRepository
import com.learnkmp.navigation.data.TaskRepositoryImpl

class TaskViewModel() : ViewModel() {
    private val taskRepository: TaskRepository = TaskRepositoryImpl()

    val tasks = taskRepository.getTasks()
}