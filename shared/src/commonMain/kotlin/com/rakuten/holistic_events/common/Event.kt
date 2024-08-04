package com.rakuten.holistic_events.common

import com.rakuten.holistic_events.randomUUID
import kotlinx.serialization.Serializable

/**
 * Base definition of a Event
 *
 * An event should override this interface and exposes the fields that it wants to share
 * with server. Fields that are not exposed won't be included into the Eventing message.
 * In order to expose a field, add following annotations to any field:
 *  [Expose] -> Without this annotation, a field will be ignored
 *  [SerializedName] -> Without this annotation, json keys will get obfuscated leading to invalid data sent to server
 *  
 * @author Guilherme Pivoto on August 09, 2023
 * Copyright (C) 2023 Ebates. All rights reserved.
 */
@Serializable
abstract class Event(
    val eventType: String,
    val schemaId: Long
) {
    /**
     * Unique id for the event (UUID format)
     */
    val id: String = randomUUID()

    /**
     * Check if at least one field from the Event was filled
     *
     * In order to avoid sending empty fields to the Eventing backend, some events can use this method
     * to report when they have valid values or not.
     *
     * @return True if this Event was filled and its data can be used. False otherwise.
     */
    abstract fun isEmpty(): Boolean
}
