package controller;

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
        System.out.println(names);
        int ladderSize = inputView.readLadderSize();
        System.out.println(ladderSize);
    }
}
