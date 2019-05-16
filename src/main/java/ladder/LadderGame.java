package ladder;

import ladder.domain.CrossbarGenerator;
import ladder.domain.Ladder;
import ladder.domain.PlayerGroup;
import ladder.domain.RandomCrossbarGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGame {
    private static final int LAST_DUMMY_SPACE = 1;

    public static void main(String[] args) {
        PlayerGroup players = getPlayers();
        CrossbarGenerator randomCrossbarGenerator = new RandomCrossbarGenerator(players.size() + LAST_DUMMY_SPACE);
        Ladder ladder = getLadderBy(randomCrossbarGenerator);

        OutputView.showPlayersAndLadder(players, ladder);
    }

    private static Ladder getLadderBy(CrossbarGenerator crossbarGenerator) {
        try {
            return new Ladder(getHeight(), crossbarGenerator);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLadderBy(crossbarGenerator);
        }
    }

    private static int getHeight() {
        try {
            return Integer.parseInt(InputView.inputHeight());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해야 합니다.");
            return getHeight();
        }
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
