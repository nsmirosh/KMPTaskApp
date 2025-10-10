package com.learnkmp.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.learnkmp.navigation.todo.TaskDetailScreen
import com.learnkmp.navigation.todo.TaskListScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "tasks") {
            composable("tasks") {
                TaskListScreen(onTaskClick = { id ->
                    navController.navigate("task/$id")
                })
            }
            composable(
                route = "task/{taskId}",
                arguments = listOf(navArgument("taskId") { type = NavType.IntType })
            ) { backStackEntry ->
                val taskId = backStackEntry.arguments?.getInt("taskId") ?: return@composable
                TaskDetailScreen(taskId = taskId)
            }
        }
    }
}