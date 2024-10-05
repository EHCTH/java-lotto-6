package lotto.validate;

import lotto.constant.LottoConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;

public class LottoValidator {
    public static boolean isWithinRange(int num) {
        return LottoConstant.MIN_VALUE <= num && num <= LottoConstant.MAX_VALUE;
    }
    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리가 아닙니다");
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        int removeDuplicateCount = new HashSet<>(numbers).size();
        if (removeDuplicateCount != LottoConstant.LOTTO_COUNT_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 넣었습니다");
        }
    }

    public static void validateMaxMin(List<Integer> numbers) {
        boolean pass = numbers.stream().allMatch(LottoValidator::isWithinRange);
        if (!pass) throw new IllegalArgumentException("[ERROR] 최소값 또는 최대값을 넘었습니다");
    }
    public static void validateMaxMin(int number) {
        if (!isWithinRange(number)) throw new IllegalArgumentException("[ERROR] 최소값 또는 최대값을 넘었습니다");
    }
    public static void validateExistsNumber(Lotto lotto, BonusNumber bonusNumber) {
       boolean duplicateNumber = lotto.getNumbers().contains(bonusNumber.getNumber());
       if (duplicateNumber) throw new IllegalArgumentException("[ERROR] 이미 있는 번호 입니다");
    }
}
