package laddergame.controller;

import laddergame.domain.*;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class GameController {

    public void process() {
        final LadderGame ladderGame = setUpGame();
        final GameResult gameResult = ladderGame.playGame();
        matchPlayerPrize(gameResult);
    }

    private LadderGame setUpGame() {
        final Players players = readPlayers();
        final int playerCount = players.getSize();
        final Ladder ladder = Ladder.of(readHeight(), playerCount, new RandomLinkGenerator());
        final WinningPrizes winningPrizes = readWinningPrizes(playerCount);
        OutputView.printPlayerAll(players);
        OutputView.printLadder(players, ladder);
        OutputView.printWinningPrizeAll(winningPrizes, players);

        return new LadderGame(players, ladder, winningPrizes);
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
