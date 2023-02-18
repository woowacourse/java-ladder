package ladder.controller;

import ladder.domain.*;
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
        try {
            Players players = enroll();
            Rows rows = makeLadder(players.getPlayersSize());
            printLadderResult(players, rows);
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
        }

    }

    private Players enroll() {
        List<String> names = inputView.inputParticipants();
        Players players = Players.from(names);
        return players;
    }

    private Rows makeLadder(int playersSize) {
        Height height = new Height(inputView.inputHeight());
        Width width = new Width(playersSize - 1);
        return randomRowsGenerator.generateRows(width, height);
    }

    private void printLadderResult(Players players, Rows rows) {
        resultView.printNames(players.getNames());
        resultView.printLadder(rows.getState());
    }
}
