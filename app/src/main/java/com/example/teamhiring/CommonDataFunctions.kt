package com.example.teamhiring

object CommonDataFunctions {

    fun checkJobType(type: String?): String {
        return when (type) {
            "wfh", "wrkFHome" -> "Work From Home"
            "field", "fieldWork" -> "Field Work"
            else -> "Work From Office"
        }
    }

    fun checkJobTimeType(type: String?): String {
        return when (type) {
            "partTime", "part" -> "Part Time"
            "contractual" -> "Contractual"
            "internship", "Internship" -> "Internship"
            else -> "Full Time"
        }
    }

    fun getFormattedExp(exp: String?): String {
        return when(exp) {
            "fresher" -> "Fresher"
            "1_to_2" -> "1 - 2 yr"
            "above_5" -> "5+ yr"
            else -> "2 - 5 yr"
        }
    }

    fun getFormattedSalary(sMin: String?, sMax: String?): String {
        return "Rs $sMin - $sMax LPA"
    }

    fun getFormattedExpYr(year: String? = "0", month: String? = "00"): String {
        val mon = if (month?.length == 1) "0$month" else month
        return "${year}.$mon Yr"
    }
}