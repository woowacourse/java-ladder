package ladder;

import java.util.Scanner;
import ladder.client.LadderGameClient;
import ladder.client.view.InputView;
import ladder.domain.LadderGame;
import ladder.domain.RandomConnectionJudgement;
import ladder.repository.LadderRepositoryImpl;

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

    private static LadderGame getLadderGame() {
        return new LadderGame(new RandomConnectionJudgement(), new LadderRepositoryImpl());
    }

    private static InputView getInputView() {
        return new InputView(new Scanner(System.in));
    }
}
