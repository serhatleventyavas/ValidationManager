package com.validationmanager.library

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.validationmanager.library.data.Country
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.json.JSONArray
import org.junit.Test

class JsonParseV2Test {

    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun readJsonFromRaw() {
        // Given
        val jsonParser: JsonParser = JsonParser(context)

        // Arrange
        val result: JSONArray = jsonParser.readDataFromRawFile()

        // Assert
        MatcherAssert.assertThat(result, Matchers.notNullValue())
    }

    @Test
    fun parseCountryListFromJSONData() {
        // Given
        val jsonParser: JsonParser = JsonParser(context)

        // Arrange
        val jsonArrayResult: JSONArray = jsonParser.readDataFromRawFile()
        val countryList: ArrayList<Country> = jsonParser.parseCountry(jsonArrayResult)

        // Assert
        MatcherAssert.assertThat(countryList.size, Matchers.equalTo(228))
    }

    @Test
    fun checkFirstCountryIsUS() {
        // Given
        val jsonParser: JsonParser = JsonParser(context)

        // Arrange
        val jsonArrayResult: JSONArray = jsonParser.readDataFromRawFile()
        val countryList: ArrayList<Country> = jsonParser.parseCountry(jsonArrayResult)

        // Assert
        MatcherAssert.assertThat(countryList[0].alpha2, Matchers.equalTo("US"))
    }

    @Test
    fun checkLastCountryIsUS() {
        // Given
        val jsonParser: JsonParser = JsonParser(context)

        // Arrange
        val jsonArrayResult: JSONArray = jsonParser.readDataFromRawFile()
        val countryList: ArrayList<Country> = jsonParser.parseCountry(jsonArrayResult)

        // Assert
        MatcherAssert.assertThat(countryList[countryList.size - 1].alpha2, Matchers.equalTo("ZW"))
    }
}