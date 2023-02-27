package ladder.controller;

import ladder.domain.game.LadderGame;
import ladder.domain.rule.RandomStoolGenerator;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.exception.CustomException;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private final FrontExceptionController frontExceptionController;

    public LadderGameController(FrontExceptionController frontExceptionController) {
        this.frontExceptionController = frontExceptionController;
    }

    public void run() {
        try {
            LadderGame ladderGame = initLadderGame();

            ladderGame.letPlayersToGoDown();
            showLadder(ladderGame);
            startGameResultLoop(ladderGame);
        } catch (CustomException e) {
            frontExceptionController.handle(e);
        }
    }

    private LadderGame initLadderGame() {
        Players players = initPlayers();
        Ladder ladder = initLadder(players.size());
        return initLadderGame(players, ladder);
    }

    private Players initPlayers() {
        try {
            List<String> playerNames = InputView.inputPlayer();
            return new Players(playerNames);
        } catch (CustomException e) {
            frontExceptionController.handle(e);
            return initPlayers();
        }
    }

    private Ladder initLadder(int playerNumber) {
        try {
            final int height = InputView.inputLadderHeight();
            return new Ladder(playerNumber, height, new RandomStoolGenerator());
        } catch (CustomException e) {
            frontExceptionController.handle(e);
            return initLadder(playerNumber);
        }
    }

    private LadderGame initLadderGame(Players players, Ladder ladder) {
        try {
            List<String> destinations = InputView.inputLadderDestination();
            return new LadderGame(players, ladder, destinations);
        } catch (CustomException e) {
            frontExceptionController.handle(e);
            return initLadderGame(players, ladder);
        }
    }

    private void showLadder(LadderGame ladderGame) {
        OutputView.printGameResultHeader();
        OutputView.printWithFormat(mapPlayersToPlayersName(ladderGame.getPlayers()));
        OutputView.printLadder(ladderGame.getLadder());
        OutputView.printWithFormat(ladderGame.getDestinations());
    }

    private List<String> mapPlayersToPlayersName(Players players) {
        return players.getPlayers().stream()
                .map(player -> player.getPlayerName().getName())
                .collect(Collectors.toUnmodifiableList());
    }

    private void startGameResultLoop(LadderGame ladderGame) {
        String playerName = InputView.inputPlayerWhoNeedsGameResult();

        while (!playerName.equals("all")) {
            OutputView.printOneGameResult(ladderGame.getOneLadderGameResult(playerName));
            playerName = InputView.inputPlayerWhoNeedsGameResult();
        }
        OutputView.printAllGameResult(ladderGame.getAllLadderGameResult());
    }
}
