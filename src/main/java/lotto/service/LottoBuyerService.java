package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.cost.IBuyerCost;
import lotto.validate.BuyerValidator;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyerService {
    private final IBuyerCost buyerCost;
    public LottoBuyerService(IBuyerCost buyerCost) {
        this.buyerCost = buyerCost;
    }
    public void insertCoin() {
        String buyCoin = Console.readLine();
        BuyerValidator.validateDigit(buyCoin);
        long coin = Long.parseLong(buyCoin);
        BuyerValidator.validatePurchaseAmount(coin);
        buyerCost.updateCost(coin);

    }
    public LottoTickets buy() {
        List<Lotto> lottoTickets = new ArrayList<>();
        System.out.println(buyerCost.spendMoney() + "개를 구매했습니다.");
        for (int i = 0; i < buyerCost.spendMoney(); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTickets.add(Lotto.of(numbers));
        }
        return new LottoTickets(lottoTickets);
    }
    public long getCost() {
        return buyerCost.getTotal();
    }
}
