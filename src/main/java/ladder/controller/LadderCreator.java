package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.view.InputView;
import ladder.view.OutputView;

import static ladder.util.ExceptionHandler.retryWhileException;

public class LadderCreator {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderCreator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        People people = createNames();
        Height height = createHeight();

        Ladder ladder = new Ladder(people, height);

        outputView.printPeople(people);
        outputView.printLadder(ladder, people);
    }

    private People createNames() {
        return retryWhileException(this::readNames);
    }

    private People readNames() {
        String names = inputView.readNames();
        return new People(names);
    }

    private Height createHeight() {
        return retryWhileException(this::readHeight);
    }

    private Height readHeight() {
        try {
            int height = inputView.readHeight();
            return new Height(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 숫자입니다.");
        }
    }
}
