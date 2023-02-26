package laddergame.controller;

import java.util.ArrayList;
import java.util.List;
import laddergame.model.Height;
import laddergame.model.Ladder;
import laddergame.model.Line;
import laddergame.model.People;
import laddergame.model.Person;
import laddergame.model.Point;
import laddergame.model.Prize;
import laddergame.model.Prizes;
import laddergame.model.Result;
import laddergame.model.Results;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private static Results makeResults(People people, Ladder ladder, Prizes prizes) {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < people.getSize(); i++) {
            Person person = people.getPeople().get(i);
            int index = i;
            for (int j = 0; j < ladder.getSize(); j++) {
                Line line = ladder.get(j);
                Point point = line.getLine().get(index);
                index = point.moveDirection(index);
            }
            Prize prize = prizes.getPrizes().get(index);
            results.add(new Result(person, prize));
        }
        return new Results(results);
    }

    public void run() {
        People people = makePeople();
        Prizes prizes = makePrizes(people);
        Height height = makeLadderHeight();
        Ladder ladder = new Ladder(height, people);
        outputView.printLadderResult(ladder, people, prizes);
        Results results = makeResults(people, ladder, prizes);
        outputView.printLadderGameResult(results);
    }

    private People makePeople() {
        try {
            return new People(inputView.readPersonNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return makePeople();
        }
    }

    private Prizes makePrizes(People people) {
        try {
            return Prizes.from(inputView.readPrizes(), people);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return makePrizes(people);
        }
    }

    private Height makeLadderHeight() {
        try {
            return new Height(inputView.readLadderHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return makeLadderHeight();
        }
    }
}
