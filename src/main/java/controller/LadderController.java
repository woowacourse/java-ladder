package controller;

import domain.Ladder;
import domain.Level;
import domain.People;
import domain.Stool;
import util.StoolGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
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
        Ladder ladder = initLadder(people.size());

        showLadder(people, ladder);
        getLadder(ladder);
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

    private void showLadder(People people, Ladder ladder) {
        outputView.printResult(people.getNames(), getLadder(ladder));
    }

    private List<List<Boolean>> getLadder(Ladder ladder) {
        return ladder.getLevels().stream()
                .map(this::getLevel)
                .collect(Collectors.toList());
    }

    private List<Boolean> getLevel(Level level) {
        return level.getStools().stream()
                .map(Stool::isExist)
                .collect(Collectors.toList());
    }
}
