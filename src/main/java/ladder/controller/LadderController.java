package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.creator.RandomLadderCreator;
import ladder.domain.creator.RandomLineCreator;
import ladder.domain.item.LadderItems;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.util.ExceptionRetryHandler;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        LadderItems ladderItems = requestLadderItemsUntilValid();
        LadderHeight ladderHeight = requestLadderHeightUntilValid();

        LadderGame ladderGame = new LadderGame(new RandomLadderCreator(new RandomLineCreator()));
        Ladder ladder = ladderGame.createLadder(ladderItems, ladderHeight);

        outputView.printResult(ladderItems, ladder);
    }

    private LadderItems requestLadderItemsUntilValid() {
        return ExceptionRetryHandler.handle(this::requestLadderItems);
    }

    private LadderItems requestLadderItems() {
        List<String> peopleNames = inputView.readPeopleNames();
        List<String> winningItems = inputView.readWinningItems();

        return LadderItems.of(peopleNames, winningItems);
    }

    private LadderHeight requestLadderHeightUntilValid() {
        return ExceptionRetryHandler.handle(this::requestLadderHeight);
    }

    private LadderHeight requestLadderHeight() {
        return new LadderHeight(inputView.readLadderHeight());
    }
}
