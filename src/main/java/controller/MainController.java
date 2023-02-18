package controller;

import domain.Height;
import domain.Lines;
import domain.Names;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;


    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Names names = inputView.readNames();
        Height height = inputView.readHeight();
        int lineNumber = names.getPersonNumber() - 1;
        Lines lines = new Lines(lineNumber, height.getHeight());
        outputView.printResult(names, lines);
    }
}
