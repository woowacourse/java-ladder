package domain.player;

import java.util.List;

public class PlayerNames {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_PLAYER_COUNT = 10;

    private final List<PlayerName> playerNames;

    public PlayerNames(final List<PlayerName> playerNames) {
        validateCount(playerNames.size());
        this.playerNames = playerNames;
    }

    public static PlayerNames from(final List<String> rawNames) {
        final List<PlayerName> playerNames = rawNames.stream()
                .map(PlayerName::new)
                .toList();
        return new PlayerNames(playerNames);
    }

    private void validateCount(final int count) {
        if (count < MIN_PLAYER_COUNT || count > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("참가자 수는 %d명 이상 %d명 이하 이어야 합니다.", MIN_PLAYER_COUNT, MAX_PLAYER_COUNT));
        }
    }

    public PlayerName findBy(final int index) {
        return playerNames.get(index);
    }

    public List<String> getValues() {
        return playerNames.stream()
                .map(PlayerName::value)
                .toList();
    }

    public int count() {
        return playerNames.size();
    }
}
