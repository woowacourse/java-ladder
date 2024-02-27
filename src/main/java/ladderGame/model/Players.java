package ladderGame.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Players {
    private static final String EXCEPTION_MESSAGE_DUPLICATION_NAME = "참여자들의 이름은 중복될 수 없습니다.";
    private static final String EXCEPTION_MESSAGE_LESS_THAN_MINIMUM = "참여자의 이름은 두 개 이상이어야 합니다.";
    private static final int MINIMUM_NAME_COUNT = 2;

    private final List<Player> players;

    public Players(List<String> names) {
        validate(names);

        AtomicInteger position = new AtomicInteger();
        players = names.stream()
                .map((String name) -> new Player(name, position.getAndIncrement()))
                .toList();
    }

    private void validate(List<String> names) {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_DUPLICATION_NAME);
        }
        if (names.size() < MINIMUM_NAME_COUNT) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_LESS_THAN_MINIMUM);
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
        List<Integer> positions = new ArrayList<>();
        for(Player player : players) {
            positions.add(player.getPosition());
        }

        return positions;
    }

    public boolean contains(Name name) {
        for(Player player : players) {
            if(player.hasName(name)) {
                return true;
            }
        }

        return false;
    }

    public Player findPlayer(Name name) {
        return players.stream()
                .filter(player -> player.hasName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("일치하는 정보가 없습니다."));
    }
}
