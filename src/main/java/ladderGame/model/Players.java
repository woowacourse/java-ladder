package ladderGame.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Players {
    private static final String EXCEPTION_MESSAGE_DUPLICATION_NAME = "참여자들의 이름은 중복될 수 없습니다.";
    private static final String EXCEPTION_MESSAGE_LESS_THAN_MINIMUM = "참여자의 이름은 두 개 이상이어야 합니다.";
    private static final int MINIMUM_NAME_COUNT = 2;

    private final List<Player> players;

    public Players(List<String> names) {
        validate(names);

        players = names.stream().map(Player::new).toList();
    }

    private void validate(List<String> names) {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_DUPLICATION_NAME);
        }
        if (names.size() < MINIMUM_NAME_COUNT) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_LESS_THAN_MINIMUM);
        }
    }

    public Integer indexOf(String name) {
        OptionalInt position = IntStream.range(0, players.size())
                .filter(i -> players.get(i).getName().equals(name))
                .findFirst();

        if (position.isEmpty()) {
            return null;
        }
        return position.getAsInt();
    }

    public int getPlayerSize() {
        return players.size();
    }

    public Player getPlayer(int position) {
        return players.get(position);
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }
}
