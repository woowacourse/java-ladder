package ladder.controller;

import ladder.domain.*;
import ladder.domain.creator.RandomLadderCreator;
import ladder.domain.creator.RandomLineCreator;
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
        People people = requestPeopleUntilValid();
        List<WinningItem> winningItems = requestWinningItemsUntilValid();

        LadderHeight ladderHeight = requestLadderHeightUntilValid();

        LadderGame ladderGame = new LadderGame(new RandomLadderCreator(new RandomLineCreator()));
        Ladder ladder = ladderGame.processGame(people, ladderHeight);

        outputView.printResult(people, ladder);
    }

    private People requestPeopleUntilValid() {
        return ExceptionRetryHandler.handle(this::requestPeople);
    }

    private People requestPeople() {
        List<String> peopleNames = inputView.readPeopleNames();
        return new People(peopleNames.stream()
                .map(Person::new)
                .toList());
    }

    private List<WinningItem> requestWinningItemsUntilValid() {
        return ExceptionRetryHandler.handle(this::requestWinningItems);
    }

    private List<WinningItem> requestWinningItems() {
        List<String> winningItems = inputView.readWinningItems();
        return winningItems.stream()
                .map(WinningItem::new)
                .toList();
    }

    private LadderHeight requestLadderHeightUntilValid() {
        return ExceptionRetryHandler.handle(this::requestLadderHeight);
    }

    private LadderHeight requestLadderHeight() {
        return new LadderHeight(inputView.readLadderHeight());
    }
}
