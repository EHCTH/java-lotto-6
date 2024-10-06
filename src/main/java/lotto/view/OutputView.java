package lotto.view;

import lotto.domain.Profit;
import lotto.domain.cost.IBuyerCost;
import lotto.winningcost.WinningPlace;

public class OutputView {
    public static void resultInfo(Profit profit, IBuyerCost buyerCost) {
        System.out.println("당첨 통계\n" + "---");
        System.out.print(WinningPlace.print());
        System.out.printf("총 수익률은 %.1f%%입니다.", profit.getProfit(buyerCost));
    }
    public static void purchaseAmount(IBuyerCost buyerCost) {
        System.out.println(buyerCost.getTotal()+"\n");
    }
}
