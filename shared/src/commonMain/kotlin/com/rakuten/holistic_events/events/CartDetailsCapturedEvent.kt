package com.rakuten.holistic_events.events

import com.rakuten.holistic_events.models.CartLineItem
import com.rakuten.holistic_events.models.CurrencyAmount
import com.rakuten.holistic_events.models.ShoppingTripData
import com.rakuten.holistic_events.models.Store
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author William Yu on August 12, 2024
 *         Copyright (C) 2024 Rakuten Rewards. All rights reserved.
 */
@Serializable
data class CartDetailsCapturedEvent(
    @SerialName("tracking_ticket")
    override val trackingTicket: String,

    @SerialName("store")
    override val store: Store,

    @SerialName("items")
    val items: List<CartLineItem>?,

    @SerialName("total")
    val total: CurrencyAmount,

    @SerialName("total_qty")
    val totalQty: Int? = items?.size,
) : Event("Cart Details Captured", 907L), ShoppingTripData {
    override fun isEmpty(): Boolean = false // CartDetailsCapturedEvent is valid if it has a cartTotal and cartTotal is not nullable
}