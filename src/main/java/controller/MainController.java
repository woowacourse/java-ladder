package controller;

import domain.Height;
import domain.Lines;
import domain.Names;
import domain.booleangenerator.BooleanGenerator;
import view.InputView;
import view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;


    public MainController(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void start() {
        try {
            Names names = inputView.readNames();
            Height height = inputView.readHeight();
            int lineNumber = names.getPersonNumber() - 1;
            Lines lines = new Lines(lineNumber, height.getHeight(), booleanGenerator);
            outputView.printResult(names, lines);
        } catch (Exception exception) {
            outputView.printExceptionMessage(exception);
        }
    }
}
