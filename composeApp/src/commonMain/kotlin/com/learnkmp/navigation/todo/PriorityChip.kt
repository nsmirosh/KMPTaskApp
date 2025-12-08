package com.learnkmp.navigation.todo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PriorityChip(priority: Priority) {
    val bg = when (priority) {
        Priority.HIGH -> Color(0xFFFFE5E5)
        Priority.MEDIUM -> Color(0xFFFFF3CD)
        Priority.LOW -> Color(0xFFE7F5E9)
    }
    val fg = when (priority) {
        Priority.HIGH -> Color(0xFFB00020)
        Priority.MEDIUM -> Color(0xFF8A6D3B)
        Priority.LOW -> Color(0xFF2E7D32)
    }
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(bg)
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(text = "Priority: ${priority.name}", color = fg, style = MaterialTheme.typography.labelLarge)
    }
}
