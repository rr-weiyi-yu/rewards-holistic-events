package com.rakuten.holistic_events.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Operation(
    @SerialName("timing")
    val timing: String,

    @SerialName("request_id")
    val requestID: String
)
