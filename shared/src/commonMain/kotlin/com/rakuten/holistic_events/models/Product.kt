package com.rakuten.holistic_events.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author William Yu on August 12, 2024
 *         Copyright (C) 2024 Rakuten Rewards. All rights reserved.
 */
@Serializable
data class Product(
    @SerialName("name")
    val name: String?,

    @SerialName("price")
    val price: CurrencyAmount?,

    @SerialName("url")
    val url: String?,

    @SerialName("image_urls")
    val imageUrls: Set<String>?,
)
