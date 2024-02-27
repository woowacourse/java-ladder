package laddergame.controller;

import laddergame.domain.LadderGame;
import laddergame.domain.gameelements.people.People;
import laddergame.domain.gameelements.results.Results;
import laddergame.domain.ladder.Ladder;
import laddergame.view.ExceptionHandledReader;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class LadderGameController {
    private LadderGameController() {
    }

    //TODO inputView 로직이 숨겨져 입력이 잘구분되지 않음
    public static void run() {
        People people = ExceptionHandledReader.readUntilNoError(LadderGameController::getPeople);
        Ladder ladder = ExceptionHandledReader.readUntilNoError(() -> getLadder(people));
        Results results = ExceptionHandledReader.readUntilNoError(() -> getResults(people.getNames().size()));
        LadderGame ladderGame = new LadderGame(people, ladder, results);

        ResultView.printLadder(people, ladder, results);
        String playerName = InputView.readPlayerName();
        ResultView.printPlayerResult(playerName, ladderGame);
    }

    private static People getPeople() {
        return new People(InputView.readNames());
    }

    private static Ladder getLadder(People people) {
        int peopleNumber = people.getNames().size();
        return new Ladder(InputView.readHeight(), peopleNumber);
    }

    private static Results getResults(int peopleNumber) {
        return new Results(InputView.readGameResult(), peopleNumber);
    }
}
