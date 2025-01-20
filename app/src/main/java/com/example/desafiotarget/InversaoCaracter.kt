package com.example.desafiotarget

fun main() {
    // Entrada da string (pode ser modificada ou solicitada ao usuário)
    val input = "Exemplo de string para inverter"
    println("String original: \"$input\"")

    // Invertendo a string manualmente
    val inverted = invertString(input)
    println("String invertida: \"$inverted\"")
}

fun invertString(str: String): String {
    val charArray = str.toCharArray()
    val invertedArray = CharArray(charArray.size)

    for (i in charArray.indices) {
        invertedArray[i] = charArray[charArray.size - 1 - i]
    }

    return String(invertedArray)
}
