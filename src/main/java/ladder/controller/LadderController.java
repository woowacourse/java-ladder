package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LadderGenerator ladderGenerator;

    public LadderController(InputView inputView, ResultView resultView, LadderGenerator ladderGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.ladderGenerator = ladderGenerator;
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
        LadderHeight ladderHeight = new LadderHeight(inputView.inputHeight());
        LadderWidth ladderWidth = new LadderWidth(playersSize - 1);
        return ladderGenerator.generate(ladderWidth, ladderHeight);
    }

    private void printLadderResult(Players players, Ladder ladder) {
        resultView.printNames(players.getNames());
        resultView.printLadder(ladder.getState());
    }
}
