package domain;

import java.util.List;

public class Players {

    private static final int MINIMUM_PLAYER_SIZE = 2;
    private static final int MAXIMUM_PLAYER_SIZE = 10;

    private final List<Player> players;

    public Players(List<String> playerNames) {
        validate(playerNames);
        this.players = generatePlayers(playerNames);
    }

    private void validate(List<String> playerNames) {
        if (validateRange(playerNames)) {
            throw new IllegalArgumentException(
                    String.format("2명 이상, 10명 이하인 인원만 입력해주세요. 입력한 인원 : %d", playerNames.size()));
        } else if (hasDuplication(playerNames)) {
            throw new IllegalArgumentException(
                    String.format("이름은 중복될 수 없습니다."));
        }
    }

    private boolean validateRange(List<String> playerNames) {
        return playerNames.size() < MINIMUM_PLAYER_SIZE || playerNames.size() > MAXIMUM_PLAYER_SIZE;
    }

    private boolean hasDuplication(List<String> playerNames) {
        return playerNames.size() > playerNames.stream().distinct().count();
    }

    private List<Player> generatePlayers(List<String> names) {
        return names.stream()
                .map(Player::new)
                .toList();
    }

    public int getSize() {
        return this.players.size();
    }

    public List<String> getNames() {
        return players.stream().map(Player::getName).toList();
    }
}
