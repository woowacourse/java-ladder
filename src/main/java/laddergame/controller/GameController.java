package laddergame.controller;

import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class GameController {

    private final Players players;
    private final Ladder ladder;
    private final WinningPrizes winningPrizes;

    public GameController() {
        this.players = readPlayers();
        final int playerCount = players.getSize();
        this.ladder = Ladder.of(readHeight(), playerCount, new RandomLinkGenerator());
        this.winningPrizes = readWinningPrizes(playerCount);
    }

    public void process() {
        setUpGame();
        playGame();
    }

    private void setUpGame() {
        OutputView.printPlayerAll(players);
        OutputView.printLadder(players, ladder);
        OutputView.printWinningPrizeAll(winningPrizes);
    }

    private Players readPlayers() {
        try {
            return Players.from(InputView.readNames());
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readPlayers();
        }
    }

    private Height readHeight() {
        try {
            return new Height(InputView.readHeight());
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readHeight();
        }
    }

    private WinningPrizes readWinningPrizes(final int playerCount) {
        try {
            return WinningPrizes.of(InputView.readWiningPrize(), playerCount);
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readWinningPrizes(playerCount);
        }
    }

    private void playGame() {
        final LadderGame ladderGame = new LadderGame();
        final List<Player> gameResult = ladderGame.playGame(players.getPlayers(), ladder.getLadder());
        final GameResult result = new GameResult(gameResult, winningPrizes);
        matchPlayerPrize(result);
    }

    private void matchPlayerPrize(final GameResult gameResult) {
        String command = null;
        do {
            command = InputView.readCommand();
            printResult(gameResult, command);
        } while (!command.equals("end"));
    }

    private static void printResult(final GameResult gameResult, final String command) {
        if (command.equals("all")) {
            OutputView.printAllResult(gameResult);
            return;
        }
        if (gameResult.isContain(command)) {
            final String playerPrize = gameResult.findPlayerPrize(command);
            OutputView.printResult(playerPrize);
            return;
        }
        if (!command.equals("end")) {
            OutputView.printMessage("all 혹은 참여한 사람의 이름만 입력해주세요.");
        }
    }
}
