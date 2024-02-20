package view;

import java.util.List;
import model.Players;

public class OutputView {
    private static final String PLAYER_NAMES_FORMAT = "%5s";
    private static final String PLAYER_NAMES_DELIMITER = " ";

    public static void printPlayerNames(Players players) {
        List<String> names = players.getPlayerNames()
                .stream()
                .map((name) -> String.format(PLAYER_NAMES_FORMAT, name))
                .toList();
        String result = String.join(PLAYER_NAMES_DELIMITER, names);
        System.out.println(result);
    }
}
