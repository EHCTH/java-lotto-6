package lotto.domain.cost;

public interface IBuyerCost{
    int spendMoney();
    void updateCost(long price);
    long getTotal();
}
