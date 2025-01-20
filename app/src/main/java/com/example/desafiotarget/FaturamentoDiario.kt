package com.example.desafiotarget

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File

@Serializable
data class FaturamentoDiario(val dia: Int, val faturamento: Double)

fun main() {
    // Carregar os dados do JSON
    val jsonData = File("faturamento.json").readText()
    val faturamentoMensal = Json.decodeFromString<List<FaturamentoDiario>>(jsonData)

    // Filtrar os dias com faturamento maior que 0
    val diasComFaturamento = faturamentoMensal.filter { it.faturamento > 0 }

    if (diasComFaturamento.isEmpty()) {
        println("Não há dados de faturamento disponíveis.")
        return
    }

    // Calcular o menor e maior valor de faturamento
    val menorFaturamento = diasComFaturamento.minOf { it.faturamento }
    val maiorFaturamento = diasComFaturamento.maxOf { it.faturamento }

    // Calcular a média mensal
    val mediaMensal = diasComFaturamento.map { it.faturamento }.average()

    // Contar os dias com faturamento acima da média
    val diasAcimaDaMedia = diasComFaturamento.count { it.faturamento > mediaMensal }

    // Exibir os resultados
    println("Menor valor de faturamento: R$%.2f".format(menorFaturamento))
    println("Maior valor de faturamento: R$%.2f".format(maiorFaturamento))
    println("Número de dias com faturamento acima da média mensal: $diasAcimaDaMedia")
}
