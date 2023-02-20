package domain;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private static final String DUPLICATE_NAME_ERROR = "[ERROR] 중복된 이름입니다.";
    private static final String SIZE_ERROR = "[ERROR] 2명 이상 입력해야 합니다.";
    private static final int MIN_SIZE = 2;

    private final List<Player> players = new ArrayList<>();

    public Players(List<String> names) {
        validateDuplicateName(names);
        validatePlayersSize(names);
        addPlayer(names);
    }

    private static void validatePlayersSize(List<String> names) {
        if (names.size() < MIN_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    public List<String> getPlayersName() {
        List<String> names = new ArrayList<>();

        for (Player player : players) {
            names.add(player.getName());
        }
        return names;
    }

    private void validateDuplicateName(List<String> names) {
        if (isDuplicated(names)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
        }
    }

    private boolean isDuplicated(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }

    private void addPlayer(List<String> names) {
        for (String name : names) {
            players.add(new Player(name));
        }
    }

}
