package com.rakuten.holistic_events.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EventingResponse(
    @SerialName("data")
    val data: List<EventData>? = null,
    @SerialName("meta")
    val meta: Meta? = null
)
