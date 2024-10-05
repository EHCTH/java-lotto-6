package lotto.validate;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BuyerValidator {
    public static void validatePurchaseAmount(long price) {
        if (price % 1000 != 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력 받아야합니다") ;
    }
    public static void validateDigit(String coin) {
        if (!coin.matches("^\\d+$")) throw new IllegalArgumentException("[ERROR] 올바르지 않은 문자가 입력 되었습니다");
    }
    public static void validateDigit(String[] lottoSplit) {
        String lotto = Arrays.stream(lottoSplit).collect(Collectors.joining());
        if (!lotto.matches("^\\d+$")) throw new IllegalArgumentException("[ERROR] 올바르지 않은 문자가 입력 되었습니다");
    }
    public static void validateBonusNumberRange(String bonusNumber) {
        if (bonusNumber.length() > 2) throw new IllegalArgumentException("[ERROR] 보너스 번호를 다시 입력해주세요");
    }
}
