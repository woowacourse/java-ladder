package controller;

import domain.*;
import domain.lines.Lines;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LadderController {
    public void start() {
        Names names = creatNames();
        Results results = createResults(names);
        Height height = creatHeight();

        Lines lines = new Lines(height.getValue(), names.size(), new RandomBooleanGenerator());
        Players players = new Players(names);

        players.playGame(lines);

        printResult(names, lines, results, players);
    }

    private static void printResult(Names names, Lines lines, Results results, Players players) {
        ResultView.printLadder(names, lines, results);
        ResultView.printGameResult(results, players);
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
