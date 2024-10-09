package com.example.hackathonapp2024

import java.util.UUID

object UUIDManager{
    private var cachedUUID: String? = null

    fun getUUID(): String{
        if (cachedUUID == null) {
            cachedUUID = uuidGenerator()
        }
        return cachedUUID!!
    }
    private fun uuidGenerator(): String {
        val myUUID = UUID.randomUUID()
        return myUUID.toString()
    }
}