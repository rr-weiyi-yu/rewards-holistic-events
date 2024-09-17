import groovy.json.JsonSlurper

plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.kotlinSerialization).apply(false)
}

tasks.register("generateSchemaVersions") {
    doLast {
        val jsonFile = file("shared/src/commonMain/schema_versions.json")
        val jsonSlurper = JsonSlurper()
        val jsonData = jsonSlurper.parse(jsonFile) as Map<String, Int>

        val kotlinFile = File(projectDir, "shared/src/commonMain/kotlin/com/rakuten/holistic_events/SchemaVersions.kt")
        kotlinFile.parentFile.mkdirs()

        val content = buildString {
            appendLine("package com.rakuten.holistic_events")
            appendLine()
            appendLine("object SchemaVersions {")
            jsonData.entries.forEach { (key, value) ->
                val formattedKey = formatKey(key)
                appendLine("    const val $formattedKey: Long = ${value}L")
            }
            appendLine("}")
        }

        kotlinFile.writeText(content)
        println("SchemaVersions.kt generated successfully!")
    }
}

fun formatKey(key: String): String {
    return key.split("-", "_", ".")
        .mapIndexed { index, part ->
            when {
                index == 0 -> part.capitalize()
                part.all { it.isDigit() } -> part
                else -> part.toLowerCase().capitalize()
            }
        }
        .joinToString("")
        .removePrefix("ComRakutenrewardsMessaging")
}
