package ladder.view;

import ladder.domain.PlayerName;
import ladder.domain.Players;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class OutputView {
    private static final int PADDING_WIDTH = 5;

    public static void printPlayerNames(Players players) {
        List<PlayerName> names = players.getPlayerNames();
        for (PlayerName name : names) {
            System.out.printf("%s ", StringUtils.center(name.getName(), PADDING_WIDTH));
        }
        System.out.println();
    }
}
