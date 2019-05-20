package ladder.controller;

import ladder.model.ladder.Ladder;
import ladder.model.laddergame.LadderGame;
import ladder.model.laddergame.LadderGameResult;
import ladder.model.linepointsgenerator.LinePointsGenerator;
import ladder.model.linepointsgenerator.impl.RandomLinePointsGenerator;
import ladder.model.player.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class MainController {
    private static final String ALL_PLAYERS = "all";

    public static void main(String[] args) {
        List<String> names = InputView.inputNames();
        Players players = new Players(names);

        int countOfPlayer = names.size();
        LinePointsGenerator linePointsGenerator = new RandomLinePointsGenerator(countOfPlayer);

        LadderGameResult ladderGameResult = new LadderGameResult(InputView.inputLadderGameResult(), countOfPlayer);

        int height = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(linePointsGenerator, height);

        LadderGame ladderGame = new LadderGame(players, ladder, ladderGameResult);
        ladderGame.playGame();

        OutputView.printLadderResult(players, ladder, ladderGameResult);

        String desiredResult = InputView.inputDesiredResult().trim();
        while (!desiredResult.equals(ALL_PLAYERS)) {
            OutputView.printExecutionResult(ladderGame.getResultByName(desiredResult));
            desiredResult = InputView.inputDesiredResult();
        }

        OutputView.printExecutionResult(ladderGame.getAllResult());
    }
}
