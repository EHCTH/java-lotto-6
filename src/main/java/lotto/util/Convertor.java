package lotto.util;

import lotto.enums.delimiter.Delimiter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    public static int nextInt(String value) {
        return Integer.parseInt(value);
    }
    public static long nextLong(String value) {
        return Long.parseLong(value);
    }
    public static List<Integer> toList(String value) {
        return Arrays.stream(splitByComma(value))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    public static String[] splitByComma(String value) {
        return value.split(Delimiter.getDelimiter());
    }
}
