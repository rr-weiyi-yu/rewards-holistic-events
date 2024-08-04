package com.rakuten.holistic_events

import platform.Foundation.NSUUID

actual fun randomUUID(): String  = NSUUID().UUIDString()