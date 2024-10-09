package com.example.hackathonapp2024.data

import kotlinx.serialization.Serializable


@Serializable
data class DataModel(
    val app: String,
    val id: String,
)
