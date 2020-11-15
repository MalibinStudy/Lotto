package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MatchLotteryTest {
    @ParameterizedTest
    @MethodSource("providerMatchingList")
    fun `LottoNumber와 당첨 번호를 입력하면 몇 개를 맞췄는 지 반환합니다`(lottoNumber: LottoNumber, winningNumber: List<Int>, expectedAnswer: Int) {
        Assertions.assertThat(MatchLottery.checkLottery(lottoNumber, winningNumber)).isEqualTo(expectedAnswer)
    }

    companion object {
        @JvmStatic
        fun providerMatchingList() = listOf(
            Arguments.of(LottoNumber(listOf(2, 4, 7)), listOf(2, 4, 5), 2),
            Arguments.of(LottoNumber(listOf(1, 3, 8, 9)), listOf(1, 2, 3, 4), 2),
            Arguments.of(LottoNumber(listOf(3, 5, 7, 10, 11)), listOf(1, 18, 19, 20, 23), 0),
        )
    }
}
