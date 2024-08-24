package com.rakuten.holistic_events.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Origin (
    @SerialName("app")
    val app: Issuer,
    @SerialName("screen")
    val screen: Screen?,
    @SerialName("os")
    val os: OS?,
    @SerialName("user_agent")
    val userAgent: String
)
