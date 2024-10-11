package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningLottery;
import lotto.handler.InputHandler;



public class WinningLottoSelectService {
    public WinningLottery selectWinningLotto() {
        Lotto selectWinningLotto = InputHandler.receiveValidatorWinningNumber();
        BonusNumber bonusNumber = InputHandler.receiveValidatorBonusNumber(selectWinningLotto);
        return new WinningLottery(selectWinningLotto, bonusNumber);
    }
}
