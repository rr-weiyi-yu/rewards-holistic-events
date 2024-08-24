package com.rakuten.holistic_events.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CartLineItem(
    @SerialName("product")
    val product: Product?,

    @SerialName("total")
    val total: CurrencyAmount?,

    @SerialName("quantity")
    val quantity: Int?,
) {

    /**
     * CartLineItem's product needs to have either name or url to be a valid CartLineItem
     */
    fun isValid(): Boolean = !product?.name.isNullOrEmpty() || !product?.url.isNullOrEmpty()
}
