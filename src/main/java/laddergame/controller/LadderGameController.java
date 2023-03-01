package laddergame.controller;

import laddergame.model.ladder.Height;
import laddergame.model.ladder.Ladder;
import laddergame.model.people.People;
import laddergame.model.people.Prizes;
import laddergame.model.people.Results;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        People people = makePeople();
        Prizes prizes = makePrizes(people);
        Height height = makeLadderHeight();
        Ladder ladder = new Ladder(height, people);
        Results results = Results.from(people, ladder, prizes);
        outputView.printLadderResult(people, ladder, prizes);
        ladderGameResult(results);
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

    private void ladderGameResult(Results results) {
        boolean isRetry = true;
        try {
            retryPrintResult(results, isRetry);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            ladderGameResult(results);
        }
    }

    private void retryPrintResult(Results results, boolean isRetry) {
        while(isRetry){
            String resultType = inputView.readResultType();
            isRetry = outputView.printResultByType(results, resultType);
        }
    }
}
