package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderSize;
import ladder.model.Player;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.io.IOException;
import java.util.List;

public class LadderController {
    private List<Player> ladderPlayers;
    private Ladder ladder;

    public void init() throws IOException {
        ladderPlayers = readPlayerNames().stream()
                .map(Player::new)
                .toList();

        LadderSize ladderSize = new LadderSize(readLadderHeight(), ladderPlayers.size());
        ladder = Ladder.of(ladderSize);
    }

    private List<String> readPlayerNames() throws IOException {
        return InputView.inputPlayerNames();
    }

    private int readLadderHeight() throws IOException {
        return InputView.inputLadderHeight();
    }

    public void printResult() {
        List<String> playerNames = ladderPlayers.stream()
                .map(Player::getName)
                .toList();

        OutputView.printResultDescription();
        OutputView.printPlayerNames(playerNames);
        OutputView.printLadder(ladder.toLineDtoList());
    }
}
