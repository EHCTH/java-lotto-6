package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.Profit;
import lotto.domain.WinningLottery;
import lotto.domain.cost.IBuyerCost;
import lotto.service.LottoBuyerService;
import lotto.service.WinningLottoCalculatorService;
import lotto.service.WinningLottoSelectService;
import lotto.view.OutputView;

public class Controller {
    private final WinningLottoSelectService winningLottoSelectService;
    private final LottoBuyerService lottoBuyerService;
    private final WinningLottoCalculatorService winningLottoCalculatorService;

    public Controller(LottoBuyerService lottoBuyerService,
                      WinningLottoSelectService winningLottoSelectService,
                      WinningLottoCalculatorService winningLottoCalculatorService) {
        this.lottoBuyerService = lottoBuyerService;
        this.winningLottoSelectService = winningLottoSelectService;
        this.winningLottoCalculatorService = winningLottoCalculatorService;
    }

    public void run() {
        IBuyerCost buyerCost = lottoBuyerService.getCost();
        LottoTickets lottoTickets = buyTickets();
        OutputView.printLottoTicketsInfo(lottoTickets);
        WinningLottery winningLottery = selectWinningLotto();
        Profit profit = calculateProfit(winningLottery, lottoTickets);
        OutputView.printResultInfo(profit, buyerCost);

    }
    public LottoTickets buyTickets() {
        return lottoBuyerService.buy();
    }
    public WinningLottery selectWinningLotto() {
        return winningLottoSelectService.selectWinningLotto();
    }
    public Profit calculateProfit(WinningLottery winningLottery, LottoTickets lottoTickets) {
        return winningLottoCalculatorService.updateProfit(winningLottery, lottoTickets);
    }

}
