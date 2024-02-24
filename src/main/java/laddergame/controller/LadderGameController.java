package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.people.People;
import laddergame.view.ExceptionHandledReader;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class LadderGameController {
    private LadderGameController() {
    }

    public static void run() {
        People people = ExceptionHandledReader.readUntilNoError(LadderGameController::getPeople);
        Ladder ladder = ExceptionHandledReader.readUntilNoError(() -> getLadder(people));

        ResultView.printLadder(people, ladder);
    }

    private static People getPeople() {
        return new People(InputView.readNames());
    }

    private static Ladder getLadder(People people) {
        int peopleNumber = people.getNames().size();
        return new Ladder(InputView.readHeight(), peopleNumber);
    }

}
