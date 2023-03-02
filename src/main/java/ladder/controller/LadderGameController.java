package ladder.controller;

import ladder.constant.Command;
import ladder.domain.RandomGenerator;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.laddergame.ResultOfLadderGame;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Map;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomGenerator randomGenerator;

    public LadderGameController(final InputView inputView, final OutputView outputView, final RandomGenerator randomGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomGenerator = randomGenerator;
    }

    public void run() {
        final Players players = createPlayersUntilNoException();
        final Rewards rewards = createRewardsUntilNoException(players.findNumberOfPlayers());
        final Ladder ladder = createLadder(players);
        outputView.printLadder(players, ladder, rewards);

        final ResultOfLadderGame result = playLadderGame(players, ladder, rewards);
        printResult(result);
    }

    private Players createPlayersUntilNoException() {
        return IllegalArgumentExceptionHandler.repeatUntilNoException(
                inputView::inputPlayerNames, Players::new, outputView
        );
    }

    private Rewards createRewardsUntilNoException(final int numberOfPlayers) {
        return IllegalArgumentExceptionHandler.repeatUntilNoException(
                inputView::inputRewards, inputRewards -> new Rewards(numberOfPlayers, inputRewards)
                , outputView);
    }

    private Height createHeightUntilNoException() {
        return IllegalArgumentExceptionHandler.repeatUntilNoException(
                inputView::inputHeightOfLadder, Height::new, outputView
        );
    }

    private Ladder createLadder(final Players players) {
        final int numberOfPlayers = players.findNumberOfPlayers();
        final int heightOfLadder = createHeightUntilNoException().getHeight();

        return new Ladder(heightOfLadder, numberOfPlayers, randomGenerator);
    }

    private ResultOfLadderGame playLadderGame(final Players players, final Ladder ladder, final Rewards rewards) {
        players.movePlayers(ladder);
        return new ResultOfLadderGame(players.findResultOfPlayersWith(rewards));
    }

    private String inputRequestUntilNoException(final ResultOfLadderGame resultOfLadderGame) {
        return IllegalArgumentExceptionHandler.repeatUntilNoException(
                inputView::inputRequestForResult, resultOfLadderGame::findValidRequest, outputView);
    }

    private void printResult(final ResultOfLadderGame resultOfLadderGame) {
        String request;
        do {
            request = inputRequestUntilNoException(resultOfLadderGame);
            printResultByRequest(request, resultOfLadderGame);

        } while (!request.equals(Command.REQUEST_TO_GET_ALL_RESULT));
    }

    private void printResultByRequest(final String request, final ResultOfLadderGame resultOfLadderGame) {
        final Map<String, String> result = resultOfLadderGame.findResultByRequest(request);

        if (request.equals(Command.REQUEST_TO_GET_ALL_RESULT)) {
            outputView.printResultOfAll(result);
            return;
        }
        outputView.printResultOfPlayer(result.get(request));

    }


}
