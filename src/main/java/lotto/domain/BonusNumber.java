package lotto.domain;

import lotto.validate.LottoValidator;

public class BonusNumber {
    private final int number;
    public BonusNumber(int number) {
        LottoValidator.validateMaxMin(number);
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public int winningBonusNumber(Lotto lotto) {
        return lotto.winningBonusNumber(number);
    }
}
