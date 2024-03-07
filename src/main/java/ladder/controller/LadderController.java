package ladder.controller;

import ladder.domain.Command;
import ladder.domain.LadderGame;
import ladder.domain.LadderResult;
import ladder.domain.creator.RandomLadderCreator;
import ladder.domain.creator.RandomLineCreator;
import ladder.domain.item.LadderItems;
import ladder.domain.item.People;
import ladder.domain.item.WinningItem;
import ladder.domain.item.WinningItems;
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
        outputView.printLadder(ladderItems, ladder);

        LadderResult ladderResult = ladderGame.findResult(ladder, ladderItems);
        responseResultUntilValid(ladderResult);
    }

    private LadderItems requestLadderItemsUntilValid() {
        return ExceptionRetryHandler.handle(this::requestLadderItems);
    }

    private LadderItems requestLadderItems() {
        People people = requestPeopleUntilValid();
        WinningItems winningItems = requestWinningItemsUntilValid();

        return new LadderItems(people, winningItems);
    }

    private People requestPeopleUntilValid() {
        return ExceptionRetryHandler.handle(this::requestPeople);
    }

    private People requestPeople() {
        List<String> peopleNames = inputView.readPeopleNames();
        validateIsPeopleNamesCommand(peopleNames);

        return new People(peopleNames);
    }

    private WinningItems requestWinningItemsUntilValid() {
        return ExceptionRetryHandler.handle(this::requestWinningItems);
    }

    private WinningItems requestWinningItems() {
        return new WinningItems(inputView.readWinningItems());
    }

    private void validateIsPeopleNamesCommand(List<String> peopleNames) {
        if (peopleNames.stream().anyMatch(Command.ALL_RESULT::isText)) {
            throw new IllegalArgumentException("사람의 이름은 \"all\"일 수 없습니다.");
        }
    }

    private LadderHeight requestLadderHeightUntilValid() {
        return ExceptionRetryHandler.handle(this::requestLadderHeight);
    }

    private LadderHeight requestLadderHeight() {
        return new LadderHeight(inputView.readLadderHeight());
    }

    private void responseResultUntilValid(LadderResult ladderResult) {
        ExceptionRetryHandler.handle(() -> responseResult(ladderResult));
    }

    private void responseResult(LadderResult ladderResult) {
        String personName = inputView.readPersonNameForResult();

        while (!Command.ALL_RESULT.isText(personName)) {
            WinningItem winningItem = ladderResult.findWinningItemByPersonName(personName);
            outputView.printResultOfPerson(winningItem);
            personName = inputView.readPersonNameForResult();
        }

        outputView.printTotalResult(ladderResult);
    }
}
