import lotto.domain.LottoGenerator
import lotto.view.PurchaseInputView
import lotto.view.PurchaseLottoResultView
import lotto.view.WinningInputView

/**
1000원단위로 로또 구매.(PurchaseInputView)

 로또 생성기(LottoGenerator)
 - 1000원단위로 로또 구입 개수 판단 -> 가격 넣으면 개수 리턴하도록
 - 해당 개수만큼 로또 생성 -> 개수 넣으면 로또 그만큼 생성한 리스트 반환하도록

 로또 하나당 1~45 사이의 숫자 랜덤으로 6개 갖는 리스트
    - 로또 하나 생성 (Lotto)
        - 랜덤 번호 6개
        - 갖고 있는 번호 정보 알려주기

구매한 로또들 출력하기(PurchaseLottoResultView)


 지난주 당첨 번호 입력받기(WinningInputView)
 - 1~45사이의 숫자가 입력되어야 하며, ','로 구분된다.

 LottoWinInspector
 LottoBag의 모든 로또들과 당첨 번호를 비교하여 3개, 4개, 5개, 6개 일치하는 것의 개수를 뽑는다.

 당첨 통계 발표하기(WinLottoResultView)
 3개 일치 (5000원) - 1개
 4개 일치 (50000원) - 0개
 5개 일치 (1500000원) - 0개
 6개 일치 (2000000000원) - 0개
 총 수익율은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미)
 **/
fun main() {
    val purchaseInputView = PurchaseInputView()
    val purchasePrice = purchaseInputView.getPurchasePrice()

    val lottoGenerator = LottoGenerator()
    val numOfLottos = lottoGenerator.countLottoNum(purchasePrice)
    val generatedLottos = lottoGenerator.generateLotto(numOfLottos)

    val purchaseLottoResultView = PurchaseLottoResultView()
    purchaseLottoResultView.showLottos(numOfLottos, generatedLottos)

    val winningInputView = WinningInputView()
    val winningLottoNums = winningInputView.requestWinningLottoNum()

}
