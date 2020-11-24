package lotto.domain

class Money(val value: Int) {
    init {
        require(value >= 0) { "돈은 항상 양수입니다." }
    }
}
