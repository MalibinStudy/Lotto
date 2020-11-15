package lotto.domain

import lotto.domain.LotteryWallet.Companion.LOTTO_UNIT_PRICE
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.random.Random

internal class LotteryWalletTest {
    @ParameterizedTest
    @CsvSource("14000, 14", "16000, 16", "12000, 12")
    fun `돈을 입금하면 로또를 구매할 수 있습니다`(money: Int, expectedLottoAmount: Int) {
        val myWallet = LotteryWallet(money)

        Assertions.assertThat(myWallet.getMyLotto().size).isEqualTo(expectedLottoAmount)
    }

    @ParameterizedTest
    @CsvSource("12300, 12", "17900, 17", "232200, 232")
    fun `거스름돈이 발생하면 로또만 발급이 됩니다`(money: Int, expectedLottoAmount: Int) {
        val myWallet = LotteryWallet(money)

        Assertions.assertThat(myWallet.getMyLotto().size).isEqualTo(expectedLottoAmount)
    }

    @Test
    fun `입금된 돈이 로또 한 장 가격보다 작으면 구매가 안 됩니다`() {
        val money = Random.nextInt(LOTTO_UNIT_PRICE)

        Assertions.assertThatThrownBy { LotteryWallet(money) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("가격은 ${LOTTO_UNIT_PRICE}원보다 커야 합니다.")
    }
}
