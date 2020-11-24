package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

object RevenueRatio {
    fun calculate(money: Long, totalPrize: Long): BigDecimal {
        val purchaseAmount = money.toBigDecimal()
        val totalPrizeMoeny = totalPrize.toBigDecimal()
        return totalPrizeMoeny.divide(purchaseAmount, 2, RoundingMode.HALF_DOWN)
    }
}
