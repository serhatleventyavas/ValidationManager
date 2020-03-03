package com.validationmanager.library.validations

object CreditCardValidation {

    fun validCreditCard(cardNumber: String): Boolean {
        val cardNumberArray = Array(cardNumber.length) {cardNumber[it].toString()}
        val numberList: ArrayList<Int> = ArrayList()

        val lastDigit = cardNumberArray[cardNumberArray.size - 1].toInt()
        for (index in 0..(cardNumberArray.size - 2)) {
            numberList.add(cardNumberArray[index].toInt())
        }
        numberList.reverse()

        for (index in 0 until numberList.size) {
            if (index % 2 == 0) {
                val number = numberList[index]
                numberList[index] = number * 2
            }
        }

        for (index in 0 until numberList.size) {
            if (index % 2 == 0) {
                val number = numberList[index]
                if (number > 9) {
                    numberList[index] = number - 9
                }
            }
        }

        var totalSum = 0
        for (index in 0 until numberList.size) {
            val number = numberList[index]
            totalSum += number
        }

        val resultOfMod10 = (totalSum + lastDigit) % 10
        return resultOfMod10 == 0
    }

}