package ladder;

import ladder.domain.LadderGame;
import ladder.generator.LadderGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameApplication {

    private static final String STOP_MESSAGE = "all";
    private static final String BLANK = "";

    public static void main(String[] args) {
        String[] names = InputView.getNames();
        String[] drawResults = InputView.getDrawResults();
        int countOfLines = InputView.getCountOfLines();

        LadderGame ladderGame = new LadderGame(names, drawResults, new LadderGenerator().makeLadder(names.length, countOfLines));

        ladderGame.play();

        OutputView.printLadder(ladderGame.toString());

        String message = BLANK;
        while (!message.equals(STOP_MESSAGE)) {
            message = InputView.getResult();
            OutputView.printResult(ladderGame.drawResult(message));
        }
    }
}