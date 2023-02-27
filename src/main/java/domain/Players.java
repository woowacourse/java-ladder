package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    public static final int MIN_PERSON_COUNT = 2;

    private final List<Player> players;

    public Players(List<String> names) {
        validateDuplicate(names);
        List<Player> players = toList(names);
        validatePersonCount(players);
        this.players = players;
    }

    private void validateDuplicate(List<String> result) {
        if (result.size() != result.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    private List<Player> toList(List<String> names) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i), i));
        }
        return Collections.unmodifiableList(players);
    }

    private void validatePersonCount(List<Player> people) {
        if (people.size() < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException(
                    String.format("사람은 %d명 이상이어야 합니다.", MIN_PERSON_COUNT));
        }
    }

    public Column findColumn(Player player) {
        Player findPlayer = players.stream()
                .filter(m -> m.equals(player))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자는 존재하지 않습니다."));
        return findPlayer.getColumn();
    }

    public List<Player> getPlayers() {
        return players.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public int getCount() {
        return players.size();
    }
}
