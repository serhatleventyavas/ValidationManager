package com.validationmanager.library

import android.content.Context
import android.util.Log
import com.validationmanager.library.data.Country
import org.json.JSONArray
import org.json.JSONObject
import java.io.*
import java.lang.Exception

class JsonParser(var context: Context) {

    fun readDataFromRawFile(): JSONArray {
        val inputStream: InputStream = context.resources.openRawResource(R.raw.country)
        val writer: Writer = StringWriter()
        val buffer: CharArray = CharArray(1024)

        try {
            val reader: Reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            var n: Int = -1

            do {
                n = reader.read(buffer)
                if (n == -1) {
                    break
                }
                writer.write(buffer, 0, n)
            } while (true)
        } catch (error: Exception) {
            Log.e("ValidationManager", error.message)
        } finally {
            inputStream.close()
        }
        val jsonString: String = writer.toString()
        Log.i("ValidationManager", jsonString)
        return JSONArray(jsonString)
    }

    fun parseCountry(jsonArray: JSONArray): ArrayList<Country> {
        val list: ArrayList<Country> = ArrayList()
        for (index in 0 until jsonArray.length()) {
            val item: JSONObject = jsonArray.getJSONObject(index)
            val mobileBeginsWithJSONArray: JSONArray = item.getJSONArray("mobile_begin_with")
            val phoneNumberLengthsJSONArray: JSONArray = item.getJSONArray("phone_number_lengths")

            val mobileBegins: ArrayList<String> = ArrayList()
            val phoneNumberLengths: ArrayList<Int> = ArrayList()

            for (mobileBeginIndex in 0 until mobileBeginsWithJSONArray.length()) {
                mobileBegins.add(mobileBeginsWithJSONArray.getString(mobileBeginIndex))
            }

            for (phoneNumberLengthIndex in 0 until phoneNumberLengthsJSONArray.length()) {
                phoneNumberLengths.add(phoneNumberLengthsJSONArray.getInt(phoneNumberLengthIndex))
            }

            val country: Country = Country(
                item.getString("alpha2"),
                item.getString("alpha3"),
                item.getString("country_code"),
                item.getString("country_name"),
                mobileBegins,
                phoneNumberLengths)

            list.add(country)
        }
        return list
    }
}