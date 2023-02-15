package controller;

import domain.Lines;
import domain.Name;
import java.util.List;
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
        List<Name> names = inputView.readNames();
        int ladderSize = inputView.readLadderSize();
        Lines lines = new Lines(names.size(), ladderSize);
        outputView.printResult(names, lines);
    }
}
