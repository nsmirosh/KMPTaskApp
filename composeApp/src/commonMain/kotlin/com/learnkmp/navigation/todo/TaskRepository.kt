package com.learnkmp.navigation.todo

object TaskRepository {
    val tasks: List<Task> = listOf(
        Task(1, "Buy groceries", "Milk, eggs, bread, and fruits.", Priority.MEDIUM, false),
        Task(2, "Morning workout", "30 minutes of cardio and stretching.", Priority.HIGH, true),
        Task(3, "Read a book", "Read 20 pages of a novel.", Priority.LOW, false),
        Task(4, "Team meeting", "Weekly sync with the team at 10 AM.", Priority.HIGH, true),
        Task(5, "Write blog post", "Draft a post about Compose Multiplatform.", Priority.MEDIUM, false),
        Task(6, "Pay bills", "Electricity and internet bills.", Priority.HIGH, false),
        Task(7, "Clean workspace", "Organize desk and files.", Priority.LOW, true),
        Task(8, "Call parents", "Catch up with family in the evening.", Priority.MEDIUM, false),
        Task(9, "Fix bug #123", "Investigate and fix crash on iOS startup.", Priority.HIGH, false),
        Task(10, "Plan weekend trip", "Find a hiking trail and prepare checklist.", Priority.LOW, false)
    )

    fun getTaskById(id: Int): Task? = tasks.find { it.id == id }
}