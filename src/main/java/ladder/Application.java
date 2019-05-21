package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Person person = InputView.inputNames();
        Result result = InputView.inputResultAll(person);
        LadderGame ladderGame = LadderGame.generateLadder(InputView.inputHeight(), person);
        OutputView.printLadder(ladderGame, person, result);
        GameResult gameResult = ladderGame.generateAllResults(person, result);
        String requestedName;
        do {
            requestedName = InputView.findResultName(gameResult, person);
            OutputView.printLadderResult(gameResult.getGameResult(requestedName, person));
        } while (!requestedName.equals("all"));
    }
}