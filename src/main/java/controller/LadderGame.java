package controller;

import dto.Result;
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
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        final People people = initPeople();
        final Presents presents = initPresent(people.getPersonCount());
        final Ladder ladder = initLadder(people.getPersonCount());

        people.climbDown(ladder);
        final Result result = Result.from(people, ladder, presents);
        outputView.printResult(result);
        PresentMatches presentMatches = PresentMatches.from(people, presents);
        while (true) {
            searchMatches(presentMatches, people);
        }
    }

    private People initPeople() {
        final List<String> names = inputView.inputNames();
        return People.from(names);
    }

    private Presents initPresent(int personCount) {
        final List<String> presentNames = inputView.inputPresentNames();
        return Presents.from(presentNames, personCount);
    }

    private Ladder initLadder(final int personCount) {
        final int height = inputView.inputHeight();
        return Ladder.from(height, personCount, new RandomPathGenerator());
    }

    private void searchMatches(PresentMatches presentMatches, People people) {
        String finding = inputView.inputFinding();
        if (finding.equals("all")) {
            printAllMatches(presentMatches, people);
            return;
        }
        PersonName personName = new PersonName(finding);
        Present present = presentMatches.findByPersonName(personName);
        outputView.printMatched(present.name());
    }

    private void printAllMatches(PresentMatches presentMatches, People people) {
        List<PersonName> names = people.getPersonNames();
        names.forEach(personName -> {
            Present present = presentMatches.findByPersonName(personName);
            outputView.printMatched(personName.name(), present.name());
        });
    }
}
