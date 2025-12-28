package com.learnkmp.navigation.di

import com.learnkmp.navigation.data.TaskRepository
import com.learnkmp.navigation.data.TaskRepositoryImpl
import com.learnkmp.navigation.ui.TaskViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val appModule = module {
    viewModelOf(::TaskViewModel)
    singleOf(::TaskRepositoryImpl) { bind<TaskRepository>() }
}