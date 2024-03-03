package laddergame.controller;

import laddergame.domain.LadderGame;
import laddergame.domain.gameelements.Players;
import laddergame.domain.gameelements.Prizes;
import laddergame.domain.ladder.Ladder;
import laddergame.view.InputView;
import laddergame.view.ResultView;

import static laddergame.view.ExceptionHandledReader.retryUntilNoError;

public class LadderGameController {

    private LadderGameController() {
    }

    public static void run() {
        Players players = retryUntilNoError(() -> new Players(InputView.readNames()));
        Ladder ladder = retryUntilNoError(() -> makeLadder(players));

        int playerNumber = players.getNames().size();
        Prizes prizes = retryUntilNoError(() -> new Prizes(InputView.readPrizes(), playerNumber));

        LadderGame ladderGame = new LadderGame(players, ladder, prizes);

        ResultView.printLadder(players, ladder, prizes);
        retryUntilNoError(() -> printPlayerResults(ladderGame));
    }

    private static Ladder makeLadder(Players players) {
        int peopleNumber = players.getNames().size();
        return new Ladder(InputView.readHeight(), peopleNumber);
    }

    private static boolean printPlayerResults(LadderGame ladderGame) {
        ResultView.printPlayerResult(InputView.readPlayerName(), ladderGame);
        return true;
    }
}
