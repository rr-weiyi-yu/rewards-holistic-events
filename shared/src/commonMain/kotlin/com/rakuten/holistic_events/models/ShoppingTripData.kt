package com.rakuten.holistic_events.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author William Yu on July 29, 2024
 *         Copyright (C) 2024 Rakuten Rewards. All rights reserved.
 *
 * Data common to all events in a shopping trip.
 *
 * @property trackingTicket The id of the tracking ticket for the shopping trip.
 * @property store The store at which the member is shopping.
 */
interface ShoppingTripData {
    val trackingTicket: String
    val store: Store
}

@Serializable
data class Store(
    @SerialName("id")
    val id: Long,

    @SerialName("name")
    val name: String?,
)

