package controller;

import domain.Ladder;
import domain.People;
import domain.Prizes;
import util.StoolGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderController {
    private static final String ALL_PEOPLE = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final StoolGenerator stoolGenerator;

    public LadderController(InputView inputView, OutputView outputView, StoolGenerator stoolGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stoolGenerator = stoolGenerator;
    }

    public void run() {
        People people = repeat(() -> People.from(inputView.readNames()));
        Ladder ladder = repeat(() -> Ladder.from(inputView.readHeight(), people.size(), stoolGenerator));
        Prizes prizes = repeat(() -> new Prizes(inputView.readResults(), people.size()));

        showLadder(people, ladder, prizes);
        showResult(people, ladder, prizes);
    }

    private <T> T repeat(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());

            return repeat(supplier);
        }
    }

    private void showLadder(People people, Ladder ladder, Prizes prizes) {
        outputView.printLadder(people.getNames(), ladder, prizes.getPrizes());
    }

    private void showResult(People people, Ladder ladder, Prizes prizes) {
        String target = inputView.readTargetName();

        if (!target.equals(ALL_PEOPLE)) {
            printPerson(people, ladder, prizes, target);
            showResult(people, ladder, prizes);
        }

        if (target.equals(ALL_PEOPLE)) {
            printAllPeople(people, ladder, prizes);
        }
    }

    private void printAllPeople(People people, Ladder ladder, Prizes prizes) {
        List<String> prizesOfAll = IntStream.range(0, people.size())
                .map(ladder::getResult)
                .mapToObj(prizes::getPrizeByPosition)
                .collect(Collectors.toList());

        outputView.printAllResults(people.getNames(), prizesOfAll);
    }

    private void printPerson(People people, Ladder ladder, Prizes prizes, String name) {
        try {
            int startPosition = people.getPosition(name);
            int endPosition = ladder.getResult(startPosition);

            outputView.printResult(prizes.getPrizeByPosition(endPosition));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }
}
