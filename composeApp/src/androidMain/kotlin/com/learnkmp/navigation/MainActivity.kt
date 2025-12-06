package com.learnkmp.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.learnkmp.navigation.todo.TaskDetailScreen
import com.learnkmp.navigation.todo.TaskListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            BasicActivity()
        }
    }
}

data object TaskListKey
data class TaskDetailsKey(val taskId: Int)

@Composable
fun BasicActivity() {

    val backStack = remember { mutableStateListOf<Any>(TaskListKey) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<TaskDetailsKey> { key ->
                TaskDetailScreen(key.taskId)
            }
            entry<TaskListKey> {
                TaskListScreen {
                    backStack.add(TaskDetailsKey(it))
                }
            }
        }
    )
}
