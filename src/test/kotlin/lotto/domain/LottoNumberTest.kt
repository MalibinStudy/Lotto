package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LottoNumberTest {
    @ParameterizedTest
    @MethodSource("providerLotto")
    fun `입력된 값과 반환되는 로또가 같은 지에 대한 테스트`(lottoNumber: LottoNumber, expectedLottoNumber: List<Int>) {
        Assertions.assertThat(lottoNumber.getLotto()).isEqualTo(expectedLottoNumber)
    }

    companion object {
        @JvmStatic
        fun providerLotto() = listOf(
            Arguments.of(LottoNumber(listOf(1, 2, 3)), listOf(1, 2, 3)),
            Arguments.of(LottoNumber(listOf(2, 4, 6, 7)), listOf(2, 4, 6, 7)),
            Arguments.of(LottoNumber(listOf(3, 5, 7, 10, 11)), listOf(3, 5, 7, 10, 11)),
        )
    }
}
