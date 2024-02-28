package controller;

import dto.Result;
import java.util.List;
import model.Items;
import model.Ladder;
import model.People;
import model.line.RandomLinesGenerator;
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
        final Items items = initItems();

        final Result result = Result.from(people, ladder, items);
        outputView.printResult(result);
    }

    // TODO: 구현
    private Items initItems() {
        return null;
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
