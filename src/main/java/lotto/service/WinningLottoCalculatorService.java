package lotto.service;

import lotto.domain.LottoTickets;
import lotto.domain.Profit;
import lotto.domain.WinningLottery;
import lotto.winningcost.WinningPlace;

public class WinningLottoCalculatorService {
    private final Profit profit;
    public WinningLottoCalculatorService(Profit profit) {
        this.profit = profit;
    }
    public void winningCalculator(WinningLottery winningLottery, LottoTickets lottoTickets) {
        long price = lottoTickets.infoTickets()
                .stream()
                .mapToLong((lotto) -> WinningPlace.calculatePrize(winningLottery, lotto))
                .sum();
        profit.updateProfit(price);
    }
    public double getProfit(long buyPrice) {
        long total = profit.getTotal();
        double ret = ((double) total / buyPrice) * 100;
        return ret;

    }

}
