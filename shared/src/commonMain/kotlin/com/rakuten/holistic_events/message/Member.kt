package com.rakuten.holistic_events.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Member (
    @SerialName("guid")
    val guid: String? = null,

    @SerialName("anonymous_id")
    val anonymousID: String
)
