package ladder.controller;

import ladder.model.LadderSize;
import ladder.model.Player;
import ladder.view.InputView;

import java.io.IOException;
import java.util.List;

public class LadderController {
    public void init() throws IOException {
        List<String> playerNames = InputView.inputPlayerNames();
        List<Player> ladderPlayers = playerNames.stream()
                .map(Player::new)
                .toList();

        int height = InputView.inputLadderHeight();
        LadderSize ladderSize = new LadderSize(height, playerNames.size());
    }
}
