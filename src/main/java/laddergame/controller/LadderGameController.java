package laddergame.controller;

import java.util.ArrayList;
import java.util.List;
import laddergame.model.ladder.Height;
import laddergame.model.ladder.Ladder;
import laddergame.model.ladder.Line;
import laddergame.model.ladder.Point;
import laddergame.model.people.People;
import laddergame.model.people.Person;
import laddergame.model.people.Prize;
import laddergame.model.people.Prizes;
import laddergame.model.people.Result;
import laddergame.model.people.Results;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private static Results makeResults(People people, Ladder ladder, Prizes prizes) {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            Person person = people.getPeople().get(i);
            int index = i;
            for (int j = 0; j < ladder.size(); j++) {
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
        ladderGameResult(results);
    }

    private void ladderGameResult(Results results) {
        try {
            String resultType = inputView.readLadderGameResult();
            if (isResultType(results, resultType)) {
                return;
            }
            ladderGameResult(results);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            ladderGameResult(results);
        }
    }

    private boolean isResultType(Results results, String resultType) {
        if (resultType.equals("Q")) {
            System.out.println("게임이 끝났습니다.");
            return true;
        }
        if (resultType.equals("all")) {
            outputView.printAllResult(results);
            return false;
        }
        Result result = results.findResultOfPerson(resultType);
        outputView.printPersonalResult(result);
        return false;
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
