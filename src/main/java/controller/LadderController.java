package controller;

import domain.Height;
import domain.Names;
import domain.RandomBooleanGenerator;
import domain.Results;
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

        ResultView.printResult(names, lines);
    }
}
