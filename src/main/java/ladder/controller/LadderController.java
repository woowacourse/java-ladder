package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Optional;
import java.util.function.Supplier;

public class LadderController {
    private LadderController() {
    }

    public static void start() {
        People people = requestUntilValid(() -> People.from(InputView.readPeopleNames()));
        LadderHeight ladderHeight = requestUntilValid(() -> LadderHeight.from(InputView.readLadderHeight()));

        Ladder ladder = new LadderGenerator(ladderWidth(people), ladderHeight.getValue()).generate();
        printResult(people, ladder);
    }

    private static <T> T requestUntilValid(Supplier<T> supplier) {
        Optional<T> result = Optional.empty();
        while (result.isEmpty()) {
            result = tryGet(supplier);
        }
        return result.get();
    }

    private static <T> Optional<T> tryGet(Supplier<T> supplier) {
        try {
            return Optional.of(supplier.get());
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return Optional.empty();
        }
    }

    private static int ladderWidth(People people) {
        return people.getCount() - 1;
    }

    private static void printResult(People people, Ladder ladder) {
        OutputView.printResult(
                people.getNames(),
                ladder.lines().stream()
                        .map(Line::scaffolds)
                        .toList()
        );
    }
}
