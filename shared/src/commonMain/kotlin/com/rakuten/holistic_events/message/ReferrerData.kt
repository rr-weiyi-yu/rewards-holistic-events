package com.rakuten.holistic_events.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReferrerData(
    @SerialName("referrer")
    val referrer: String?,

    @SerialName("referring_link")
    val referringLink: String?
)
