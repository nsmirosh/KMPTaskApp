package com.learnkmp.navigation

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform