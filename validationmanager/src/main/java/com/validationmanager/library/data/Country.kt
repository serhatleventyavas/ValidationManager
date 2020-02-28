package com.validationmanager.library.data

data class Country(var alpha2: String = "",
              var alpha3: String = "",
              var countryCode: String = "",
              var countryName: String = "",
              var mobileBeginWith: ArrayList<String> = ArrayList<String>(),
              var phoneNumberLengths: ArrayList<Int> = ArrayList<Int>())