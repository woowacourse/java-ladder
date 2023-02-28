package domain.player;

import domain.ladder.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(List<String> names) {
        validate(names);
        players = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i), i));
        }
    }

    public void move(Line line) {
        for (Player player : players) {
            MoveType moveType = MoveType.getMoveTypeByPosition(player, line);
            player.move(moveType);
        }
    }

    private void validate(List<String> names) {
        validateDuplicatedNames(names);
    }

    private void validateDuplicatedNames(List<String> names) {
        if (hasDuplicatedName(names)) {
            throw new IllegalArgumentException("사다리 게임 참여자의 이름은 중복이 없어야합니다.");
        }
    }

    private boolean hasDuplicatedName(List<String> names) {
        return getDistinctNameCount(names) != names.size();
    }

    private long getDistinctNameCount(List<String> names) {
        return names.stream()
                .map(String::trim)
                .distinct()
                .count();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getPlayerSize() {
        return players.size();
    }
}
