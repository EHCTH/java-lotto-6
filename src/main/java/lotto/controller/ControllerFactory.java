package lotto.controller;

import lotto.domain.Profit;
import lotto.domain.cost.Cost;
import lotto.handler.InputHandler;
import lotto.service.CreateRandomLotto;
import lotto.service.LottoBuyerService;
import lotto.service.WinningLottoCalculatorService;
import lotto.service.WinningLottoSelectService;

public class ControllerFactory {
    public static Controller createController() {
        LottoBuyerService lottoBuyerService = new LottoBuyerService(
                InputHandler.receiveValidatedPurchasePrice(),
                new CreateRandomLotto()
                );
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
