import controller.LadderController;
import domain.service.LadderMaker;
import domain.service.RandomBooleanGenerator;
import validator.EmptyInputValidatorChain;
import validator.InputValidator;
import validator.NotIntegerValidatorChain;
import validator.SuccessInputValidatorChain;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(makeInputView(), new OutputView(), makeLadderMaker());
        ladderController.play();
    }

    private static LadderMaker makeLadderMaker() {
        return new LadderMaker(new RandomBooleanGenerator());
    }

    private static InputView makeInputView() {
        return new InputView(makeInputValidator());
    }

    private static InputValidator makeInputValidator() {
        InputValidator emptyInputValidatorChain = new EmptyInputValidatorChain();
        InputValidator notIntegerValidatorChain = new NotIntegerValidatorChain();
        InputValidator successInputValidatorChain = new SuccessInputValidatorChain();
        notIntegerValidatorChain.setNext(successInputValidatorChain);
        emptyInputValidatorChain.setNext(notIntegerValidatorChain);
        return emptyInputValidatorChain;
    }
}
