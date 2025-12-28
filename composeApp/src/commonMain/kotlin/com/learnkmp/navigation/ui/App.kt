package com.learnkmp.navigation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.learnkmp.navigation.todo.Task
import com.learnkmp.navigation.todo.TaskDetailScreen
import com.learnkmp.navigation.todo.TaskListScreen
import kotlinx.serialization.Serializable

@Serializable
data object TaskListKey : NavKey

@Serializable
data class TaskDetailKey(val task: Task) : NavKey

@Composable
fun App() {

    val backStack = remember { mutableStateListOf<Any>(TaskListKey) }

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<TaskDetailKey> { key ->
                TaskDetailScreen(key.task) {
                    backStack.removeLastOrNull()
                }
            }
            entry<TaskListKey> {
                TaskListScreen { task ->
                    backStack.add(TaskDetailKey(task))
                }
            }
        }
    )
}
