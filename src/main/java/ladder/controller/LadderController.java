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
        List<String> playerNames = InputView.inputPlayerNames();
        ladderPlayers = playerNames.stream()
                .map(Player::new)
                .toList();

        int height = InputView.inputLadderHeight();
        LadderSize ladderSize = new LadderSize(height, playerNames.size());

        ladder = Ladder.of(ladderSize);
    }

    public void printResult() {
        OutputView.printResultDescription();
        OutputView.printPlayerNames(ladderPlayers.stream().map(Player::getName).toList());
    }
}
