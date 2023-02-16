package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    public static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    private static final int STANDARD_BLANK = 7;
    private static final String DELIMITER = ",";
    private static final String DELIMITER_WITH_BLANK = "\\s*,\\s*";
    private static final String INPUT_PLAYER_ERROR_MESSAGE = "[ERROR] 구분자 ,를 이용하여 두 명 이상 입력해야 합니다.";

    private final List<Player> players;

    public Players(String names) {
        validateDelimiter(names);
        List<String> splitNames = getSplitNames(names);
        validateMoreThanOnePlayer(splitNames);
        this.players = createPlayer(splitNames);
    }

    private List<String> getSplitNames(String names) {
        return List.of(names.split(DELIMITER_WITH_BLANK));
    }

    private void validateMoreThanOnePlayer(List<String> splitNames) {
        if (splitNames.size() < MINIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException(INPUT_PLAYER_ERROR_MESSAGE);
        }
    }

    private void validateDelimiter(String names) {
        if (!names.contains(DELIMITER)) {
            throw new IllegalArgumentException(INPUT_PLAYER_ERROR_MESSAGE);
        }
    }

    private List<Player> createPlayer(List<String> splitNames) {
        return splitNames.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int getNumberOfPlayers() {
        return this.players.size();
    }

    public String getPlayersNames() {
        StringBuilder sb = new StringBuilder();

        for (Player player : players) {
            sb.append(player.getName());
            String blank = " ".repeat(STANDARD_BLANK - player.getName().length());
            sb.append(blank);
        }

        return sb.toString();
    }
}
