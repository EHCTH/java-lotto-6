package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class CreateRandomLotto {
    public Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
