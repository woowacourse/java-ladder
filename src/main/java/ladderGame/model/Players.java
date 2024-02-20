package ladderGame.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {
    private final List<Player> players;

    public Players(List<String> names) {
        validateDuplicationName(names);

        players = new ArrayList<>();
        for(String name : names) {
            players.add(new Player(name));
        }
    }

    private void validateDuplicationName(List<String> name) {
        if(new HashSet<>(name).size() != name.size()) {
            throw new IllegalArgumentException("참여자들의 이름은 중복될 수 없습니다.");
        }
    }
}
