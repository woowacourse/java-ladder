package ladder.domain;

import ladder.Const;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private List<Player> players;

    public LadderLine(String name) {
        this.players = regePlayers(name.replaceAll(" ",""));
    }

    private List<Player> regePlayers(String name) {
        List<String> names = checkNames(name);
        List<Player> players = new ArrayList<>();
        for (String s : names) {
            players.add(new Player(s));
        }
        return players;
    }

    private List<String> checkNames(String name) {
        List<String> names = Arrays.asList(name.split(","));
        if (names.size() <= Const.ZERO) {
            throw new IllegalArgumentException(Const.NAME_EX);
        }
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
