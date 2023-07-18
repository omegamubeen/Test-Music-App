package com.eimtest.sds

fun String.getInitials(): String {
    val parts = this.split(" ").filter { it.isNotEmpty() }
    return when {
        parts.isEmpty() -> ""
        parts.size == 1 -> if (parts[0].length > 1) parts[0].substring(0, 2) else parts[0]
        else -> parts[0].substring(0, 1) + parts[parts.size - 1].substring(0, 1)
    }.uppercase()
}