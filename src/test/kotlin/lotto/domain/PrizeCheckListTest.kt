package lotto.domain

import lotto.domain.LotteryWinningCriteria.Companion.FIRST_PRIZE
import lotto.domain.LotteryWinningCriteria.Companion.FOURTH_PRIZE
import lotto.domain.LotteryWinningCriteria.Companion.SECOND_PRIZE
import lotto.domain.LotteryWinningCriteria.Companion.THIRD_PRIZE
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PrizeCheckListTest {
    @Test
    fun `아무것도 당첨되지 않았을 때 수익은 0원입니다`() {
        val noPrizeList = listOf(
            LotteryWinningCriteria.LOSING_TICKET,
            LotteryWinningCriteria.LOSING_TICKET,
            LotteryWinningCriteria.LOSING_TICKET,
            LotteryWinningCriteria.LOSING_TICKET,
            LotteryWinningCriteria.LOSING_TICKET,
        )
        assertTrue(PrizeCheckList(noPrizeList).getMoney().sum() == 0L)
    }

    @Test
    fun `리스트에 담겨진 대로 상금을 계산할 수 있습니다`() {
        val noPrizeList = listOf(
            LotteryWinningCriteria.LOSING_TICKET,
            LotteryWinningCriteria.FOURTH_PRIZE_TICKET,
            LotteryWinningCriteria.THIRD_PRIZE_TICKET,
            LotteryWinningCriteria.SECOND_PRIZE_TICKET,
            LotteryWinningCriteria.FIRST_PRIZE_TICKET,
        )
        assertTrue(
            PrizeCheckList(noPrizeList).getMoney().sum() == FOURTH_PRIZE + THIRD_PRIZE + SECOND_PRIZE + FIRST_PRIZE
        )
    }

    @ParameterizedTest
    @MethodSource("provideResultAndExpected")
    fun `당첨 결과를 정수형 리스트로 반환합니다`(input: List<LotteryWinningCriteria>, expected: List<Int>) {
        val result = PrizeCheckList(input).getWinningResult()
        assertTrue(result == expected)
    }

    companion object {
        @JvmStatic
        fun provideResultAndExpected() = listOf(
            Arguments.of(
                listOf(
                    LotteryWinningCriteria.LOSING_TICKET,
                    LotteryWinningCriteria.FOURTH_PRIZE_TICKET,
                    LotteryWinningCriteria.THIRD_PRIZE_TICKET
                ),
                listOf(1, 1, 1, 0, 0)
            ),
            Arguments.of(
                listOf(
                    LotteryWinningCriteria.THIRD_PRIZE_TICKET,
                    LotteryWinningCriteria.THIRD_PRIZE_TICKET,
                    LotteryWinningCriteria.SECOND_PRIZE_TICKET,
                    LotteryWinningCriteria.FIRST_PRIZE_TICKET
                ),
                listOf(0, 0, 2, 1, 1)
            ),
            Arguments.of(
                listOf(
                    LotteryWinningCriteria.FOURTH_PRIZE_TICKET,
                    LotteryWinningCriteria.LOSING_TICKET,
                    LotteryWinningCriteria.LOSING_TICKET,
                    LotteryWinningCriteria.SECOND_PRIZE_TICKET
                ),
                listOf(2, 1, 0, 1, 0)
            ),
        )
    }
}
