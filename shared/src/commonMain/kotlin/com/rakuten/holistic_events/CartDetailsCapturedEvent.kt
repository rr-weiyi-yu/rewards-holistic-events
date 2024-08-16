package com.rakuten.holistic_events

import com.rakuten.holistic_events.common.CurrencyAmount
import com.rakuten.holistic_events.common.KmpEvent
import com.rakuten.holistic_events.common.ShoppingTripData
import com.rakuten.holistic_events.common.Store
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

private const val EVENT_NAME = "Cart Details Captured"
private const val CART_DETAILS_CAPTURED_SCHEMA_ID = 907L

/**
 * @author William Yu on August 12, 2024
 *         Copyright (C) 2024 Rakuten Rewards. All rights reserved.
 */
@Serializable
data class CartDetailsCapturedEvent(
    override val eventType: String = EVENT_NAME,

    override val schemaId: Long = CART_DETAILS_CAPTURED_SCHEMA_ID,

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
) : KmpEvent(), ShoppingTripData {
    override fun isEmpty(): Boolean = false // CartDetailsCapturedEvent is valid if it has a cartTotal and cartTotal is not nullable
}
