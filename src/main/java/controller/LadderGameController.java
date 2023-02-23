package controller;

import java.util.List;
import java.util.Map;

import domain.GameResult;
import domain.Ladder;
import domain.Names;
import domain.Results;
import domain.generator.RandomConnectionGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private static final int MAX_COUNT_TO_GET_RESULT = 2;
    private static final String ALL_RESULT_MESSAGE = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Names names = makeNames();
        Results results = makeResults(names.findNumberOfNames());
        Ladder ladder = makeLadder(names.findNumberOfNames());
        Map<String, String> result = ladder.matchResult(names.getNames(), results.getResults());
        GameResult gameResult = new GameResult(result);

        outputView.printLadder(names, ladder, results);
        showResultByName(gameResult);
    }

    private Names makeNames() {
        try {
            List<String> playerNames = inputView.readNames();
            return new Names(playerNames);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return makeNames();
        }
    }

    private Results makeResults(final int numberOfNames) {
        try {
            String results = inputView.readResults();
            return new Results(results, numberOfNames);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return makeResults(numberOfNames);
        }
    }

    private Ladder makeLadder(final int numberOfNames) {
        try {
            int ladderHeight = inputView.readHeight();
            return new Ladder(numberOfNames, ladderHeight, new RandomConnectionGenerator());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return makeLadder(numberOfNames);
        }
    }

    private void showResultByName(final GameResult gameResult) {
        for (int i = 0; i < MAX_COUNT_TO_GET_RESULT; i++) {
            showResult(gameResult);
        }
    }

    private void showResult(final GameResult gameResult) {
        try {
            String name = inputView.readNameToShowResult();
            checkAll(gameResult, name);
            checkName(gameResult, name);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            showResult(gameResult);
        }
    }

    private void checkAll(final GameResult gameResult, final String name) {
        if (name.equals(ALL_RESULT_MESSAGE)) {
            outputView.printAllGameResult(gameResult.getGameResult());
        }
    }

    private void checkName(final GameResult gameResult, final String name) {
        if (!name.equals(ALL_RESULT_MESSAGE)) {
            outputView.printSoloGameResult(gameResult.findResult(name));
        }
    }
}
