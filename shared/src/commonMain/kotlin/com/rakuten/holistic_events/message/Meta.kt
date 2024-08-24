package com.rakuten.holistic_events.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName("operation")
    val operation: Operation
)
