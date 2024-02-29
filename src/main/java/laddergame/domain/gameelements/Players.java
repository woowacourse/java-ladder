package laddergame.domain.gameelements;

import java.util.List;

public class Players {
    private static final int MIN_PLAYER_NUMBER = 1;
    private static final int MAX_PLAYER_NUMBER = 100;
    private static final String RESERVED_NAME = "all";

    private final List<Name> playerNames;

    public Players(List<String> playerNames) {
        validatePlayerNumber(playerNames);
        validateReservedName(playerNames);
        this.playerNames = playerNames.stream()
                .map(Name::new)
                .toList();
    }

    private void validatePlayerNumber(List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYER_NUMBER || playerNames.size() > MAX_PLAYER_NUMBER) {
            throw new IllegalArgumentException("게임 참여자의 수는 1이상 100이하만 가능합니다.");
        }
    }

    private void validateReservedName(List<String> playerNames) {
        if (playerNames.contains(RESERVED_NAME)) {
            throw new IllegalArgumentException("예약어 " + RESERVED_NAME + "은 이름으로 지정할 수 없습니다.");
        }
    }

    public List<Name> getPlayerNames() {
        return playerNames;
    }
}
