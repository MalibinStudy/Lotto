package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WinningResultTest {
    @ParameterizedTest
    @MethodSource("providerLotto")
    fun `로또를 돌리면 얼마나 당첨이 되었는 지 결과가 나옵니다`(
        lotteryWallet: LotteryWallet,
        winningNumber: List<Int>,
        expectedListLength: Int
    ) {
        val winningResult = WinningResult(winningNumber)

        Assertions.assertThat(winningResult.checkMyLotto(lotteryWallet).size).isEqualTo(expectedListLength)
    }

    companion object {
        @JvmStatic
        fun providerLotto() = listOf(
            Arguments.of(LotteryWallet(14000), listOf(1, 2, 3, 4, 5, 6), 14),
            Arguments.of(LotteryWallet(12500), listOf(2, 4, 6, 7, 8, 9), 12),
            Arguments.of(LotteryWallet(5000), listOf(6, 10, 12, 18, 21, 25), 5),
        )
    }
}
