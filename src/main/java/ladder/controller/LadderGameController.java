package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGameController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LadderGenerator ladderGenerator;

    public LadderGameController(InputView inputView, ResultView resultView, LadderGenerator ladderGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.ladderGenerator = ladderGenerator;
    }

    public void run() {
        try {
            List<String> participantNames = inputView.readParticipantNames();
            Players players = Players.from(participantNames);

            LadderHeight height = new LadderHeight(inputView.inputLadderHeight());
            LadderWidth width = new LadderWidth(players.getCount() - 1);
            Ladder ladder = ladderGenerator.generate(width, height);

            printLadderResult(players, ladder);
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
        }
    }

    private void printLadderResult(Players players, Ladder ladder) {
        resultView.printPlayersName(players.getNames());
        resultView.printLadder(ladder.getFootholdsPosition());
    }
}
