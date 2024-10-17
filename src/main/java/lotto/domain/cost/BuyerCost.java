package lotto.domain.cost;

import lotto.domain.Profit;

public class BuyerCost implements IBuyerCost{
    private final long price;
    BuyerCost(long price) {
        this.price = price;
    }

    @Override
    public int spendMoney() {
        return (int) (price / 1000);
    }

    @Override
    public long getPrice() {
        return price;
    }
}



