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
        Prizes prizes = retryUntilNoError(() -> new Prizes(InputView.readPrizes(), players.count()));

        LadderGame ladderGame = new LadderGame(players, ladder, prizes);
        ladderGame.playGame();

        ResultView.printLadder(players, ladder, prizes);
        retryUntilNoError(() -> printPlayerResults(ladderGame));
    }

    private static Ladder makeLadder(Players players) {
        return new Ladder(InputView.readHeight(), players.count());
    }
    // TODO 반환값이 boolean인지 다시한번 생각해보기
    private static boolean printPlayerResults(LadderGame ladderGame) {
        ResultView.printPlayerResult(InputView.readPlayerName(), ladderGame);
        return true;
    }
}
