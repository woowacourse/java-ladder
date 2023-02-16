package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(String names) {
        validateDelimiter(names);
        List<String> splitNames = getSplitNames(names);
        validateMoreThanOnePlayer(splitNames);
        this.players = createPlayer(splitNames);
    }

    private List<String> getSplitNames(String names) {
        return List.of(names.split("\\s*,\\s*"));
    }

    private void validateMoreThanOnePlayer(List<String> splitNames) {
        if (splitNames.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 플레이어는 두 명 이상 입력되어야 합니다.");
        }
    }

    private void validateDelimiter(String names) {
        if (!names.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 구분자는 쉼표여야 합니다.");
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
            String blank = " ".repeat(7 - player.getName().length());
            sb.append(blank);
        }

        return sb.toString();
    }
}
