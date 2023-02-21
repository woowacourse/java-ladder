package controller;

import domain.Ladder;
import domain.Names;
import java.util.List;
import java.util.Map;

import domain.Results;
import domain.generator.ConnectionGenerator;
import domain.generator.RandomConnectionGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ConnectionGenerator connectionGenerator;

    public LadderGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.connectionGenerator = new RandomConnectionGenerator();
    }

    public void run() {
        Names names = makeNames();
        Results results = makeResults(names.findNumberOfNames());
        Ladder ladder = makeLadder(names.findNumberOfNames());

        outputView.printResult(names, ladder, results);

        Map<String, String> gameResult = ladder.matchResult(names.getNames(), results.getResults());
        System.out.println(gameResult);
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
            return new Ladder(numberOfNames, ladderHeight, connectionGenerator);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return makeLadder(numberOfNames);
        }
    }
}
