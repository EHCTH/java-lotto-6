package lotto.service;

import lotto.constant.LottoConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningLottery;
import camp.nextstep.edu.missionutils.Console;
import lotto.validate.BuyerValidator;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;


public class WinningLottoSelectService {
    public WinningLottery selectWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottos = Console.readLine();
        System.out.println(lottos);
        String[] lottoSplit = lottos.split(",");
        BuyerValidator.validateDigit(lottoSplit);
        List<Integer> selectWinningLotto = Arrays.stream(lottoSplit)
                .map(Integer::parseInt)
                .collect(toList());
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println(bonusNumber);
        BuyerValidator.validateBonusNumberRange(bonusNumber);
        return new WinningLottery(new Lotto(selectWinningLotto),
                new BonusNumber(Integer.parseInt(bonusNumber)));

    }
}
