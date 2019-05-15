package ladder;

import ladder.domain.PlayerGroup;
import ladder.view.InputView;

import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        PlayerGroup players = getPlayers();
    }

    private static PlayerGroup getPlayers() {
        List<String> playerNames;

        try {
            playerNames = InputView.inputPlayerName();
            return new PlayerGroup(playerNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayers();
        }
    }
}
