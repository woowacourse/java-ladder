package domain;

import java.util.HashSet;
import java.util.List;

public class Names {

    private static final int MIN_COUNT = 2;

    private final List<PlayerName> playerNames;

    public Names(List<PlayerName> playerNames) {
        validate(playerNames);
        this.playerNames = playerNames;
    }

    public int getNameCount() {
        return playerNames.size();
    }

    public List<PlayerName> getNames() {
        return List.copyOf(playerNames);
    }

    public int indexOf(String input) {
        int index = playerNames.indexOf(new PlayerName(input));
        if (index == -1) {
            throw new IllegalArgumentException("[ERROR] 해당하는 이름을 찾을 수 없습니다");
        }
        return index;
    }

    private void validate(List<PlayerName> playerNames) {
        validateUnique(playerNames);
        validateEntryAmount(playerNames);
    }

    private void validateUnique(List<PlayerName> playerNames) {
        if (playerNames.size() != new HashSet<>(playerNames).size()) {
            throw new IllegalArgumentException("[ERROR] 이름은 중복될 수 없습니다");
        }
    }

    private void validateEntryAmount(List<PlayerName> playerNames) {
        if (playerNames.size() < MIN_COUNT) {
            throw new IllegalArgumentException("[ERROR] 참여 인원은 " + MIN_COUNT + "명 이상이어야 합니다");
        }
    }
}
