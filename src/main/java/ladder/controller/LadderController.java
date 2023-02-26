package ladder.controller;

import ladder.constant.Command;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.player.Players;
import ladder.domain.RandomGenerator;
import ladder.domain.reward.Rewards;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Map;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomGenerator randomBarGenerator;

    public LadderController(InputView inputView, OutputView resultView, RandomGenerator randomBarGenerator) {
        this.inputView = inputView;
        this.outputView = resultView;
        this.randomBarGenerator = randomBarGenerator;
    }

    public void run() {
        Players players = createPlayersUntilNoException();
        Rewards rewards = createRewardsUntilNoException(players.findNumberOfAllPlayers());
        Ladder ladder = createLadder(players);

        LadderGame ladderGame = new LadderGame(players, ladder, rewards);
        outputView.printLadder(ladderGame.findPlayerNames(), ladder, rewards);
        printResult(ladderGame);
    }

    private Players createPlayersUntilNoException() {
        return IllegalArgumentExceptionHandler.repeatUntilNoException(
                inputView::inputPlayerNames, Players::from, outputView
        );
    }

    private Rewards createRewardsUntilNoException(int numberOfPlayers) {
        return IllegalArgumentExceptionHandler.repeatUntilNoException(
                inputView::inputRewards, inputRewards -> new Rewards(numberOfPlayers, inputRewards)
                , outputView);
    }

    private Ladder createLadder(Players players) {
        int numberOfPlayers = players.findNumberOfAllPlayers();
        int heightOfLadder = createHeightUntilNoException().getHeight();

        return Ladder.of(numberOfPlayers, heightOfLadder, randomBarGenerator);
    }

    private Height createHeightUntilNoException() {
        return IllegalArgumentExceptionHandler.repeatUntilNoException(
                inputView::inputHeightOfLadder, Height::new, outputView
        );
    }

    private void printResult(LadderGame ladderGame) {
        String request;
        do {
            request = inputRequestUntilNoException(ladderGame);
            printResultByRequest(request, ladderGame);

        } while (!request.equals(Command.REQUEST_TO_GET_ALL_RESULT));
    }

    private String inputRequestUntilNoException(LadderGame ladderGame) {
        return IllegalArgumentExceptionHandler.repeatUntilNoException(
                inputView::inputRequestForResult, ladderGame::findValidRequest, outputView);
    }

    private void printResultByRequest(String request, LadderGame ladderGame) {
        Map<String, String> result = ladderGame.findRewardsOfPlayersByRequest(request);

        if (request.equals(Command.REQUEST_TO_GET_ALL_RESULT)) {
            outputView.printResultOfAll(ladderGame.findPlayerNames(), result);
            return;
        }
        outputView.printResultOfPlayer(result.get(request));

    }

}
