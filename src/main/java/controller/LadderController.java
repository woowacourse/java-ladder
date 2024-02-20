package controller;

import domain.Height;
import domain.Lines;
import domain.Names;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LadderController {
    public void start() {
        List<String> rawNames = InputView.getNames();
        int rawHeight = InputView.getHeight();
        Names names = new Names(rawNames);
        Height height = new Height(rawHeight);

        Lines lines = new Lines(height.getValue(), names.getNames().size());
        ResultView.printResult(names,lines);
    }
}
