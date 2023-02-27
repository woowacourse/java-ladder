package ladder.controller;

import ladder.domain.game.LadderGame;
import ladder.domain.rule.RandomStoolGenerator;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private static final String EXIST_SIGNAL = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final FrontExceptionController frontExceptionController;

    public LadderGameController(
            InputView inputView,
            OutputView outputView,
            FrontExceptionController frontExceptionController
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.frontExceptionController = frontExceptionController;
    }

    public void run() {
        try {
            LadderGame ladderGame = initLadderGame();

            ladderGame.letPlayersToGoDown();
            showLadder(ladderGame);
            startGameResultLoop(ladderGame);
        } catch (RuntimeException e) {
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
            List<String> playerNames = inputView.inputPlayer();
            return new Players(playerNames);
        } catch (RuntimeException e) {
            frontExceptionController.handle(e);
            return initPlayers();
        }
    }

    private Ladder initLadder(int playerNumber) {
        try {
            final int height = inputView.inputLadderHeight();
            return new Ladder(playerNumber, height, new RandomStoolGenerator());
        } catch (RuntimeException e) {
            frontExceptionController.handle(e);
            return initLadder(playerNumber);
        }
    }

    private LadderGame initLadderGame(Players players, Ladder ladder) {
        try {
            List<String> destinations = inputView.inputLadderDestination();
            return new LadderGame(players, ladder, destinations);
        } catch (RuntimeException e) {
            frontExceptionController.handle(e);
            return initLadderGame(players, ladder);
        }
    }

    private void showLadder(LadderGame ladderGame) {
        outputView.printGameResultHeader();
        outputView.printWithFormat(mapPlayersToPlayersName(ladderGame.getPlayers()));
        outputView.printLadder(ladderGame.getLadder());
        outputView.printWithFormat(ladderGame.getDestinations());
    }

    private List<String> mapPlayersToPlayersName(Players players) {
        return players.getPlayers().stream()
                .map(player -> player.getPlayerName().getName())
                .collect(Collectors.toUnmodifiableList());
    }

    private void startGameResultLoop(LadderGame ladderGame) {
        String playerName = inputView.inputPlayerWhoNeedsGameResult();

        while (!playerName.equals(EXIST_SIGNAL)) {
            outputView.printOneGameResult(ladderGame.getOneLadderGameResult(playerName));
            playerName = inputView.inputPlayerWhoNeedsGameResult();
        }
        outputView.printAllGameResult(ladderGame.getAllLadderGameResult());
    }
}
