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

    fun getFormattedSalary(sMin: String?, sMax: String?): String {
        return "Rs $sMin - $sMax LPA"
    }
}