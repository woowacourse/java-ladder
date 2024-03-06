package laddergame.controller;

import laddergame.domain.LadderGame;
import laddergame.domain.gameelements.Players;
import laddergame.domain.gameelements.Prizes;
import laddergame.domain.ladder.Ladder;
import laddergame.view.InputView;

import static laddergame.view.ExceptionHandledReader.retryUntilNoError;
import static laddergame.view.ResultView.printLadder;
import static laddergame.view.ResultView.printPlayerResult;

public class LadderGameController {

    private LadderGameController() {
    }

    public static void run() {
        Players players = retryUntilNoError(() -> new Players(InputView.readNames()));
        Ladder ladder = retryUntilNoError(() -> makeLadder(players));
        Prizes prizes = retryUntilNoError(() -> new Prizes(InputView.readPrizes(), players.count()));

        LadderGame ladderGame = new LadderGame(players, ladder, prizes);
        ladderGame.playGame();

        printLadder(players, ladder, prizes);
        String playerName = retryUntilNoError(() -> getPlayerName(players));
        printPlayerResult(playerName, ladderGame);
    }

    private static Ladder makeLadder(Players players) {
        return new Ladder(InputView.readHeight(), players.count());
    }

    private static String getPlayerName(Players players) {
        String playerName = InputView.readPlayerName();
        if (playerName.equals("all")) {
            return playerName;
        }
        return players.findPlayerByName(playerName).getName();
    }
}
