package lotto.domain;

import lotto.util.Convertor;
import lotto.validate.LottoValidator;

public class BonusNumber {
    private final int number;
    private BonusNumber(int number) {
        LottoValidator.validateMaxMin(number);
        this.number = number;
    }
    public static BonusNumber validateDuplicateOf(String input, Lotto lotto) {
        int bonusNumber = Convertor.nextInt(input);
        LottoValidator.validateExistsNumber(lotto, bonusNumber);
        return new BonusNumber(bonusNumber);
    }
    public int winningBonusNumber(Lotto lotto) {
        return lotto.winningBonusNumber(number);
    }
}
