package controller;

import dto.Result;
import java.util.List;
import model.Ladder;
import model.People;
import model.path.RandomLinesGenerator;
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
        final Ladder ladder = initLadder(people.getPersonCount());

        final Result result = Result.from(people, ladder);
        outputView.printResult(result);
    }


    private People initPeople() {
        final List<String> names = inputView.inputNames();
        return People.from(names);
    }

    private Ladder initLadder(final int personCount) {
        final int height = inputView.inputHeight();
        return Ladder.from(height, personCount, new RandomLinesGenerator());
    }
}
