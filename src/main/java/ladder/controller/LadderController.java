package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderSize;
import ladder.model.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.io.IOException;
import java.util.List;

public class LadderController {
    private Players ladderPlayers;
    private Ladder ladder;

    public void init() throws IOException {
        ladderPlayers = Players.from(readPlayerNames());

        LadderSize ladderSize = new LadderSize(readLadderHeight(), ladderPlayers.getSize());
        ladder = Ladder.of(ladderSize);
    }

    private List<String> readPlayerNames() throws IOException {
        return InputView.inputPlayerNames();
    }

    private int readLadderHeight() throws IOException {
        return InputView.inputLadderHeight();
    }

    public void printResult() {
        OutputView.printResultDescription();
        OutputView.printPlayerNames(ladderPlayers.getPlayerNames());
        OutputView.printLadder(ladder.toLineDtoList());
    }
}
