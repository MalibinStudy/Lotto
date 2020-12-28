package lotto.domain

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PrizeCheckListTest {
    @Test
    fun `아무것도 당첨되지 않았을 때 수익은 0원입니다`() {
        val noPrizeList = listOf(
            Rank.LOSING_TICKET,
            Rank.LOSING_TICKET,
            Rank.LOSING_TICKET,
            Rank.LOSING_TICKET,
            Rank.LOSING_TICKET,
        )
        assertTrue(PrizeCheckList(noPrizeList).getMoney().sum() == 0L)
    }

    @Test
    fun `리스트에 담겨진 대로 상금을 계산할 수 있습니다`() {
        val noPrizeList = listOf(
            Rank.LOSING_TICKET,
            Rank.FIFTH_PRIZE_TICKET,
            Rank.FOURTH_PRIZE_TICKET,
            Rank.THIRD_PRIZE_TICKET,
            Rank.FIRST_PRIZE_TICKET,
        )
        assertTrue(
            PrizeCheckList(noPrizeList).getMoney().sum() ==
                Rank.LOSING_TICKET.lottoPrize +
                Rank.FIFTH_PRIZE_TICKET.lottoPrize +
                Rank.FOURTH_PRIZE_TICKET.lottoPrize +
                Rank.THIRD_PRIZE_TICKET.lottoPrize +
                Rank.FIRST_PRIZE_TICKET.lottoPrize
        )
    }

    @ParameterizedTest
    @MethodSource("provideResultAndExpected")
    fun `당첨 결과를 정수형 리스트로 반환합니다`(input: List<Rank>, expected: List<Int>) {
        val result = PrizeCheckList(input).getWinningResult()
        assertTrue(result.lottoBundleResult == expected)
    }

    companion object {
        @JvmStatic
        fun provideResultAndExpected() = listOf(
            Arguments.of(
                listOf(
                    Rank.LOSING_TICKET,
                    Rank.FIFTH_PRIZE_TICKET,
                    Rank.FOURTH_PRIZE_TICKET
                ),
                listOf(1, 1, 1, 0, 0, 0)
            ),
            Arguments.of(
                listOf(
                    Rank.FOURTH_PRIZE_TICKET,
                    Rank.FOURTH_PRIZE_TICKET,
                    Rank.THIRD_PRIZE_TICKET,
                    Rank.FIRST_PRIZE_TICKET
                ),
                listOf(0, 0, 2, 1, 0, 1)
            ),
            Arguments.of(
                listOf(
                    Rank.FIFTH_PRIZE_TICKET,
                    Rank.LOSING_TICKET,
                    Rank.LOSING_TICKET,
                    Rank.THIRD_PRIZE_TICKET
                ),
                listOf(2, 1, 0, 1, 0, 0)
            ),
        )
    }
}
