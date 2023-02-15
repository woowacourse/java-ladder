package controller;

import domain.Height;
import domain.Lines;
import domain.Names;
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
        Lines lines = new Lines(names.getPersonNumber(), height.getHeight());
        outputView.printResult(names, lines);
    }
}
