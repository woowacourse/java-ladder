package player;

import java.util.List;

public class Players {

    private static final int MIN_PLAYER_SIZE = 2;
    private static final int MAX_PLAYER_SIZE = 10;

    private final List<Player> players;

    public Players(List<String> playerNames) {
        validateSize(playerNames);
        this.players = playerNames.stream()
                .map(Player::new)
                .toList();
    }

    private void validateSize(List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYER_SIZE || playerNames.size() > MAX_PLAYER_SIZE) {
            throw new IllegalArgumentException("참여자의 수는 2명 이상 10명 이하로 작성해야 합니다.");
        }
    }

    public int findIndexByName(String name) {
        int index = players.indexOf(new Player(name));
        validateNameFound(index);
        return index;
    }

    private void validateNameFound(int index) {
        if (index == -1) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다.");
        }
    }

    public String getNameByIndex(int index) {
        validateIndex(index);
        return players.get(index).getName();
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= players.size()) {
            throw new IllegalArgumentException("인덱스를 벗어납니다.");
        }
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .toList();
    }

    public int size() {
        return players.size();
    }
}
