package com.learnkmp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.learnkmp.navigation.todo.TaskDetailScreen
import com.learnkmp.navigation.todo.TaskListScreen
import kotlinx.serialization.Serializable

@Serializable
data object TaskListKey: NavKey

@Serializable
data class TaskDetailKey(val taskId: Int): NavKey

@Composable
fun App() {


    val backStack = remember { mutableStateListOf<Any>(TaskListKey)}

    NavDisplay(
       backStack = backStack,
        entryProvider = entryProvider {
            entry<TaskDetailKey> { key ->
                TaskDetailScreen(key.taskId) {
                    backStack.removeLastOrNull()
                }
            }
           entry<TaskListKey> {
               TaskListScreen { taskId ->
                   backStack.add(TaskDetailKey(taskId))
               }
           }
        }
    )
}
