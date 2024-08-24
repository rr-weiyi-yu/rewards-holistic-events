package com.rakuten.holistic_events.message

import com.rakuten.holistic_events.events.Event
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Message(

    @SerialName("id")
    val id: String,

    @SerialName("member")
    val member: Member,

    @SerialName("source_timestamp_millis")
    var sourceTimestampMillis: Long? = 0,

    @SerialName("source_time_zone")
    val sourceTimeZone: String,

    @SerialName("issuer")
    val issuer: Issuer,

    @SerialName("parent_message_id")
    val parentEventId: String?,

    @SerialName("type")
    var type: String?,

    @SerialName("schema_id")
    val schemaID: Long?,

    @SerialName("integrations")
    val integrations: Branch?,

    @SerialName("source_created_at_millis")
    val sourceCreatedAtMillis: Long,

    @SerialName("visit_id")
    val visitID: String,

    @SerialName("client_context")
    val clientContext: ClientContext,

    @SerialName("region_id")
    val regionID: String,

    @SerialName("data")
    val data: Event?,
)
