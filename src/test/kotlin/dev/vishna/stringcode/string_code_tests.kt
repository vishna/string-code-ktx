package dev.vishna.stringcode

import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be`
import org.junit.Test

class StringCodeTests {
    @Test
    fun `String capitalize makes first letter uppercase` () {
        "something".capitalize() `should be equal to` "Something"
        "s".capitalize() `should be equal to` "S"
        "".capitalize() `should be equal to` ""
        "sOmeThing".capitalize() `should be equal to` "SOmeThing"
    }

    @Test
    fun `String camelize - converting snake_case to camelCase` () {
        "image_filter_button".camelize() `should be equal to` "ImageFilterButton"
        "image_filter_button".camelize(startWithLowerCase = true) `should be equal to` "imageFilterButton"
        "__image_filter_button".camelize() `should be equal to` "ImageFilterButton"
        "__image_filter_button".camelize(startWithLowerCase = true) `should be equal to` "imageFilterButton"
    }

    @Test
    fun `String startsWithLowercase - checks if string starts with lowercase` () {
        "".startsWithLowercase() `should be` false
        "   ".startsWithLowercase() `should be` false
        "a".startsWithLowercase() `should be` true
        "A".startsWithLowercase() `should be` false
        "betaVersion".startsWithLowercase() `should be` true
        "BetaVersion".startsWithLowercase() `should be` false
    }

    @Test
    fun `String smartCamelize - converting snake_case or camelCase to CamelCase` () {
        "image_filter_button".smartCamelize() `should be equal to` "ImageFilterButton"
        "imageFilterButton".smartCamelize() `should be equal to` "ImageFilterButton"
        "__image_filter_button".smartCamelize() `should be equal to` "ImageFilterButton"
    }

    @Test
    fun `String asResource - loading text file from resources` () {
        "test_resource.txt".asResource() `should be equal to` "This are contents of the test resource file."
        "/test_resource.txt".asResource() `should be equal to` "This are contents of the test resource file."
    }
}