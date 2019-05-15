package ladder.domain;

import ladder.Const;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Player {
    private final String name;

    public Player(String name) {
        checkName(name);
        this.name = name;
    }

    private void checkName(String name) {
        if (name.length() > Const.MAX_NAME_LENGTH || StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(Const.EX_NAME);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
