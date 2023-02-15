package config;

import controller.LadderController;
import utils.NumberGenerator;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class LadderControllerFactory {

    private LadderControllerFactory() {
        throw new IllegalStateException("인스턴스화 할 수 없는 클래스입니다.");
    }

    public static LadderController generate() {
        return new LadderController(initInputView(), initOutputView(), initNumberGenerator());
    }

    private static InputView initInputView() {
        return new InputView();
    }

    private static OutputView initOutputView() {
        return new OutputView();
    }

    private static NumberGenerator initNumberGenerator() {
        return new RandomNumberGenerator();
    }
}
