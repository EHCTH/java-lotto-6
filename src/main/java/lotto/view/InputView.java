package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.InputValidator;

import java.util.function.Consumer;

public class InputView {
    public static String inputPurchasePrice() {
        OutputView.printPurchaseInputText();
        return readLine(InputValidator::validatorPurchase);
    }
    public static String inputWinningNumber() {
        OutputView.printSelectWinningLottoNumber();
        return readLine(InputValidator::validatorWinningNumber);
    }
    public static String inputBonusNumber() {
        OutputView.printBonusNumber();
        return readLine(InputValidator::validatorBonusNumber);
    }

    public static String readLine(Consumer<String> validator) {
        String input = Console.readLine();
        validator.accept(input);
        return input;
    }
}
