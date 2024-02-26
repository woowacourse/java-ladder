package ladder.controller;

import ladder.model.Ladder;
import ladder.model.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.io.IOException;
import java.util.List;

public class LadderController {
    private Players ladderPlayers;
    private Ladder ladder;

    public void start() throws IOException {
        init();
        printResult();
    }

    private void init() throws IOException {
        ladderPlayers = Players.from(readPlayerNames());

        int height = readLadderHeight();
        int width = ladderPlayers.getSize();
        ladder = Ladder.of(height, width);
    }

    private List<String> readPlayerNames() throws IOException {
        return InputView.inputPlayerNames();
    }

    private int readLadderHeight() throws IOException {
        return InputView.inputLadderHeight();
    }

    private void printResult() {
        OutputView.printResultDescription();
        OutputView.printPlayerNames(ladderPlayers.getPlayerNames());
        OutputView.printLadder(ladder.toLineDtoList());
    }
}
