package controller;

import domain.Ladder;
import domain.LadderFactory;
import domain.Name;
import java.util.List;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final LadderFactory ladderFactory;

    public LadderController(final LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public void run() {
        List<String> inputNames = InputView.inputNames();
        List<Name> names = inputNames.stream().map(Name::new).collect(Collectors.toList());
        int height = InputView.inputHeight();
        Ladder ladder = ladderFactory.createLadder(names.size() - 1, height);
        OutputView.printResult(ladder, names);
    }
}
