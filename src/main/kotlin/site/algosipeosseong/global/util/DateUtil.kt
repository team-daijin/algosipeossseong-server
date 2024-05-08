package site.algosipeosseong.global.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DateUtil {
    fun dateToString(date: LocalDateTime): String {
        return date.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"))
    }
}