package lotto.domain;

import lotto.domain.cost.IBuyerCost;
import lotto.domain.cost.ICost;

public class Profit {
    private ICost cost;
    public Profit(ICost cost) {
        this.cost = cost;
    }
    public void updateProfit(long price) {
        this.cost.updateCost(price);
    }
    public long getTotal() {
        return cost.getTotal();
    }
    public double getProfit(IBuyerCost buyerCost) {
        long total = cost.getTotal();
        long buyPrice = buyerCost.getPrice();
        return ((double) total / buyPrice) * 100;
    }


}
