package lotto.domain;

import lotto.validate.LottoValidator;

public class WinningLottery {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;
    public WinningLottery(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }
    public int countMatchedNumbers(Lotto lotto) {
        return this.lotto.winningNumber(lotto);
    }
    public int bonusNumberInvolveWinningNumber(Lotto lotto) {
        int winningNumber = this.lotto.winningNumber(lotto);
        int winningBonusNumber = bonusNumber.winningBonusNumber(lotto);
        int total = winningNumber + winningBonusNumber;
        return total;
    }
}
