package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.Profit;
import lotto.domain.WinningLottery;
import lotto.service.LottoBuyerService;
import lotto.service.WinningLottoCalculatorService;
import lotto.service.WinningLottoSelectService;
import lotto.winningcost.WinningPlace;

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
        System.out.println("구입금액을 입력해 주세요.");
        lottoBuyerService.insertCoin();
        LottoTickets lottoTickets = lottoBuyerService.buy();
        WinningLottery winningLottery = winningLottoSelectService.selectWinningLotto();
        winningLottoCalculatorService.winningCalculator(winningLottery, lottoTickets);
        long buyCost = lottoBuyerService.getCost();
        System.out.println("당첨 통계\n" +
                "---");
        System.out.println(WinningPlace.print());
        System.out.printf("총 수익률은 %.1f%%입니다.", winningLottoCalculatorService.getProfit(buyCost));

    }


}
