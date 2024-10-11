package lotto.handler;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.cost.BuyerCostFactory;
import lotto.domain.cost.IBuyerCost;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.function.Function;
import java.util.function.Supplier;

public class InputHandler {
    public static IBuyerCost receiveValidatedPurchasePrice() {
        return receiveValidatedInput(InputView::inputPurchasePrice, BuyerCostFactory::insertCoin);
    }
    public static Lotto receiveValidatorWinningNumber() {
        return receiveValidatedInput(InputView::inputWinningNumber, Lotto::of);
    }
    public static BonusNumber receiveValidatorBonusNumber(Lotto selectWinningLotto) {
        return receiveValidatedInput(InputView::inputBonusNumber,
                (bonusNumber) ->
                BonusNumber.validateDuplicateOf(bonusNumber, selectWinningLotto));
    }

    private static <R> R receiveValidatedInput(Supplier<String> inputView, Function<String, R> conversion) {
        while (true) {
            try {
                String input = inputView.get();
                return conversion.apply(input);
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessageFor(exception);
            }
        }
    }
}
