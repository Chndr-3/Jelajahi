package com.example.myapplication.helper

fun formatWithCommas(number: Int): String {
    val numberString = number.toString()
    val length = numberString.length

    val stringBuilder = StringBuilder()

    for (i in 0 until length) {
        if (i > 0 && (length - i) % 3 == 0) {
            stringBuilder.append(',')
        }
        stringBuilder.append(numberString[i])
    }

    return stringBuilder.toString()
}