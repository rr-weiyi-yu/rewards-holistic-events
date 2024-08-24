package com.rakuten.holistic_events.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClientContext(
    @SerialName("origin")
    val origin: Origin?,
    @SerialName("device")
    val device: Device?,
    @SerialName("locale")
    val locale: String?,
)
