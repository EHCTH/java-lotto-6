package lotto.domain.cost;

public class BuyerCost implements IBuyerCost{

    private long total = 0L;

    @Override
    public int spendMoney() {
        return (int) (total / 1000);
    }

    @Override
    public void updateCost(long price) {
        total += price;
    }

    @Override
    public long getTotal() {
        return total;
    }
}
