package controller;

import domain.Height;
import domain.Lines;
import domain.Names;
import utils.booleanGenerator.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class MainController {
    private static final int PERSON_NUMBER_LINE_SIZE_DIFFERENCE = 1;
    private static final RandomBooleanGenerator RANDOM_BOOLEAN_GENERATOR = new RandomBooleanGenerator();

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Names names = inputView.readNames();
        Height height = inputView.readHeight();
        int lineSize = names.getPersonNumber() - PERSON_NUMBER_LINE_SIZE_DIFFERENCE;
        Lines lines = new Lines(lineSize, height, RANDOM_BOOLEAN_GENERATOR);
        outputView.printResult(names, lines);
    }
}
