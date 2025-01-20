package com.example.desafiotarget

fun main() {
    // Faturamento mensal detalhado por estado
    val faturamentoPorEstado = mapOf(
        "SP" to 67836.43,
        "RJ" to 36678.66,
        "MG" to 29229.88,
        "ES" to 27165.48,
        "Outros" to 19849.53
    )

    // Calculando o faturamento total
    val faturamentoTotal = faturamentoPorEstado.values.sum()

    // Verificando se o faturamento total é válido
    if (faturamentoTotal == 0.0) {
        println("Faturamento total é zero. Não é possível calcular os percentuais.")
        return
    }

    // Calculando e exibindo o percentual de cada estado
    println("Percentual de representação por estado:")
    for ((estado, faturamento) in faturamentoPorEstado) {
        val percentual = (faturamento / faturamentoTotal) * 100
        println("$estado: %.2f%%".format(percentual))
    }

    // Exibindo o faturamento total para conferência
    println("Faturamento total: R$%.2f".format(faturamentoTotal))
}
