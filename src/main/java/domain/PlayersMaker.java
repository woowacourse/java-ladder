package domain;

import java.util.List;
import java.util.stream.Collectors;

public class PlayersMaker {

    private static final String DELIMITER_WITH_BLANK = "\\s*,\\s*";

    public static Players makePlayers(String playersName) {
        List<String> splitNames = getSplitNames(playersName);
        List<Player> player = createPlayer(splitNames);

        return new Players(player);
    }

    private static List<String> getSplitNames(String names) {
        return List.of(names.split(DELIMITER_WITH_BLANK));
    }

    private static List<Player> createPlayer(List<String> splitNames) {
        return splitNames.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }
}
