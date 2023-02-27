package ladder;

import java.util.Scanner;
import ladder.client.LadderClientController;
import ladder.client.view.InputView;
import ladder.domain.LadderGameController;
import ladder.domain.RandomConnectionJudgement;

public class Application {

    public static void main(String[] args) {
        try (InputView inputView = getInputView()) {
            LadderClientController ladderClientController = new LadderClientController(
                    inputView,
                    getLadderGame()
            );
            ladderClientController.play();
        }
    }

    private static LadderGameController getLadderGame() {
        return new LadderGameController(new RandomConnectionJudgement());
    }

    private static InputView getInputView() {
        return new InputView(new Scanner(System.in));
    }
}
