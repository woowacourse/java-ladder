package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.People;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public LadderGame() {
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
        List<String> rawNames = inputView.readNames();
        List<Name> names = rawNames.stream()
                .map(Name::new)
                .toList();
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

    private <T> T retryWhileException(Supplier<T> callback) {
        try {
            return callback.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return retryWhileException(callback);
        }
    }
}
