package ladder.controller;

import ladder.model.ladder.Ladder;
import ladder.model.laddergame.LadderGame;
import ladder.model.laddergame.LadderGameResult;
import ladder.model.linepointsgenerator.LinePointsGenerator;
import ladder.model.linepointsgenerator.impl.RandomLinePointsGenerator;
import ladder.model.player.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class MainController {
    private static final String ALL_PLAYERS = "all";

    public static void main(String[] args) {
        LadderGame ladderGame = createLadderGame();
        ladderGame.playGame();

        OutputView.printLadderResult(ladderGame);

        String desiredResult = InputView.inputDesiredResult();
        while (!ladderGame.isFinished(desiredResult)) {
            OutputView.printExecutionResult(ladderGame.getResultByName(desiredResult));
            desiredResult = InputView.inputDesiredResult();
        }

        OutputView.printExecutionResult(ladderGame.getAllResult());
    }

    private static LadderGame createLadderGame() {
        Players players = createPlayers();
        Ladder ladder = createLadder(players.countOfPlayer());
        LadderGameResult ladderGameResult = createLadderGameResult(players.countOfPlayer());

        return new LadderGame(players, ladder, ladderGameResult);
    }

    private static LadderGameResult createLadderGameResult(int countOfPlayer) {
        return new LadderGameResult(InputView.inputLadderGameResult(), countOfPlayer);
    }

    private static Players createPlayers() {
        return new Players(InputView.inputNames());
    }

    private static Ladder createLadder(int countOfPlayer) {
        return new Ladder(new RandomLinePointsGenerator(countOfPlayer), InputView.inputLadderHeight());
    }
}
