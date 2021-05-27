package ant.vit.publications.tools

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Vitiello Antonio
 */
class Utils {
    companion object {
        //eg: 2017-01-29 23:42:03
        val yearDateFormat by lazy(LazyThreadSafetyMode.NONE) {
            SimpleDateFormat("yyyy-MM-dd HH:mm:ss", getDefaultLocale())
        }

        fun formatDateOrNull(dateFormat: SimpleDateFormat, date: Date?): String? {
            return date?.format(dateFormat)
        }

        fun parseDateOrNull(dateFormat: SimpleDateFormat, string: String?): Date? {
            return string?.parseDateOrNull(dateFormat)
        }

        private fun getDefaultLocale(): Locale{
            return Locale.getDefault()
        }
    }

}