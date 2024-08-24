package com.rakuten.holistic_events.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EventingRequest(
    @SerialName("messages")
    val messages: List<Message?>,
    @SerialName("verbose")
    val verbose: Boolean = true
)
