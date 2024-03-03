package controller;

import dto.LadderInfo;
import java.util.List;
import model.Ladder;
import model.People;
import model.PersonName;
import model.Present;
import model.PresentMatches;
import model.Presents;
import model.path.RandomPathGenerator;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private static final String SHOW_ALL_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        final People people = initPeople();
        final Presents presents = initPresent(people);
        final Ladder ladder = initLadder(people);

        PresentMatches presentMatches = people.climbDown(ladder, presents);
        final LadderInfo ladderInfo = LadderInfo.from(people, ladder, presents);
        outputView.printLadderInfo(ladderInfo);
        while (true) {
            showMatches(presentMatches, people);
        }
    }

    private People initPeople() {
        try {
            final List<String> names = inputView.inputNames();
            return People.from(names);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return initPeople();
        }
    }

    private Presents initPresent(People people) {
        try {
            final List<String> presentNames = inputView.inputPresentNames();
            return Presents.from(presentNames, people);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return initPresent(people);
        }
    }

    private Ladder initLadder(final People people) {
        try {
            final int height = inputView.inputHeight();
            return Ladder.from(height, people, new RandomPathGenerator());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return initLadder(people);
        }
    }

    private void showMatches(PresentMatches presentMatches, People people) {
        try {
            searchMatches(presentMatches, people);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private void searchMatches(PresentMatches presentMatches, People people) {
        final String finding = inputView.inputFinding();
        if (finding.equals(SHOW_ALL_COMMAND)) {
            printAllMatches(presentMatches, people);
            return;
        }
        final PersonName personName = new PersonName(finding);
        if (!people.contains(personName)) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다.");
        }
        final Present present = presentMatches.findByPersonName(personName);
        outputView.printMatched(present.name());
    }

    private void printAllMatches(PresentMatches presentMatches, People people) {
        final List<PersonName> names = people.getPersonNames();
        names.forEach(personName -> {
            final Present present = presentMatches.findByPersonName(personName);
            outputView.printMatched(personName.name(), present.name());
        });

    }
}
