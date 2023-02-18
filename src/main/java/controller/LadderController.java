package controller;

import common.Logger;
import domain.game.LadderGame;
import domain.game.LadderGameResult;
import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import domain.value.*;
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
        Names names = withExceptionHandle(this::createNames);
        WinningEntries winningEntries = withExceptionHandle(() -> createWinningEntries(names.size()));
        Height height = withExceptionHandle(this::ladderHeight);
        Ladder ladder = createLadder(Width.of(names.size() - 1), height);
        showLadder(names, ladder, winningEntries);

        LadderGame ladderGame = new LadderGame(ladder, names, winningEntries);
        playGame(ladderGame);
    }

    private Names createNames() {
        List<String> inputNames = InputView.inputNames();
        return new Names(inputNames.stream()
                .map(Name::new)
                .collect(Collectors.toList())
        );
    }

    private WinningEntries createWinningEntries(final int size) {
        List<String> winningEntries = InputView.inputWinningEntries();
        if (size != winningEntries.size()) {
            throw new IllegalArgumentException("당첨 항목의 수는 이름의 수와 동일해야 합니다");
        }
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

    private void playGame(final LadderGame ladderGame) {
        while (!ladderGame.isEnd()) {
            LadderGameResult ladderGameResult = withExceptionHandle(() -> goDownLadder(ladderGame));
            OutputView.printGoDownLadderResultForName(ladderGameResult);
        }
    }

    private LadderGameResult goDownLadder(final LadderGame ladderGame) {
        String input = InputView.inputWantToKnowResultName();
        Name name = new Name(input);
        return ladderGame.goDownLadder(name);
    }

    private <T> T withExceptionHandle(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            Logger.error(e.getMessage());
            return withExceptionHandle(supplier);
        }
    }
}
