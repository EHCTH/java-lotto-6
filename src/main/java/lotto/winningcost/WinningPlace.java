package lotto.winningcost;

import lotto.domain.Lotto;
import lotto.domain.WinningLottery;

import java.util.Arrays;

public enum WinningPlace {

    FIRST_PLACE(6, 2_000_000_000L, 0, "6개 일치 (2,000,000,000원)"),
    SECOND_PLACE(6, 30_000_000L, 0, "5개 일치, 보너스 볼 일치 (30,000,000원)") {
        public boolean isWinning(WinningLottery winningLottery, Lotto lotto) {
            int winningCount = winningLottery.bonusNumberInvolveWinningNumber(lotto);
            return isWinning(winningCount);
        }
    },
    THIRD_PLACE(5, 1_500_000L, 0, "5개 일치 (1,500,000원)"),
    FOURTH_PLACE(4, 50_000L, 0, "4개 일치 (50,000원)"),
    FIFTH_PLACE(3, 5_000L, 0,"3개 일치 (5,000원)"),
    LAST_PLACE(0, 0L, 0, "");
    private final int winningNumber;
    private final long cost;
    private int count;
    private final String lottoInfo;
    WinningPlace(int winningNumber, long cost, int count, String lottoInfo) {
        this.winningNumber = winningNumber;
        this.cost = cost;
        this.count = count;
        this.lottoInfo = lottoInfo;
    }

    private static final WinningPlace[] WINNING_ARR = values();
    public static long calculatePrize(WinningLottery winningLottery, Lotto lotto) {
        return Arrays.stream(WINNING_ARR)
                .filter((winningPlace) -> winningPlace.isWinning(winningLottery, lotto))
                .findFirst()
                .map((winningPlace) -> {
                    winningPlace.count++;
                    return winningPlace.cost;
                })
                .orElse(LAST_PLACE.cost);
    }
    public boolean isWinning(WinningLottery winningLottery, Lotto lotto) {
        int winningCount = winningLottery.countMatchedNumbers(lotto);
        return isWinning(winningCount);
    }
    public boolean isWinning(int number) {
        return winningNumber == number;
    }
    public static String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = WINNING_ARR.length - 2; i >= 0; i--) {
            WinningPlace winningPlace = WINNING_ARR[i];
            sb.append(winningPlace.lottoInfo)
                    .append(" - ")
                    .append(winningPlace.count)
                    .append("개\n");
        }
        return sb.toString();
//        Arrays.stream(WINNING_ARR)
//                .filter((winningCost) -> winningCost != LAST_PLACE)
//                .forEach((winningCost) ->
//                        sb.append(winningCost.lottoInfo)
//                                .append(" - ")
//                                .append(winningCost.count)
//                                .append("개\n"));
//        return sb.toString();
    }
}
