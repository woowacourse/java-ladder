import controller.LadderController;
import domain.model.RandomBooleanGenerator;
import domain.model.LadderGame;
import validator.EmptyInputValidatorChain;
import validator.InputValidatorChain;
import validator.NotIntegerValidatorChain;
import validator.SuccessInputValidatorChain;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController(makeInputView(), new OutputView(),
            new LadderGame(new RandomBooleanGenerator()));
        ladderController.play();
    }

    private static InputView makeInputView() {
        return new InputView(makeInputValidator());
    }


    private static InputValidatorChain makeInputValidator() {
        InputValidatorChain emptyInputValidatorChain = new EmptyInputValidatorChain();
        InputValidatorChain notIntegerValidatorChain = new NotIntegerValidatorChain();
        InputValidatorChain successInputValidatorChain = new SuccessInputValidatorChain();
        notIntegerValidatorChain.setNext(successInputValidatorChain);
        emptyInputValidatorChain.setNext(notIntegerValidatorChain);
        return emptyInputValidatorChain;
    }
}
