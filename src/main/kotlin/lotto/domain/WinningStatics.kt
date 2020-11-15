package lotto.domain

data class WinningStatics(
    val winningResult: List<Int>,
    val rateOfProfit: Float,
    val isLoss: Boolean
)
