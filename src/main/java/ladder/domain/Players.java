package ladder.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players implements Names {
    private final List<Player> players;

    Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<String> names) throws DuplicatedNameException {
        List<Player> players = names.stream().map(name -> Player.from(name)).collect(Collectors.toList());
        if (hasDuplicatedNames(names)) {
            throw new DuplicatedNameException("중복된 이름이 존재합니다.");
        }

        return new Players(players);
    }

    private static boolean hasDuplicatedNames(List<String> names) {
        Set<String> set = new HashSet<>(names);
        return set.size() != names.size();
    }

    @Override
    public int size() {
        return players.size();
    }

    @Override
    public String getName(int i) {
        return players.get(i).getName();
    }
}
