package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    private static final String DELIMITER_WITH_BLANK = "\\s*,\\s*";

    private final List<Player> players;

    public Players(String names) {
        List<String> splitNames = getSplitNames(names);
        validateMoreThanOnePlayer(splitNames);
        this.players = createPlayer(splitNames);
    }

    private List<String> getSplitNames(String names) {
        return List.of(names.split(DELIMITER_WITH_BLANK));
    }

    private void validateMoreThanOnePlayer(List<String> splitNames) {
        if (splitNames.size() < MINIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("[ERROR] 두 명 이상 입력해야 합니다.");
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

    public List<Player> getPlayers() {
        return players;
    }
}
