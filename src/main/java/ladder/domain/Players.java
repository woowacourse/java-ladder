package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players implements Names {
    private final List<Player> players;

    Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<String> names) throws DuplicatedNameException {
        List<Player> players = names.stream().map(name -> Player.from(name)).collect(Collectors.toList());
        validate(names);

        return new Players(players);
    }

    private static void validate(List<String> names) throws DuplicatedNameException {
        if (DuplicationChecker.hasDuplication(names)) {
            throw new DuplicatedNameException("중복된 이름이 존재합니다.");
        }
    }

    @Override
    public int size() {
        return players.size();
    }

    @Override
    public String getName(int i) {
        return players.get(i).getName();
    }

    public boolean contains(Player player) {
        return players.contains(player);
    }

    public int indexOf(Object o) {
        return players.indexOf(o);
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }
}
