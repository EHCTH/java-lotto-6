package lotto.enums.regex;

import java.util.regex.Pattern;

public enum RegexPattern {
    NOT_NUMBER(Pattern.compile(".*[\\D].*"));
    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }
    public static boolean matches(String input) {
        return !NOT_NUMBER.pattern.matcher(input).matches();
    }

    public static void main(String[] args) {
        System.out.println(matches("1"));
        System.out.println(!matches("1"));
    }
}
