package com.validationmanager.library

import com.validationmanager.library.data.Country
import com.validationmanager.library.validations.PhoneValidation
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Test

class PhoneValidationTest {

    @Test
    fun invalidTurkeyPhoneNumberWithWrongDialCode() {
        // Given
        val mobileBeginsWithList: ArrayList<String> = ArrayList()
        mobileBeginsWithList.add("5")

        val phoneNumberLengthList: ArrayList<Int> = ArrayList()
        phoneNumberLengthList.add(10)

        val country: Country = Country("TR", "TUR", "90", "Turkey",
            mobileBeginsWithList,
            phoneNumberLengthList
        )
        // Arrange
        val result: Boolean = PhoneValidation.validPhoneNumber(country, "+123", "5551231233")

        // Assert
        MatcherAssert.assertThat(result, Matchers.equalTo(false))
    }

    @Test
    fun invalidTurkeyPhoneNumberWithWrongMobileBegin() {
        // Given
        val mobileBeginsWithList: ArrayList<String> = ArrayList()
        mobileBeginsWithList.add("5")

        val phoneNumberLengthList: ArrayList<Int> = ArrayList()
        phoneNumberLengthList.add(10)

        val country: Country = Country("TR", "TUR", "90", "Turkey",
            mobileBeginsWithList,
            phoneNumberLengthList
        )
        // Arrange
        val result: Boolean = PhoneValidation.validPhoneNumber(country, "+90", "4551231233")

        // Assert
        MatcherAssert.assertThat(result, Matchers.equalTo(false))
    }

    @Test
    fun invalidTurkeyPhoneNumberWithWrongPhoneNumberLength() {
        // Given
        val mobileBeginsWithList: ArrayList<String> = ArrayList()
        mobileBeginsWithList.add("5")

        val phoneNumberLengthList: ArrayList<Int> = ArrayList()
        phoneNumberLengthList.add(10)

        val country: Country = Country("TR", "TUR", "90", "Turkey",
            mobileBeginsWithList,
            phoneNumberLengthList
        )
        // Arrange
        val result: Boolean = PhoneValidation.validPhoneNumber(country, "+90", "555121233")

        // Assert
        MatcherAssert.assertThat(result, Matchers.equalTo(false))
    }

    @Test
    fun validTurkeyPhoneNumber() {
        // Given
        val mobileBeginsWithList: ArrayList<String> = ArrayList()
        mobileBeginsWithList.add("5")

        val phoneNumberLengthList: ArrayList<Int> = ArrayList()
        phoneNumberLengthList.add(10)

        val country: Country = Country("TR", "TUR", "90", "Turkey",
            mobileBeginsWithList,
            phoneNumberLengthList
        )
        // Arrange
        val result: Boolean = PhoneValidation.validPhoneNumber(country, "+90", "5551231233")

        // Assert
        MatcherAssert.assertThat(result, Matchers.equalTo(true))
    }
}