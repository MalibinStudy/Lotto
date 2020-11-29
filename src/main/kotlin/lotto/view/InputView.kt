package lotto.view

class InputView {
    companion object {

        fun getLottoPurchasedCount(): Long {
            return readLine()!!.toLong()
        }

        fun getWinningLottoTicket(): List<String> {
            return readLine()!!
                .split(",")
        }

        fun getBonusNumber(): Int {
            return readLine()!!.toInt()
        }
    }
}
