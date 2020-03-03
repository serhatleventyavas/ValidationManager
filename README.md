# ValidationManager
[![](https://jitpack.io/v/serhatleventyavas/ValidationManager.svg)](https://jitpack.io/#serhatleventyavas/ValidationManager)

ValidationManager library allow to us that check phone number easily.
### Features
- [x] Check phone number
- [ ] Check email address
- [x] Check credit card

### Setup

------------

### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
### Step 2. Add the dependency
```
dependencies {
	implementation 'com.github.serhatleventyavas:ValidationManager:1.0'
}
```
### Step 3. Get All Countries
If you want retrieve countries, you can follow below code block.
```
val jsonParser: JsonParser = JsonParser(context)
val jsonArrayResult: JSONArray = jsonParser.readDataFromRawFile()
val countryList: ArrayList<Country> = jsonParser.parseCountry(jsonArrayResult)
```

### Step 4. Check Phone Number
If you want to check phone number by specific country, you can follow below code.
```
// for example Turkey country
val country: Country = countryList[0]
val result: Boolean = PhoneValidation.validPhoneNumber(country, "+90", "5551231233")
```

## License

ValidationManager is released under the MIT license. [See LICENSE](https://github.com/serhatleventyavas/ValidationManager/blob/master/LICENSE) for details.