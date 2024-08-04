package com.rakuten.holistic_events

import com.rakuten.holistic_events.common.CurrencyAmount
import com.rakuten.holistic_events.common.Event
import com.rakuten.holistic_events.common.ShoppingTripData
import com.rakuten.holistic_events.common.Store
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about a user's shopping cart, including details of the product items such as name, quantity, and price.
 *
 * @property productList The list of products in the cart
 * @property cartTotal The total amount (fiat value) of the products in the cart
 * @property cartTotalQty The total number of unique products in the cart
 * @property currency Currency of the cart
 * @property pageUrl URL of the checkout page
 */
@Serializable
data class CartDetailsCapturedEvent(

    @SerialName("tracking_ticket")
    override val trackingTicket: String,

    @SerialName("store")
    override val store: Store,

    @SerialName("product_list")
    val productList: List<ProductData>,

    @SerialName("cart_total")
    val cartTotal: CurrencyAmount,

    @SerialName("cart_total_qty")
    val cartTotalQty: Int = productList.size,

    @SerialName("currency")
    val currency: String?,

    @SerialName("page_url")
    val pageUrl: String?,
) : Event(EVENT_NAME, CART_DETAILS_CAPTURED_SCHEMA_ID), ShoppingTripData {

    companion object {
        private const val EVENT_NAME = "Cart Details Captured"
        private const val CART_DETAILS_CAPTURED_SCHEMA_ID = 839L
    }

    override fun isEmpty(): Boolean = false // CartDetailsCapturedEvent is valid if it has a cartTotal and cartTotal not nullable
}

/**
 * Details of a product retrieved from a user's shopping cart.
 *
 * @property name The name of the product
 * @property itemPrice The item price of the product
 * @property lineTotal The price of the item multiplied by the quantity of the product
 * @property quantity The quantity of the product
 * @property url The url of the product
 * @property imageUrl The image URL of the product
 */
@Serializable
data class ProductData(

    @SerialName("name")
    val name: String?,

    @SerialName("item_price")
    val itemPrice: CurrencyAmount?,

    @SerialName("line_total")
    val lineTotal: CurrencyAmount?,

    @SerialName("quantity")
    val quantity: Int?,

    @SerialName("url")
    val url: String?,

    @SerialName("image_url")
    val imageUrl: String?,
) {

    /**
     * ProductData needs to have either name or url to be a valid ProductData
     */
    fun isValid(): Boolean = !name.isNullOrEmpty() || !url.isNullOrEmpty()
}
