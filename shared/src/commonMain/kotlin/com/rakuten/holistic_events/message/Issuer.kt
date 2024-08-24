package com.rakuten.holistic_events.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Issuer (
    @SerialName("name")
    val name: String,
    @SerialName("version")
    val version: String,
    @SerialName("type")
    val type: String
)
