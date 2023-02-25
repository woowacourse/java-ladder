package ladder;

import java.util.Scanner;
import ladder.client.view.InputView;
import ladder.client.view.LadderGameClient;
import ladder.domain.LadderGameImpl;
import ladder.domain.ladder.RandomConnectionJudgement;

public class Application {

    public static void main(String[] args) {
        try (InputView inputView = getInputView()) {
            LadderGameClient ladderGameClient = new LadderGameClient(
                    inputView,
                    getLadderGame()
            );
            ladderGameClient.play();
        }
    }

    private static LadderGameImpl getLadderGame() {
        return new LadderGameImpl(new RandomConnectionJudgement());
    }

    private static InputView getInputView() {
        return new InputView(new Scanner(System.in));
    }
}
