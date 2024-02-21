package controller;

import dto.Result;
import java.util.List;
import model.Ladder;
import model.People;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        People people = initPeople();
        Ladder ladder = initLadder(people.getPersonCount());

        Result result = Result.from(people, ladder);
        outputView.printResult(result);
    }


    private People initPeople() {
        List<String> names = inputView.inputNames();
        return People.from(names);
    }

    private Ladder initLadder(int personCount) {
        int height = inputView.inputHeight();
        return Ladder.from(height, personCount);
    }
}
