package com.validationmanager.library

import com.validationmanager.library.validations.CreditCardValidation
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Test

class CreditCardValidationTest {

    @Test
    fun test_givenCreditCard_returnFalse() {
        val result: Boolean = CreditCardValidation.validCreditCard("4532030566401450")
        MatcherAssert.assertThat(result, Matchers.equalTo(false))
    }

    @Test
    fun test_givenCreditCard_returnTrue() {
        val result: Boolean = CreditCardValidation.validCreditCard("4556737586899855")
        MatcherAssert.assertThat(result, Matchers.equalTo(true))
    }

    @Test
    fun test_givenAnotherCreditCard_returnTrue() {
        val result: Boolean = CreditCardValidation.validCreditCard("4175001382805488")
        MatcherAssert.assertThat(result, Matchers.equalTo(true))
    }

}