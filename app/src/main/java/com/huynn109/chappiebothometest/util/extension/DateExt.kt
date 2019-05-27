package com.huynn109.chappiebothometest.util.extension

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by huynn109 on 2019-05-26.
 */

/** Converting from String to Date **/
fun String.getDateWithServerTimeStamp(): Date? {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'",
            Locale.getDefault())
    dateFormat.timeZone = TimeZone.getDefault()  // IMP !!!
    return try {
        dateFormat.parse(this)
    } catch (e: ParseException) {
        null
    }
}

/** Converting from Date to String**/
fun Date.getStringTimeStampWithDate(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'",
            Locale.getDefault())
    dateFormat.timeZone = TimeZone.getDefault()
    return dateFormat.format(this)
}