package ladder;

import ladder.domain.LadderGame;
import ladder.generator.LadderGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGameApplication {

    private static final String STOP_MESSAGE = "all";
    private static final String BLANK = "";

    public static void main(String[] args) {
        List<String> names = InputView.getNames();
        List<String> rewards = InputView.getRewards();
        int countOfLines = InputView.getCountOfLines();

        LadderGame ladderGame = new LadderGame(names, rewards, new LadderGenerator().makeLadder(names.size(), countOfLines));

        ladderGame.play();

        OutputView.printLadder(ladderGame.toString());

        String message = BLANK;
        while (!message.equals(STOP_MESSAGE)) {
            message = InputView.getResult();
            OutputView.printResult(ladderGame.drawResult(message));
        }
    }
}