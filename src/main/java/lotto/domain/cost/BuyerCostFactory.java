package lotto.domain.cost;

import lotto.util.Convertor;

public class BuyerCostFactory {
    public static BuyerCost insertCoin(String price) {
        return new BuyerCost(Convertor.nextLong(price));
    }
}
