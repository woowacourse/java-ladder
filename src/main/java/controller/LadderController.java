package controller;

import domain.model.Ladder;
import domain.model.People;
import view.InputView;
import view.ResultView;

public class LadderController {

    private final ResultView resultView;
    private final InputView inputView;

    public LadderController(ResultView resultView, InputView inputView) {
        this.resultView = resultView;
        this.inputView = inputView;
    }

    public void make() {
        People people = new People(inputView.askParticipants());
        Ladder ladder = new Ladder(inputView.askLadderHeight(), people.numberOfParticipant());

        resultView.printResult(people, ladder);
    }

}
