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
        Elements people = retryUntilNoError(LadderGameController::makePeople);
        Ladder ladder = retryUntilNoError(() -> makeLadder(people));
        Elements results = retryUntilNoError(() -> makeResults());

        LadderGame ladderGame = new LadderGame(people, ladder, results);

        ResultView.printLadder(people, ladder, results);
        retryUntilNoError(() -> printPlayerResults(ladderGame));
    }

    private static Elements makePeople() {
        return new Elements(InputView.readNames());
    }

    private static Ladder makeLadder(Elements people) {
        int peopleNumber = people.getElements().size();
        return new Ladder(InputView.readHeight(), peopleNumber);
    }

    private static Elements makeResults() {
        return new Elements(InputView.readGameResult());
    }

    private static int printPlayerResults(LadderGame ladderGame) {
        ResultView.printPlayerResult(InputView.readPlayerName(), ladderGame);
        return 0;
    }
}
