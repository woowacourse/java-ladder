package ladder.model;

import java.util.*;

public class Players implements Iterable<Player> {
    private static final int MIN_PLAYER_NUMBER = 2;
    private List<Player> players;

    public Players(String[] names) {
        if (names.length < MIN_PLAYER_NUMBER) {
            throw new IllegalArgumentException("플레이어는 2명 이상이어야 합니다.");
        }
        if (this.isDuplicatedName(names)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
        this.playersInit(names);
    }

    public boolean isContains(String name) {
        return this.players.contains(new Player(name));
    }

    int getPlayersNumber() {
        return this.players.size();
    }

    Player getPlayerByName(String name) {
        return this.players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("없는 이름의 플레이어 입니다."));
    }

    Player getPlayerByIndex(int index) {
        return this.players.get(index);
    }

    private boolean isDuplicatedName(String[] names) {
        return names.length != new HashSet<>(Arrays.asList(names)).size();
    }

    private void playersInit(String[] names) {
        this.players = new ArrayList<>();
        Arrays.stream(names).forEach(name -> this.players.add(new Player(name)));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.players.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Player> iterator() {
        return this.players.iterator();
    }
}
