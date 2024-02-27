package controller;

import domain.*;
import domain.lines.Lines;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LadderController {
    public void start() {
        List<String> rawNames = InputView.getNames();
        Names names = new Names(rawNames);

        List<String> rawResults = InputView.getResults();
        Results results = new Results(rawResults, names.size());

        int rawHeight = InputView.getHeight();
        Height height = new Height(rawHeight);

        Lines lines = new Lines(height.getValue(), names.size(), new RandomBooleanGenerator());
        Players players = new Players(names);
        players.playGame(lines);

        ResultView.printLadder(names, lines, results);
        ResultView.printGameResult(results, players);
    }
}
