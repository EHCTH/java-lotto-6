package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.Profit;
import lotto.domain.cost.IBuyerCost;
import lotto.enums.winningPlace.WinningPlace;

public class OutputView {

    public static void printResultInfo(Profit profit, IBuyerCost buyerCost) {
        System.out.println("당첨 통계\n" + "---");
        System.out.print(WinningPlace.print());
        System.out.printf("총 수익률은 %.1f%%입니다.", profit.getProfit(buyerCost));
    }
    public static void printPurchaseAmount(IBuyerCost buyerCost) {
        System.out.println(buyerCost.spendMoney() + "개를 구매했습니다.");
    }
    public static void printErrorMessageFor(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
    public static void printPurchaseInputText() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void printNewLine() {
        System.out.println();
    }
    public static void printInsertCoin(IBuyerCost buyerCost) {
        System.out.println(buyerCost.getPrice());
        printNewLine();
    }
    public static void printLottoTicketsInfo(LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
    }
    public static void printSelectWinningLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void printBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
