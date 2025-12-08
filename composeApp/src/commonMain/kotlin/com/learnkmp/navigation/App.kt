package com.learnkmp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.learnkmp.navigation.todo.TaskDetailScreen
import com.learnkmp.navigation.todo.TaskListScreen

//Make serializable in case you want to preserve during state change
data object TaskListKey: NavKey

data class TaskDetailsKey(val taskId: Int): NavKey

@Composable
fun App() {

    val backStack = remember { mutableStateListOf<NavKey>(TaskListKey) }

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
