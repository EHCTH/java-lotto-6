package lotto.winningCost;

import lotto.domain.*;
import lotto.domain.cost.Cost;
import lotto.service.WinningLottoCalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningCostTest {
    @DisplayName("맞춘 번호 금액에 따른 테스트")
    @Test
    void firstPlaceTest() {
        Lotto winnigLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLottery winningLottery = new WinningLottery(winnigLotto, bonusNumber);

        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        LottoTickets lottoTickets = new LottoTickets(List.of(lotto));
        WinningLottoCalculatorService winningLottoCalculatorService =
                new WinningLottoCalculatorService(new Profit(new Cost()));
        Profit profit = winningLottoCalculatorService.updateProfit(winningLottery, lottoTickets);
        assertThat(profit.getTotal()).isEqualTo(2_000_000_000L);

    }

    @Test
    void secondPlaceTest() {
        Lotto winnigLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLottery winningLottery = new WinningLottery(winnigLotto, bonusNumber);

        Lotto lotto = Lotto.of(List.of(7, 2, 3, 4, 5, 6));
        LottoTickets lottoTickets = new LottoTickets(List.of(lotto));
        WinningLottoCalculatorService winningLottoCalculatorService =
                new WinningLottoCalculatorService(new Profit(new Cost()));
        Profit profit = winningLottoCalculatorService.updateProfit(winningLottery, lottoTickets);
        assertThat(profit.getTotal()).isEqualTo(30_000_000L);
    }

    @Test
    void thirdPlaceTest() {
        Lotto winnigLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLottery winningLottery = new WinningLottery(winnigLotto, bonusNumber);

        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 8));
        LottoTickets lottoTickets = new LottoTickets(List.of(lotto));
        WinningLottoCalculatorService winningLottoCalculatorService =
                new WinningLottoCalculatorService(new Profit(new Cost()));
        Profit profit = winningLottoCalculatorService.updateProfit(winningLottery, lottoTickets);
        assertThat(profit.getTotal()).isEqualTo(1_500_000L);
    }

    @Test
    void fourthPlaceTest() {
        Lotto winnigLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLottery winningLottery = new WinningLottery(winnigLotto, bonusNumber);

        Lotto lotto = Lotto.of(List.of(2, 3, 4, 5, 8, 9));
        LottoTickets lottoTickets = new LottoTickets(List.of(lotto));
        WinningLottoCalculatorService winningLottoCalculatorService =
                new WinningLottoCalculatorService(new Profit(new Cost()));
        Profit profit = winningLottoCalculatorService.updateProfit(winningLottery, lottoTickets);
        assertThat(profit.getTotal()).isEqualTo(50_000L);
    }

    @Test
    void fifthPlaceTest() {
        Lotto winnigLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLottery winningLottery = new WinningLottery(winnigLotto, bonusNumber);

        Lotto lotto = Lotto.of(List.of(1, 2, 3, 8, 9, 10));
        LottoTickets lottoTickets = new LottoTickets(List.of(lotto));
        WinningLottoCalculatorService winningLottoCalculatorService =
                new WinningLottoCalculatorService(new Profit(new Cost()));
        Profit profit = winningLottoCalculatorService.updateProfit(winningLottery, lottoTickets);
        assertThat(profit.getTotal()).isEqualTo(5_000L);
    }

    @Test
    void lastPlaceTest() {
        Lotto winnigLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLottery winningLottery = new WinningLottery(winnigLotto, bonusNumber);

        Lotto lotto = Lotto.of(List.of(8, 9, 10, 11, 12, 13));
        LottoTickets lottoTickets = new LottoTickets(List.of(lotto));
        WinningLottoCalculatorService winningLottoCalculatorService =
                new WinningLottoCalculatorService(new Profit(new Cost()));
        Profit profit = winningLottoCalculatorService.updateProfit(winningLottery, lottoTickets);
        assertThat(profit.getTotal()).isEqualTo(0L);
    }

}
