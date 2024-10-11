package lotto.enums.delimiter;

public enum Delimiter {
    DELIMITER(",");
    private final String word;
    Delimiter(String word) {
        this.word = word;
    }
    public static String getDelimiter() {
        return DELIMITER.word;
    }
}
