package com.rakuten.holistic_events.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OS (
    @SerialName("name")
    val name: String,
    @SerialName("version")
    val version: String
)
