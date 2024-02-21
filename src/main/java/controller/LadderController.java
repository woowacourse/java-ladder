package controller;

import domain.Height;
import domain.Lines;
import domain.Names;
import java.util.List;
import view.InputView;
import view.ResultView;

public class LadderController {
    public void start() {
        List<String> rawNames = InputView.getNames();
        int rawHeight = InputView.getHeight();

        Names names = new Names(rawNames);
        Height height = new Height(rawHeight);
        Lines lines = new Lines(height.getValue(), names.size());

        ResultView.printResult(names, lines);
    }
}
