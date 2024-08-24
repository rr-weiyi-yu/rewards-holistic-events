package com.rakuten.holistic_events.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Device (
    @SerialName("manufacturer")
    val manufacturer: String?,

    @SerialName("platform")
    val platform: String?,

    @SerialName("idfv")
    val idfv: String?,

    @SerialName("model")
    val model: String?,

    @SerialName("type")
    val type: String?,

    @SerialName("advertising_id")
    val advertisingID: String?,

    @SerialName("brand")
    val brand: String?,

    @SerialName("form_factor")
    val formFactor: String,

    @SerialName("family")
    val family: String
)
