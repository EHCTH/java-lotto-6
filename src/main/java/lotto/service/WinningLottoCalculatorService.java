package lotto.service;

import lotto.domain.LottoTickets;
import lotto.domain.Profit;
import lotto.domain.WinningLottery;
import lotto.enums.winningPlace.WinningPlace;

public class WinningLottoCalculatorService {
    private final Profit profit;
    public WinningLottoCalculatorService(Profit profit) {
        this.profit = profit;
    }
    public long calculateTotalPrize(WinningLottery winningLottery, LottoTickets lottoTickets) {
        return lottoTickets.infoTickets()
                .stream()
                .mapToLong(lotto -> WinningPlace.calculatePrize(winningLottery, lotto))
                .sum();
    }
    public Profit updateProfit(WinningLottery winningLottery, LottoTickets lottoTickets) {
        long totalPrize = calculateTotalPrize(winningLottery, lottoTickets);
        profit.updateProfit(totalPrize);
        return profit;
    }

}
