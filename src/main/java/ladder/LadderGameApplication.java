package ladder;

import ladder.domain.GameResult;
import ladder.domain.LadderGame;
import ladder.generator.LadderGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGameApplication {

    private static final String STOP_MESSAGE = "all";
    private static final String BLANK = "";

    public static void main(String[] args) {
        LadderGame ladderGame = generateLadderGame();

        GameResult result = ladderGame.play();

        OutputView.printLadder(ladderGame.toString());

        String message = BLANK;
        while (!message.equals(STOP_MESSAGE)) {
            message = InputView.getResult();
            String resultMassage = getResultMessage(result, message);
            OutputView.printResult(resultMassage);
        }
    }

    private static String getResultMessage(GameResult result, String message) {
        try {
            return result.getResult(message);
        } catch (IllegalArgumentException ie) {
            return ie.getMessage();
        }
    }

    private static LadderGame generateLadderGame() {
        List<String> names = InputView.getNames();
        List<String> rewards = InputView.getRewards();
        int countOfLines = InputView.getCountOfLines();
        try {
            return new LadderGame(names, rewards, new LadderGenerator().makeLadder(names.size(), countOfLines));
        } catch (IllegalArgumentException ie) {
            OutputView.PrintMassage(ie.getMessage());
            return generateLadderGame();
        }
    }
}