package controller;

import common.Logger;
import controller.response.GoDownLadderResponse;
import domain.Ladder;
import domain.LadderFactory;
import domain.value.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LadderController {

    private static final Name ALL_SHOW = new Name("all");

    private final LadderFactory ladderFactory;

    public LadderController(final LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public void run() {
        Names names = inputWithExceptionHandle(this::createNames);
        WinningEntries winningEntries = inputWithExceptionHandle(this::createWinningEntries);
        Height height = inputWithExceptionHandle(this::ladderHeight);
        Ladder ladder = createLadder(Width.of(names.size() - 1), height);
        showLadder(names, ladder, winningEntries);

        doDownLadderRepeat(names, winningEntries, ladder);
    }

    private Names createNames() {
        List<String> inputNames = InputView.inputNames();
        return new Names(inputNames.stream()
                .map(Name::new)
                .collect(Collectors.toList())
        );
    }

    private WinningEntries createWinningEntries() {
        List<String> winningEntries = InputView.inputWinningEntries();
        return new WinningEntries(winningEntries.stream()
                .map(WinningEntry::new)
                .collect(Collectors.toList())
        );
    }

    private Height ladderHeight() {
        return Height.of(InputView.inputHeight());
    }

    private Ladder createLadder(final Width width, final Height height) {
        return ladderFactory.createLadder(width, height);
    }

    private void showLadder(final Names names, final Ladder ladder, final WinningEntries winningEntries) {
        OutputView.printCreatedLadder(ladder, names, winningEntries);
    }

    private void doDownLadderRepeat(final Names names, final WinningEntries winningEntries, final Ladder ladder) {
        List<Position> wantToKnowResultPositions;
        do {
            wantToKnowResultPositions = inputWithExceptionHandle(() -> wantToKnowResultPositions(names));
            GoDownLadderResponse goDownLadderResponse = goDownLadderResponse(names, winningEntries, ladder, wantToKnowResultPositions);
            OutputView.printGoDownLadderResult(goDownLadderResponse);
        } while (wantToKnowResultPositions.size() <= 1);
    }

    private List<Position> wantToKnowResultPositions(final Names names) {
        Name wantToKnowResultName = new Name(InputView.inputWantToKnowResultName());
        if (wantToKnowResultName.equals(ALL_SHOW)) {
            return names.getNames().stream()
                    .map(names::indexOf)
                    .map(Position::of)
                    .collect(Collectors.toList());
        }
        return List.of(Position.of(names.indexOf(wantToKnowResultName)));
    }

    private GoDownLadderResponse goDownLadderResponse(final Names names, final WinningEntries winningEntries, final Ladder ladder, final List<Position> wantToKnowResultPositions) {
        return new GoDownLadderResponse(wantToKnowResultPositions.stream()
                .collect(Collectors.toUnmodifiableMap(
                        position -> names.get(position.value()),
                        position -> winningEntries.get(ladder.goDown(position).value())
                ))
        );
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
