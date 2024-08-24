package com.rakuten.holistic_events.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EventData(
    @SerialName("message_id")
    val messageID: String,

    @SerialName("error_code")
    val errorCode: String,

    @SerialName("error_message")
    val errorMessage: String
)
