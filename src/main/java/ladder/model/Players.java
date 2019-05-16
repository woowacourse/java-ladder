package ladder.model;

import java.util.*;

public class Players {
    private static final int MIN_PLAYER_NUMBER = 2;
    private List<Player> players = new ArrayList<>();

    public Players(String[] names) {
        if (names.length < MIN_PLAYER_NUMBER) {
            throw new IllegalArgumentException("플레이어는 2명 이상이어야 합니다.");
        }
        if (this.isDuplicatedName(names)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
        this.playersInit(names);
    }

    private boolean isDuplicatedName(String[] names) {
        return names.length != new HashSet<>(Arrays.asList(names)).size();
    }

    private void playersInit(String[] names) {
        for (int i = 0; i < names.length; i++) {
            players.add(new Player(names[i], i));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players) {
            stringBuilder.append(String.format("%-6s", player));
        }
        return stringBuilder.toString();
    }
}
