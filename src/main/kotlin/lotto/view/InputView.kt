package lotto.view

class InputView {
    fun getPurchaseCost(): String {
        println("구매 금액을 입력해주세요.")
        return readLine()!!
    }

    fun requestWinningLotto(): String {
        println("지난주 당첨 번호를 입력해 주세요.")
        return readLine()!!
    }

    fun requestBonusNum(): String {
        println("보너스 볼을 입력해 주세요.")
        return readLine()!!
    }
}
