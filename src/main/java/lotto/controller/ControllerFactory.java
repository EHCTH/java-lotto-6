package lotto.controller;

import lotto.domain.Profit;
import lotto.domain.cost.BuyerCost;
import lotto.domain.cost.Cost;
import lotto.domain.cost.IBuyerCost;
import lotto.service.LottoBuyerService;
import lotto.service.WinningLottoCalculatorService;
import lotto.service.WinningLottoSelectService;

public class ControllerFactory {
    public static Controller createController() {
        IBuyerCost buyerCost = new BuyerCost();
        LottoBuyerService lottoBuyerService = new LottoBuyerService(buyerCost);
        WinningLottoSelectService winningLottoSelectService = new WinningLottoSelectService();
        WinningLottoCalculatorService winningLottoCalculatorService =
                new WinningLottoCalculatorService(new Profit(new Cost()));
        return new Controller(
                lottoBuyerService,
                winningLottoSelectService,
                winningLottoCalculatorService
        );
    }
}
