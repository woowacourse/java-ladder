package laddergame.domain.gameelements;

import java.util.ArrayList;
import java.util.List;

public class Players {
    // TODO 이름 기반으로 객체 반환 메서드
    private static final int MIN_PLAYER_NUMBER = 1;
    private static final int MAX_PLAYER_NUMBER = 100;

    private final List<Player> players;

    public Players(List<String> players) {
        validatePlayerNumber(players);

        this.players = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            Name playerName = new Name(players.get(i));
            Position position = new Position(i);
            this.players.add(new Player(playerName, position));
        }
    }

    public Player findPlayerByName(String playerName) {
        return players.stream()
                .filter(player -> player.getName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("참여하지 않은 플레이어의 이름을 조회했습니다."));
    }

    public int count() {
        return players.size();
    }

    private void validatePlayerNumber(List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYER_NUMBER || playerNames.size() > MAX_PLAYER_NUMBER) {
            throw new IllegalArgumentException("게임 참여자의 수는 "+MIN_PLAYER_NUMBER+"이상 "+MAX_PLAYER_NUMBER+"만 가능합니다.");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
