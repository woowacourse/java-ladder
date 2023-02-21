package controller;

import common.Logger;
import domain.game.LadderGame;
import domain.game.LadderGameFactory;
import domain.game.LadderGameResult;
import domain.ladder.Ladder;
import domain.value.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LadderController {

    private final LadderGameFactory ladderGameFactory;

    public LadderController(final LadderGameFactory ladderGameFactory) {
        this.ladderGameFactory = ladderGameFactory;
    }

    public void run() {
        Names names = withExceptionHandle(this::createNames);
        WinningEntries winningEntries = withExceptionHandle(() -> createWinningEntries(names));
        Height height = withExceptionHandle(this::ladderHeight);
        LadderGame game = ladderGameFactory.createGame(names, winningEntries, height);
        showLadder(names, game.ladder(), winningEntries);
        playGame(game);
    }

    private Names createNames() {
        List<String> inputNames = InputView.inputNames();
        return new Names(inputNames.stream()
                .map(Name::new)
                .collect(Collectors.toList())
        );
    }

    private WinningEntries createWinningEntries(final Names names) {
        List<WinningEntry> winningEntries = InputView.inputWinningEntries()
                .stream().map(WinningEntry::new)
                .collect(Collectors.toList());
        return new WinningEntries(winningEntries, names);
    }

    private Height ladderHeight() {
        return Height.of(InputView.inputHeight());
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
