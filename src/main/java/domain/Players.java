package domain;

import java.util.ArrayList;
import java.util.List;

public class Players {

    static final String DUPLICATE_NAME_ERROR = "[ERROR] 중복된 이름입니다.";
    static final String SIZE_ERROR = "[ERROR] 2명 이상 입력해야 합니다.";
    static final String TARGET_PLAYER_EXIST_ERROR = "[ERROR] 없는 참가자입니다.";

    private static final int MIN_SIZE = 2;

    private final List<Player> players = new ArrayList<>();

    public Players(List<String> names) {
        validateDuplicateName(names);
        validatePlayersSize(names);
        addPlayer(names);
    }

    private void validatePlayersSize(List<String> names) {
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

    public int getSize() {
        return players.size();
    }

    public void validateTargetPlayer(String targetPlayer) {
        if (!hasTargetPlayer(targetPlayer)) {
            throw new IllegalArgumentException(TARGET_PLAYER_EXIST_ERROR);
        }
    }

    private boolean hasTargetPlayer(String targetPlayer) {
        return players.stream()
                .anyMatch(player -> player.isTargetPlayer(targetPlayer));
    }

}
