package controller;

import domain.Ladder;
import domain.LadderFactory;
import domain.Name;
import domain.Names;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    private final LadderFactory ladderFactory;

    public LadderController(final LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public void run() {
        Names names = createNames();
        int height = ladderHeight();
        Ladder ladder = createLadder(names, height);
        showLadder(names, ladder);
    }

    private Names createNames() {
        List<String> inputNames = InputView.inputNames();
        return new Names(inputNames.stream()
                .map(Name::new)
                .collect(Collectors.toList())
        );
    }

    private int ladderHeight() {
        return InputView.inputHeight();
    }

    private Ladder createLadder(final Names names, final int height) {
        return ladderFactory.createLadder(names.size() - 1, height);
    }

    private static void showLadder(final Names names, final Ladder ladder) {
        OutputView.printResult(ladder, names);
    }
}
