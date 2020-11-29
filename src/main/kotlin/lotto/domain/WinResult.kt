package lotto.domain

class WinResult(val lottoBundleResult: List<Int>) {
    init {
        require(lottoBundleResult.size == 6) {
            "일부의 로또 결과가 반영되어 있지 않습니다. 입력된 결과 길이: ${lottoBundleResult.size}"
        }
    }

    fun getFifthPrizeCount() = lottoBundleResult[1]
    fun getForthPrizeCount() = lottoBundleResult[2]
    fun getThirdPrizeCount() = lottoBundleResult[3]
    fun getSecondPrizeCount() = lottoBundleResult[4]
    fun getFirstPrizeCount() = lottoBundleResult[5]
}
