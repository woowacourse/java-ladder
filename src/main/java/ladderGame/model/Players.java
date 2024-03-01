package ladderGame.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Players {
    private static final int MINIMUM_NAME_COUNT = 2;

    private final List<Player> players;

    public Players(List<String> names) {
        validate(names);

        this.players = IntStream.range(0, names.size())
                .mapToObj(i -> new Player(names.get(i), i))
                .toList();
    }

    private void validate(List<String> names) {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException("참여자들의 이름은 중복될 수 없습니다.");
        }
        if (names.size() < MINIMUM_NAME_COUNT) {
            throw new IllegalArgumentException("참여자의 이름은 두 개 이상이어야 합니다.");
        }
    }

    public int getPlayerSize() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public void move(Line line) {
        for(Player player : players) {
            player.move(line);
        }
    }

    public List<Integer> getPositions() {
        return players.stream()
                .map(Player::getPosition)
                .toList();
    }

    public boolean contains(Name name) {
        return players.stream()
                .anyMatch(player -> player.equalsName(name));
    }

    public Player findPlayer(Name name) {
        return players.stream()
                .filter(player -> player.equalsName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("일치하는 정보가 없습니다."));
    }
}
