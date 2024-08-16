package com.rakuten.holistic_events.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author William Yu on July 25, 2024
 *         Copyright (C) 2024 Rakuten Rewards. All rights reserved.
 *
 * A structure describing a currency amount. This structure avoids rounding, and ensures that the currency is stored alongside the amount.
 *
 * @property amount The amount stored as a whole number. To recover the whole amount multiply this number by 10^(-1* precision).
 * e.g. if the precision is 2, you would multiply by 10^-2, or effectively divide by 100.
 * This should be done in a way that correctly handles rounding.
 *
 * @property precision The precision with which the currency amount is stored.
 * @property currency The 3-letter ISO 4217 code of the fiat currency associated with this amount. If this amount is not in a fiat currency, this will be a custom Rakuten Rewards specific code for the currency.
 */
@Serializable
data class CurrencyAmount(
    @SerialName("amount")
    val amount: Long,

    @SerialName("precision")
    val precision: Int,

    @SerialName("currency")
    val currency: String,
)

fun Int.toCurrencyAmount(precision: Int, currency: String) = CurrencyAmount(
    amount = this.toLong(),
    precision = precision,
    currency = currency,
)
