package controller;

import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Map;

public class LadderController {
    public void start() {
        Names names = creatNames();
        Results results = createResults(names);
        Height height = creatHeight();

        LineGenerator lineGenerator = new LineGenerator(names.size(), new RandomBooleanGenerator());
        Lines lines = new Lines(height.getValue(), lineGenerator);

        Map<Name, Integer> gameResult = lines.playGame(names);

        printResult(names, lines, results, gameResult);
    }

    private static void printResult(Names names, Lines lines, Results results, Map<Name, Integer> gameResult) {
        ResultView.printLadder(names, lines, results);
        ResultView.printGameResult(results, gameResult);
    }

    private static Height creatHeight() {
        int rawHeight = InputView.getHeight();
        return new Height(rawHeight);
    }

    private static Results createResults(Names names) {
        List<String> rawResults = InputView.getResults();
        return new Results(rawResults, names.size());
    }

    private static Names creatNames() {
        List<String> rawNames = InputView.getNames();
        return new Names(rawNames);
    }
}
