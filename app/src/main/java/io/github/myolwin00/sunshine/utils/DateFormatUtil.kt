package io.github.myolwin00.sunshine.utils

import java.text.SimpleDateFormat

/**
 * Created by myolwin00 on 11/13/17.
 */
class DateFormatUtil {

    companion object {
        fun formatDate(millisec: Long?): String {
            val sdf = SimpleDateFormat("EEE, d MMM")
            return sdf.format(millisec)
        }
    }
}