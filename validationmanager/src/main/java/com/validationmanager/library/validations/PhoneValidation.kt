package com.validationmanager.library.validations

import com.validationmanager.library.data.Country

object PhoneValidation {

    fun validPhoneNumber(country: Country, dialCode: String, phoneNumber: String): Boolean {
        if ("+${country.countryCode}" != dialCode) {
            return false
        }

        var isCorrectMobileBegin: Boolean = false

        for (index in 0 until country.mobileBeginWith.size) {
            if (phoneNumber.startsWith(country.mobileBeginWith[index])) {
                isCorrectMobileBegin = true
                break
            }
        }

        if (!isCorrectMobileBegin) {
            return false
        }

        var isCorrectPhoneNumberLength: Boolean = false
        for (index in 0 until country.phoneNumberLengths.size) {
            if (phoneNumber.length == country.phoneNumberLengths[index]) {
                isCorrectPhoneNumberLength = true
                break
            }
        }

        if (!isCorrectPhoneNumberLength) {
            return false
        }

        return true
    }

}