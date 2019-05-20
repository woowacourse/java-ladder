package ladder.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlayerFactory {

    public static List<Player> createAll(List<String> names) throws DuplicatedNameException {
        if (hasDuplicatedName(names)) {
            throw new DuplicatedNameException("중복된 이름이 존재합니다");
        }
        return names.stream().map(name -> new Player(name)).collect(Collectors.toList());
    }

    private static boolean hasDuplicatedName(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        return nameSet.size() != names.size();
    }
}
