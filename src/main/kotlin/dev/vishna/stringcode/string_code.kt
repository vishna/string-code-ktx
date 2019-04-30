package dev.vishna.stringcode

import java.io.File

/**
 * Makes first character of the String upper case
 */
fun String.capitalize() : String {
    return when (length) {
        0 -> ""
        1 -> this[0].toUpperCase().toString()
        else -> "${this[0].toUpperCase()}${this.substring(1)}"
    }
}

/**
 * Turns snake_case String to CamelCase or camelCase (depends on `startWithLowerCase`)
 */
fun String.camelize(startWithLowerCase: Boolean = false) : String {
    return toLowerCase()
        .split("_")
        .filter { !it.isNullOrBlank() }
        .mapIndexed { index, value ->
            value.applyIf(!startWithLowerCase || index > 0) {
                capitalize()
            }
        }
        .joinToString(separator = "")
}

/**
 * Returns true if string starts with lowercase
 */
fun String.startsWithLowercase() : Boolean {
    if (isNullOrBlank()) return false

    return this[0].toLowerCase() == this[0]
}


/**
 * If a string is camel_case it turns it to SnakeCase
 *
 * If string is snakeCase it turns it to SnakeCase
 */
fun String.smartCamelize() : String {
    if (contains("_")) return camelize()

    if (startsWithLowercase()) return capitalize()

    return this
}

/**
 * Works just like regular Kotlin's apply but conditional
 */
inline fun <T> T.applyIf(condition: Boolean, block: T.() -> T): T {
    if (condition) {
        return block()
    }
    return this
}

/**
 * Saves this string to the given `path` location
 */
fun String?.saveAs(path: String) {
    if (this == null) {
        return
    }

    File(path).writeText(text = this)
}

/**
 * Loads file located in resources as String
 */
fun String.asResource() : String {
    return if (!this.startsWith("/")) {
        "/${this}".asResource()
    } else {
        this.javaClass::class.java.getResource(this).readText()
    }
}