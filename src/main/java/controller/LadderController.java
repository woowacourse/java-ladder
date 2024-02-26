package controller;

import domain.Height;
import domain.Lines;
import domain.Names;
import domain.PointGenerator;
import domain.RandomPointGenerator;
import java.util.List;
import view.InputView;
import view.ResultView;

public class LadderController {
    public void start() {
        List<String> rawNames = InputView.getNames();
        Names names = new Names(rawNames);

        int rawHeight = InputView.getHeight();
        Height height = new Height(rawHeight);

        PointGenerator generator = new RandomPointGenerator();
        Lines lines = new Lines(height.getValue(), names.size(), generator);

        ResultView.printResult(names, lines);
    }
}
