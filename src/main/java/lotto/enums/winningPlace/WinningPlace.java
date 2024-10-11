package lotto.enums.winningPlace;

import lotto.domain.Lotto;
import lotto.domain.WinningLottery;

import java.util.Arrays;
import java.util.Comparator;

public enum WinningPlace {

    FIRST_PLACE(6, 2_000_000_000L, 0, "6개 일치 (2,000,000,000원)", 5),
    SECOND_PLACE(6, 30_000_000L, 0, "5개 일치, 보너스 볼 일치 (30,000,000원)",4) {
        @Override
        public boolean isWinning(WinningLottery winningLottery, Lotto lotto) {
            int winningCount = winningLottery.bonusNumberInvolveWinningNumber(lotto);
            return matchesWinningCount(winningCount);
        }
    },
    THIRD_PLACE(5, 1_500_000L, 0, "5개 일치 (1,500,000원)",3),
    FOURTH_PLACE(4, 50_000L, 0, "4개 일치 (50,000원)",2),
    FIFTH_PLACE(3, 5_000L, 0,"3개 일치 (5,000원)",1),
    LAST_PLACE(0, 0L, 0, "", 0);
    private final int winningNumber;
    private final long cost;
    private int count;
    private final String lottoInfo;
    private final int sequence;
    WinningPlace(int winningNumber, long cost, int count, String lottoInfo, int sequence) {
        this.winningNumber = winningNumber;
        this.cost = cost;
        this.count = count;
        this.lottoInfo = lottoInfo;
        this.sequence = sequence;
    }

    private static final WinningPlace[] WINNING_ARR = values();
    private void incrementCount() {
        this.count++;
    }
    public static long calculatePrize(WinningLottery winningLottery, Lotto lotto) {
        return Arrays.stream(WINNING_ARR)
                .filter((winningPlace) -> winningPlace.isWinning(winningLottery, lotto))
                .findFirst()
                .map((winningPlace) -> {
                    winningPlace.incrementCount();
                    return winningPlace.cost;
                })
                .orElse(LAST_PLACE.cost);
    }
    public boolean isWinning(WinningLottery winningLottery, Lotto lotto) {
        int winningCount = winningLottery.countMatchedNumbers(lotto);
        return matchesWinningCount(winningCount);
    }
    public boolean matchesWinningCount(int number) {
        return winningNumber == number;
    }
    public static String print() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(WINNING_ARR)
                .sorted(Comparator.comparing((winningPlace) -> winningPlace.sequence))
                .filter((winningCost) -> winningCost != LAST_PLACE)
                .forEach((winningCost) ->
                        sb.append(winningCost.lottoInfo)
                                .append(" - ")
                                .append(winningCost.count)
                                .append("개\n"));
        return sb.toString();
    }
}
