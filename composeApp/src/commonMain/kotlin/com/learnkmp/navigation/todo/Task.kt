package com.learnkmp.navigation.todo

enum class Priority { LOW, MEDIUM, HIGH }

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Priority,
    val completed: Boolean
)