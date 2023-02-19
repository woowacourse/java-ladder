import controller.LadderController;
import domain.service.LadderMaker;
import domain.service.RandomBooleanGenerator;
import validator.*;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(makeInputView(), new OutputView(), makeLadderMaker());
        ladderController.play();
    }

    private static InputView makeInputView() {
        return new InputView(makeInputValidator());
    }
    private static InputValidator makeInputValidator() {
        return InputValidator.builder()
                .add(new EmptyInputValidatorChain())
                .add(new NotIntegerValidatorChain())
                .build();
    }

    private static LadderMaker makeLadderMaker() {
        return new LadderMaker(new RandomBooleanGenerator());
    }

}
