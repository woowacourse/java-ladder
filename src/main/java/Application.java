import controller.LadderGameController;
import domain.ladder.RandomPointGenerator;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        LadderGameController ladderGameController = new LadderGameController(
                new InputView(scanner),
                new OutputView(),
                new RandomPointGenerator()
        );
        ladderGameController.play();
        scanner.close();
    }
}
