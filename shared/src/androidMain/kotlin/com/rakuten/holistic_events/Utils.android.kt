package com.rakuten.holistic_events

import java.util.UUID

actual fun randomUUID(): String = UUID.randomUUID().toString()