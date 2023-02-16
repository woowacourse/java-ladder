package ladder.controller;

import ladder.domain.People;
import ladder.domain.RandomRowsGenerator;
import ladder.domain.Rows;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;
    private final RandomRowsGenerator randomRowsGenerator;

    public LadderController(InputView inputView, ResultView resultView, RandomRowsGenerator randomRowsGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.randomRowsGenerator = randomRowsGenerator;
    }

    public void run() {
        List<String> names = inputView.inputParticipants();
        People players = People.from(names);
        int ladderHeight = inputView.inputHeight();
        Rows rows = randomRowsGenerator.generateRows(players.getPeopleSize() - 1, ladderHeight);
        resultView.printNames(players.getNames());
        resultView.printLadder(rows.getState());
    }
}
