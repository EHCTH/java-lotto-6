package lotto.service;

import lotto.domain.LottoTickets;
import lotto.domain.cost.IBuyerCost;
import lotto.view.OutputView;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoBuyerService {
    private final IBuyerCost buyerCost;
    private final CreateRandomLotto createRandomLotto;

    public LottoBuyerService(IBuyerCost buyerCost, CreateRandomLotto createRandomLotto) {
        this.buyerCost = buyerCost;
        this.createRandomLotto = createRandomLotto;
        OutputView.printInsertCoin(buyerCost);
    }

    public LottoTickets buy() {
        OutputView.printPurchaseAmount(buyerCost);
        return new LottoTickets(Stream
                .generate(createRandomLotto::createLotto)
                .limit(buyerCost.spendMoney())
                .collect(toList()));
    }

    public IBuyerCost getCost() {
        return buyerCost;
    }
}
