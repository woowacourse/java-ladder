package ladder;

import java.util.Scanner;
import ladder.controller.LadderController;
import ladder.domain.generator.LineGenerator;
import ladder.domain.generator.RandomDirectionGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController(inputView(), outputView(), lineGenerator());
        ladderController.run();
    }

    private static InputView inputView() {
        return new InputView(scanner());
    }

    private static Scanner scanner() {
        return new Scanner(System.in);
    }

    private static OutputView outputView() {
        return new OutputView();
    }

    private static LineGenerator lineGenerator() {
        return new LineGenerator(directionGenerator());
    }

    private static RandomDirectionGenerator directionGenerator() {
        return new RandomDirectionGenerator();
    }
}
