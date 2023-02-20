package controller;

import domain.*;
import util.StoolGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
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
        People people = initPeople();
        Prizes prizes = initPrizes(people.size());
        Ladder ladder = initLadder(people.size());

        showLadder(people, ladder, prizes);
        showResult(people, ladder, prizes);
    }

    private People initPeople() {
        try {
            return People.from(inputView.readNames());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());

            return initPeople();
        }
    }

    private Ladder initLadder(int participantsSize) {
        try {
            return Ladder.from(inputView.readHeight(), participantsSize, stoolGenerator);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());

            return initLadder(participantsSize);
        }
    }

    private Prizes initPrizes(int participantsSize) {
        try {
            return new Prizes(inputView.readResults(), participantsSize);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());

            return initPrizes(participantsSize);
        }
    }

    private void showLadder(People people, Ladder ladder, Prizes prizes) {
        outputView.printLadder(people.getNames(), getStoolExistencesOnEachLevel(ladder), prizes.getPrizes());
    }

    private List<List<Boolean>> getStoolExistencesOnEachLevel(Ladder ladder) {
        return ladder.getLevels().stream()
                .map(this::getStoolExistences)
                .collect(Collectors.toList());
    }

    private List<Boolean> getStoolExistences(Level level) {
        return level.getStools().stream()
                .map(Stool::isExist)
                .collect(Collectors.toList());
    }

    private void showResult(People people, Ladder ladder, Prizes prizes) {
        String target = inputView.readTargetName();

        if (!target.equals(ALL_PEOPLE)) {
            printPerson(people, ladder, prizes, target);
            showResult(people, ladder, prizes);
        }

        printAllPeople(people, ladder, prizes);
    }

    private void printAllPeople(People people, Ladder ladder, Prizes prizes) {
        List<String> prizesOfAll = IntStream.range(0, people.size())
                .map(position -> ladder.getResult(position, 0))
                .mapToObj(prizes::getPrizeByPosition)
                .collect(Collectors.toList());

        outputView.printAllResults(people.getNames(), prizesOfAll);
    }

    private void printPerson(People people, Ladder ladder, Prizes prizes, String name) {
        try {
            int startPosition = people.getPosition(name);
            int endPosition = ladder.getResult(startPosition, 0);

            outputView.printResult(prizes.getPrizeByPosition(endPosition));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }
}
