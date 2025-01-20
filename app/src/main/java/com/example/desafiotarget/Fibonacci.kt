package com.example.desafiotarget


fun isFibonacci(num: Int): Boolean {
    if (num < 0) return false

    var a = 0
    var b = 1

    // Gerar a sequência de Fibonacci até encontrar ou ultrapassar o número
    while (a <= num) {
        if (a == num) return true
        val next = a + b
        a = b
        b = next
    }

    return false
}

fun main() {
    print("Informe um número para verificar se pertence à sequência de Fibonacci: ")

    // Ler entrada do usuário
    val input = readLine()

    try {
        val num = input?.toIntOrNull()
        if (num == null) {
            println("Por favor, insira um número válido.")
            return
        }

        // Verificar se o número pertence à sequência de Fibonacci
        if (isFibonacci(num)) {
            println( "O número $num pertence à sequência de Fibonacci.")
        } else {
            println("O número $num NÃO pertence à sequência de Fibonacci.")
        }
    } catch (e: Exception) {
        println("Erro: ${e.message}")
    }
}


