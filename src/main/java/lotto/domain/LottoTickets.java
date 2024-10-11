package lotto.domain;

import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;
    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
        sort();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        lottoTickets.forEach((lotto) -> sb.append(lotto)
                .append("\n"));

        return sb.toString();
    }
    public void sort() {lottoTickets.forEach(Lotto::sort);}

    public List<Lotto> infoTickets() {
        return lottoTickets;
    }
}
