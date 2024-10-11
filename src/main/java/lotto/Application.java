package lotto;

import lotto.controller.Controller;
import lotto.controller.ControllerFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = ControllerFactory.createController();
        controller.run();
    }
}
