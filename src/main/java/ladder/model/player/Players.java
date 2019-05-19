package ladder.model.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class Players implements Iterable<Player> {
    private static final int MIN_PLAYER_NUMBER = 2;
    private static final String NAME_SPACE_FORMAT = "%-6s";
    private List<Player> players = new ArrayList<>();

    public Players(String[] names) {
        if (names.length < MIN_PLAYER_NUMBER) {
            throw new IllegalArgumentException("플레이어는 2명 이상이어야 합니다.");
        }
        if (this.isDuplicatedName(names)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }

        IntStream.range(0, names.length).forEach(i -> players.add(new Player(names[i], i)));
    }

    private boolean isDuplicatedName(String[] names) {
        return names.length != new HashSet<>(Arrays.asList(names)).size();
    }

    public boolean isContains(String name) {
        return players.stream().anyMatch(player -> player.getName().equals(name));
    }

    public int getPositionByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입력된 이름의 플레이어가 없습니다."))
                .getPosition();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        players.forEach(player -> stringBuilder.append(String.format(NAME_SPACE_FORMAT, player)));
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }
}
