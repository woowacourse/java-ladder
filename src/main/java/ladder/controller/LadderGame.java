package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final RandomRowsGenerator randomRowsGenerator;

    public LadderGame(InputView inputView, ResultView resultView, RandomRowsGenerator randomRowsGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.randomRowsGenerator = randomRowsGenerator;
    }

    public void run() {
        try {
            Players players = enroll();
            Ladder ladder = makeLadder(players.getPlayersSize());
            printLadderResult(players, ladder);
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
        }

    }

    private Players enroll() {
        List<String> names = inputView.inputParticipants();
        Players players = Players.from(names);
        return players;
    }

    private Ladder makeLadder(int playersSize) {
        Height height = new Height(inputView.inputHeight());
        Width width = new Width(getWidthSize(playersSize));
        return randomRowsGenerator.generateRows(width, height);
    }

    private int getWidthSize(int playersSize){
        return playersSize - 1;
    }

    private void printLadderResult(Players players, Ladder ladder) {
        resultView.printNames(players.getNames());
        resultView.printLadder(ladder.getState());
    }
}
