package domain.player;

import java.util.*;
import java.util.stream.Collectors;

public record Players(LinkedHashMap<String, Player> members) {
    private static final int PLAYER_LENGTH_MIN = 2;
    private static final int PLAYER_LENGTH_MAX = 10;

    public Players {
        validatePlayerNumber(members);
        validateNamesUniqueness(members);
    }

    public Players(final String[] names) {
        this(Arrays.stream(names)
                .collect(
                        Collectors.toMap(
                                name -> name,
                                Player::new,
                                (a, b) -> a,
                                LinkedHashMap::new
                        )
                ));
    }

    private void validatePlayerNumber(Map<String, Player> members) {
        if (PLAYER_LENGTH_MIN > members.size() || members.size() > PLAYER_LENGTH_MAX) {
            final String errorMessage = String.format("%d명 이상 %d명 이하의 플레이어를 입력해 주세요.", PLAYER_LENGTH_MIN, PLAYER_LENGTH_MAX);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateNamesUniqueness(Map<String, Player> members) {
        if (members.size() != members.keySet().stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다.");
        }
    }

    public int getSequence(final Player player) {
        int sequence = 0;
        for (Player member : members.values()) {
            if (member.equals(player)) {
                return sequence;
            }
            sequence++;
        }
        throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
    }

    public int size() {
        return this.members.size();
    }

    public Optional<Player> findByName(final String name) {
        return Optional.ofNullable(this.members.get(name));
    }

    public List<Player> getMembers() {
        return new ArrayList<>(this.members.values());
    }
}
