package ladder.controller;

import ladder.constant.Command;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Players;
import ladder.domain.RandomGenerator;
import ladder.domain.Rewards;
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


//    private Map<String, String> findResultUntilNoException(LadderGame ladderGame) {
//        Map<String, String> result = null;
//
//        while (result == null) {
//            result = findResult(ladderGame);
//        }
//        return result;
//    }
//
//    private Map<String, String> findResult(LadderGame ladderGame) {
//        try {
//            String request = inputView.inputRequestForResult();
//            return ladderGame.findRewardsOfPlayersByRequest(request);
//
//        } catch (IllegalArgumentException e) {
//            outputView.printError(e.getMessage());
//            return null;
//        }
//    }


//    private Players createPlayersUntilNoException() {
//        Players players = null;
//
//        while (players == null) {
//            players = createPlayers();
//        }
//        return players;
//    }
//
//    private Players createPlayers() {
//        try {
//            List<String> inputNames = inputView.inputPlayerNames();
//            return Players.from(inputNames);
//
//        } catch (IllegalArgumentException e) {
//            outputView.printError(e.getMessage());
//            return null;
//        }
//    }


//    private Rewards createRewardsUntilNoException(int NumberOfPlayers) {
//        Rewards rewards = null;
//
//        while (rewards == null) {
//            rewards = createRewards(NumberOfPlayers);
//        }
//        return rewards;
//    }
//
//    private Rewards createRewards(int NumberOfPlayers) {
//        try {
//            List<String> inputRewards = inputView.inputRewards();
//            return new Rewards(NumberOfPlayers, inputRewards);
//
//        } catch (IllegalArgumentException e) {
//            outputView.printError(e.getMessage());
//            return null;
//        }
//    }


//    private Height decideHeightOfLadderUntilNoException() {
//        Height height = null;
//        while (height == null) {
//            height = decideHeightOfLadder();
//        }
//
//        return height;
//    }
//
//    private Height decideHeightOfLadder() {
//        try {
//            int height = inputView.inputHeightOfLadder();
//            return new Height(height);
//
//        } catch (IllegalArgumentException e) {
//            outputView.printError(e.getMessage());
//            return null;
//        }
//    }


}
