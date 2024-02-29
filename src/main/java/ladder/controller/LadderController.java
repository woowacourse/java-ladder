package ladder.controller;

import ladder.constant.Command;
import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;
import ladder.view.ResultView;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class LadderController {
    private static final String NOT_EXIST_PERSON = "게임에 존재하지 않은 사람입니다.";

    private LadderController() {
    }

    public static void start() {
        People people = requestUntilValid(() -> People.from(InputView.readPeopleNames()));
        Prizes prizes = requestUntilValid(() -> Prizes.from(InputView.readPrizeNames(), people.getCount()));
        LadderHeight ladderHeight = requestUntilValid(() -> LadderHeight.from(InputView.readLadderHeight()));

        Ladder ladder = new LadderGenerator(ladderWidth(people), ladderHeight.getValue()).generate();
        printLadderResult(people, ladder, prizes);
        printExecutionResult(people, ladder, prizes);
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
            OutputView.printErrorMessage(e.getMessage());
            return Optional.empty();
        }
    }

    private static int ladderWidth(People people) {
        return people.getCount() - 1;
    }

    private static void printLadderResult(People people, Ladder ladder, Prizes prizes) {
        ResultView.printResult(
                people.getNames(),
                ladder.getLines().stream()
                        .map(Line::scaffolds)
                        .toList(),
                prizes.getNames()
        );
    }

    private static void printExecutionResult(People people, Ladder ladder, Prizes prizes) {
        Game game = new Game(people, ladder, prizes);
        Map<String, String> result = game.run();

        CommandController commandController = new CommandController((viewer) ->
                printResultIfPersonExist(people, viewer, result));
        commandController.put(Command.ALL, () ->
                ResultView.printExecutionResultAll(result));
        while (commandController.run(InputView.readViewerName())) ;
    }

    private static void printResultIfPersonExist(People people, String viewer, Map<String, String> result) {
        if (!people.getNames().contains(viewer)) {
            OutputView.printErrorMessage(NOT_EXIST_PERSON);
            return;
        }
        ResultView.printExecutionResultOnce(result.get(viewer));
    }
}
