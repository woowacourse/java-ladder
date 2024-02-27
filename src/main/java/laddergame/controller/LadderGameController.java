package laddergame.controller;

import laddergame.domain.LadderGame;
import laddergame.domain.gameelements.people.People;
import laddergame.domain.gameelements.results.Results;
import laddergame.domain.ladder.Ladder;
import laddergame.view.InputView;
import laddergame.view.ResultView;

import static laddergame.view.ExceptionHandledReader.retryUntilNoError;

public class LadderGameController {
    private LadderGameController() {
    }

    public static void run() {
        People people = retryUntilNoError(LadderGameController::makePeople);
        Ladder ladder = retryUntilNoError(() -> makeLadder(people));
        Results results = retryUntilNoError(() -> makeResults(people.getNames().size()));

        LadderGame ladderGame = new LadderGame(people, ladder, results);

        ResultView.printLadder(people, ladder, results);
        retryUntilNoError(() -> printPlayerResults(ladderGame));
    }

    private static People makePeople() {
        return new People(InputView.readNames());
    }

    private static Ladder makeLadder(People people) {
        int peopleNumber = people.getNames().size();
        return new Ladder(InputView.readHeight(), peopleNumber);
    }

    private static Results makeResults(int peopleNumber) {
        return new Results(InputView.readGameResult(), peopleNumber);
    }

    private static int printPlayerResults(LadderGame ladderGame) {
        ResultView.printPlayerResult(InputView.readPlayerName(), ladderGame);
        return 0;
    }
}
