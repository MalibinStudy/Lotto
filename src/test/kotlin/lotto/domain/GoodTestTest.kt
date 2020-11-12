package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GoodTestTest {

    @Test
    fun test() {
        // given
        val goodTest = GoodTest()
        val ints = (1..10).toList()

        // when
        val sum = goodTest.function(ints)

        // then
        assertThat(sum).isEqualTo(55)
    }

    @Test
    fun otherTest() {
        // given
        val goodTest = GoodTest()

        // then
        assertThat(goodTest.otherFunction()).isEqualTo(5)
    }
}
