package lotto.domain.cost;

public class Cost implements ICost {
    private long total = 0L;
    public void updateCost(long price) {
        total += price;
    }
    public String toString() {
        return "" + total;
    }
    public long getTotal() {
         return total;
    }
}
