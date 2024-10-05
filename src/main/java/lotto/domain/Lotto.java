package lotto.domain;

import lotto.validate.LottoValidator;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        LottoValidator.validateDuplicate(numbers);
        LottoValidator.validateMaxMin(numbers);
        this.numbers = sort(numbers);
    }


    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    // 여기 까지
    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    // TODO: 추가 기능 구현
    public void sort() {
        Collections.sort(numbers);
    }

    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    public int winningNumber(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
    }
    public int winningBonusNumber(int bonusNumber) {
        return (int) numbers.stream()
                .filter((number) -> number == bonusNumber)
                .count();
    }
}
