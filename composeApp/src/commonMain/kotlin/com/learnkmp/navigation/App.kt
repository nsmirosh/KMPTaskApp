package com.learnkmp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.learnkmp.navigation.todo.TaskDetailScreen
import com.learnkmp.navigation.todo.TaskListScreen

data object TaskListKey
data class TaskDetailsKey(val taskId: Int)

@Composable
fun App() {

    val backStack = remember { mutableStateListOf<Any>(TaskListKey) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<TaskDetailsKey> { key ->
                TaskDetailScreen(key.taskId) {
                    backStack.removeLastOrNull()
                }
            }
            entry<TaskListKey> {
                TaskListScreen {
                    backStack.add(TaskDetailsKey(it))
                }
            }
        }
    )
}
