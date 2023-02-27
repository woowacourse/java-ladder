import controller.LadderGameController;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        RandomBooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();

        LadderGameController ladderGameController =
                new LadderGameController(inputView, outputView, randomBooleanGenerator);
        ladderGameController.play();
    }
}
