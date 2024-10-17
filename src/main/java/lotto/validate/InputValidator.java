package lotto.validate;

import lotto.enums.delimiter.Delimiter;
import lotto.enums.regex.RegexPattern;
import lotto.util.Convertor;

import java.util.Arrays;

public class InputValidator {
    private final static long DEFAULT_VALUE= 1000L;
    private final static long MAX_PURCHASE_PRICE = 100000L;
    /*
    - [x] 값이 있는가
    - [x] 정수인가
    - [x] 1000원으로 떨어지는가

     */
    public static void validatorPurchase(String input) {
        validatorOfNull(input);
        validatorOfNaturalInteger(input);
        validatorOfModThousand(input);
        validatorMaxPrice(input);
    }
    public static void validatorWinningNumber(String input) {
        validatorOfNull(input);
        validatorDelimiterComma(input);
        validatorOfNaturalInteger(Convertor.splitByComma(input));
        validatorBlank(input);
    }
    public static void validatorBonusNumber(String input) {
        validatorOfNull(input);
        validatorOfNaturalInteger(input);
        validatorMaxPrice(input);

    }
    private static void validatorOfNull(String input) {
        if (input.isEmpty()) throw new IllegalArgumentException("[ERROR] 값이 없습니다");
    }
    private static void validatorOfNaturalInteger(String input) {
        if (!RegexPattern.matches(input)) throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요");
    }
    private static boolean isModThousand(String input) {
        long price = Long.parseLong(input);
        return price % DEFAULT_VALUE == 0;
    }
    private static void validatorOfModThousand(String input) {
        if (!isModThousand(input)) throw new IllegalArgumentException("[ERROR] 금액은 1000단위로 입력해주세요");
    }

    private static boolean isMaxPrice(String input) {
        long price = Long.parseLong(input);
        return price <= MAX_PURCHASE_PRICE;
    }
    private static void validatorMaxPrice(String input) {
        if (!isMaxPrice(input)) throw new IllegalArgumentException("[ERROR] 최대 금액을 넘었습니다");
    }
    private static void validatorDelimiterComma(String input) {
        if (!input.contains(Delimiter.getDelimiter())) throw new IllegalArgumentException("[ERROR] 콤마로 구분해야합니다");
    }

    private static boolean isBlank(String[] input) {
        return Arrays.stream(input).anyMatch(String::isBlank);
    }
    private static void validatorBlank(String input) {
        if (isBlank(Convertor.splitByComma(input))) throw new IllegalArgumentException("[ERROR] 공백이 있습니다");
    }
    private static void validatorOfNaturalInteger(String[] input) {
        boolean integer = Arrays.stream(input)
                .allMatch(RegexPattern::matches);
        if (!integer) throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요");
    }

}













