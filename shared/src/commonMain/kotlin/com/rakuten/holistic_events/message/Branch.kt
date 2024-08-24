package com.rakuten.holistic_events.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Branch(
    @SerialName("branch_integration")
    val branch: ReferrerData
)
