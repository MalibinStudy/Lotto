package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WinResultTest {
    @ParameterizedTest
    @MethodSource("providerLottoReuslt")
    fun `로또는 무조건 6가지의 결과를 가집니다`(result: List<Int>, expectedSize: Int) {
        Assertions.assertThatThrownBy {
            WinResult(result)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("일부의 로또 결과가 반영되어 있지 않습니다. 입력된 결과 길이: $expectedSize")
    }

    @Test
    fun `결과 리스트의 Element들은 순서대로 꽝부터 1등까지 구성되어 있습니다`() {
        val resultList = listOf(0, 1, 0, 2, 0, 0)
        val winResult = WinResult(resultList)

        Assertions.assertThat(resultList[1] == winResult.getFifthPrizeCount()).isTrue
        Assertions.assertThat(resultList[2] == winResult.getForthPrizeCount()).isTrue
        Assertions.assertThat(resultList[3] == winResult.getThirdPrizeCount()).isTrue
        Assertions.assertThat(resultList[4] == winResult.getSecondPrizeCount()).isTrue
        Assertions.assertThat(resultList[5] == winResult.getFirstPrizeCount()).isTrue
    }

    companion object {
        @JvmStatic
        fun providerLottoReuslt() = listOf(
            Arguments.of(listOf(0, 1, 1, 0, 0), 5),
            Arguments.of(listOf(0, 1, 0, 0), 4),
            Arguments.of(listOf(0, 1, 0), 3),
            Arguments.of(listOf(0, 1, 0, 1, 1, 1, 0), 7),
        )
    }
}
