package controller;

import domain.Height;
import domain.Names;
import domain.lines.Lines;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LadderController {
    public void start() {
        List<String> rawNames = InputView.getNames();
        Names names = new Names(rawNames);

        int rawHeight = InputView.getHeight();
        Height height = new Height(rawHeight);

        Lines lines = new Lines(height.getValue(), names.size());

        ResultView.printResult(names, lines);
    }
}
