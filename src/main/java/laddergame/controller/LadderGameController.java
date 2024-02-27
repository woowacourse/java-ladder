package laddergame.controller;

import laddergame.domain.LadderGame;
import laddergame.domain.gameelements.Elements;
import laddergame.domain.ladder.Ladder;
import laddergame.view.InputView;
import laddergame.view.ResultView;

import static laddergame.view.ExceptionHandledReader.retryUntilNoError;

public class LadderGameController {

    private LadderGameController() {
    }

    public static void run() {
        Elements people = retryUntilNoError(() -> new Elements(InputView.readNames()));
        Ladder ladder = retryUntilNoError(() -> makeLadder(people));
        Elements results = retryUntilNoError(() -> makeResults(people, ladder));

        LadderGame ladderGame = new LadderGame(people, ladder, results);

        ResultView.printLadder(people, ladder, results);
        retryUntilNoError(() -> printPlayerResults(ladderGame));
    }

    private static Elements makeResults(Elements people, Ladder ladder) {
        Elements results = retryUntilNoError(() -> new Elements(InputView.readGameResult()));
        new LadderGame(people, ladder, results);
        return results;
    }

    private static Ladder makeLadder(Elements people) {
        int peopleNumber = people.getElements().size();
        return new Ladder(InputView.readHeight(), peopleNumber);
    }

    private static boolean printPlayerResults(LadderGame ladderGame) {
        ResultView.printPlayerResult(InputView.readPlayerName(), ladderGame);
        return true;
    }
}
