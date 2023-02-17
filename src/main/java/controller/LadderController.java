package controller;

import common.Logger;
import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LadderController {

    private final LadderFactory ladderFactory;

    public LadderController(final LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public void run() {
        Names names = inputWithExceptionHandle(this::createNames);
        Height height = inputWithExceptionHandle(this::ladderHeight);
        Ladder ladder = createLadder(Width.of(names.size() - 1), height);
        showLadder(names, ladder);
    }

    private Names createNames() {
        List<String> inputNames = InputView.inputNames();
        return new Names(inputNames.stream()
                .map(Name::new)
                .collect(Collectors.toList())
        );
    }

    private Height ladderHeight() {
        return Height.of(InputView.inputHeight());
    }

    private Ladder createLadder(final Width width, final Height height) {
        return ladderFactory.createLadder(width, height);
    }

    private void showLadder(final Names names, final Ladder ladder) {
        OutputView.printResult(ladder, names);
    }

    private <T> T inputWithExceptionHandle(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            Logger.error(e.getMessage());
            return inputWithExceptionHandle(supplier);
        }
    }
}
